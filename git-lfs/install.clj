;; Installs git-lfs, based on:
;; https://docs.github.com/en/repositories/working-with-files/managing-large-files/installing-git-large-file-storage

(require '[cheshire.core :as json]
         '[babashka.http-client :as http]
         '[clojure.java.io :as io]
         '[babashka.process :as process]
         )

(def response
  (http/request
   {:request-method :get
    :uri "https://api.github.com/repos/git-lfs/git-lfs/releases/latest"
    }))

(def data
  (json/parse-string (:body response)
                     true))

(def asset
  (some
   (fn [asset*]
     (when (= (:label asset*)
              "Linux AMD64")
       asset*))
   (:assets data)))

(def download-url
  (:browser_download_url asset))

(def file-name
  (:name asset))

(def file
  (io/file "/tmp"
           file-name))

(io/copy
 (:body (http/get download-url
                  {:as :stream}))
 file)

(process/shell
 {:dir "/tmp"}
 (str "tar -vxf "
      (.getCanonicalPath file)))

(def version
  (subs (:name data) 1))

(def extracted-path
  (str "/tmp/git-lfs-"
       version))

(process/shell
 {:dir extracted-path}
 "./install.sh")

(process/shell
 "git lfs install")
