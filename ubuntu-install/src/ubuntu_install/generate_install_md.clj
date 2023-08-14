(ns ubuntu-install.generate-install-md
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [clojure.java.shell :as sh]
            [clojure.string :as str]
            ))

(defn get-meta-edn-files
  [{:keys [dir] :as w}]
  (assoc w
         :meta-edn-files
         (keep
          (fn [dir*]
            (let [meta-edn (io/file dir*
                                    "meta.edn")]
              (when (.exists meta-edn)
                meta-edn)))
          (filter
           (memfn isDirectory)
           (.listFiles (io/file dir))))))

(defn read-entries
  [w]
  (assoc w
         :entries
         (map
          (fn [meta-edn-file]
            (assoc (edn/read-string (slurp meta-edn-file))
                   :meta-edn-file meta-edn-file
                   :dir-name (.getName (.getParentFile meta-edn-file))))
          (:meta-edn-files w))))

(defn get-latest-commit
  [dir]
  (:out
   (sh/sh
    "git" "log" "-n" "1" "--pretty=format:%H" "--" "."
    :dir (io/file dir))))

(defn add-latest-commits
  [w]
  (update w
          :entries
          (fn [entries]
            (map (fn [entry]
                   (assoc entry
                          :latest-commit
                          (get-latest-commit (.getParentFile (:meta-edn-file entry)))))
                 entries))))

(defn get-origin-git-url
  [dir]
  (str/trim
   (:out
    (sh/sh
     "git" "remote" "get-url" "origin"
     :dir (io/file dir)))))

(defn extract-path
  [origin-git-url]
  (second
   (re-find #".*?:(.*)\.git"
            origin-git-url)))

(defn github-base-url
  [dir]
  (str "https://raw.githubusercontent.com/"
       (extract-path (get-origin-git-url dir))))

(defn github-install-command
  [entry]
  (let [meta-edn-file (:meta-edn-file entry)
        base-url (github-base-url (.getCanonicalPath (.getParentFile (:meta-edn-file entry))))]
    (str "curl -sS '"
         base-url "/"
         (:latest-commit entry) "/"
         (.getName (.getParentFile meta-edn-file)) "/install' | bash")))

(defn add-github-install-commands
  [w]
  (update w
          :entries
          (fn [entries]
            (map
             (fn [entry]
               (assoc entry :install-command (github-install-command entry)))
             entries))))

(defn entry-markdown
  [{:keys [name doc install-command]}]
  (str "## " name
       "\n\n"
       doc
       "\n\n```bash\n"
       install-command
       "\n```\n"))

(defn add-markdown-to-entries
  [w]
  (update w
          :entries
          (fn [entries]
            (map
             (fn [entry]
               (assoc entry
                      :markdown
                      (entry-markdown entry)))
             entries))))

(defn add-install-md
  [w]
  (assoc w
         :install-md
         (str/join
          "\n"
          (map
           :markdown
           (sort-by (comp
                     str/lower-case
                     :name)
                    (filter
                     ;; Skipping entries which have not been commited yet:
                     (comp seq :latest-commit)
                     (:entries w)))))))

(defn write-install-md!
  [w]
  (spit "../install.md"
        (:install-md w))
  )

(defn process!
  [state]
  (swap! state get-meta-edn-files)
  (swap! state read-entries)
  (swap! state add-latest-commits)
  (swap! state add-github-install-commands)
  (swap! state add-markdown-to-entries)
  (swap! state add-install-md)
  (write-install-md! @state)
  )

(defn generate
  [_params]
  (process! (atom {:dir "../"})))

(comment
  (seq (get-meta-edn-files "../"))

  (def state
    (atom {:dir "../"}))

  (get-latest-commit "../clojure")

  (extract-path (get-origin-git-url "."))

  (github-base-url ".")

  (println (:install-md @state))

  (process! state)
  )
