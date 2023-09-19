# a-la-carte

A collection of self-contained scripts to install software on Ubuntu unattended.

Find all install scripts here:

[install.md](/install.md)

One of the most convenient ways to install software on Linux looks like this:

    curl -sS https://webi.sh/ffmpeg | sh

The example above installs `ffmpeg` with the help of
https://webinstall.dev/ffmpeg/. webinstall.dev offers a convenient way to
install binaries without using `sudo`. Even without `sudo` piping a script from
the internet into `sh` or `bash` never feels secure. The a-la-carte project is
inspired by webinstall.dev, but chooses different trade-offs:

- It is only meant for the current Ubuntu LTS version.

- It is not for day-two operations, meaning there is no uninstall or
  upgrade.

- a-la-carte should be used for creating a Docker image or a VM image (with
  HashiCorp's Packer, for example). Therefore, the scripts should never ask for
  user input.

- Like webinstall.dev, each script is self-contained. Thereby you can pick the
  scripts à la carte to only install what you need.

- It needs to use `sudo` to be able to use apt-get to install non-single
  binaries.

- To mitigate the risks of `sudo` in this context, all scripts are immutable with
  the help of raw.githubusercontent.com.

- An example of how to install the latest version of Clojure:

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/2555ec6605a704704737d2d22be77d84c1f5f4ad/clojure/install' | bash
```

- Due to the trusted Github brand and the way raw.githubusercontent.com works
  you can inspect the script beforehand and know that it will not change, when
  you invoke it tomorrow or with a different user agent string.

- However, from a security point of view the best practice is to fork the
  repository into your own Github account and use `./generate-install-md` to
  adapt the URLs to your repository. Regrettably, it is [possible to calculate
  SHA-1 hash
  collisions](https://www.theregister.com/2017/02/23/google_first_sha1_collision/)
  (if you have enough money).

- Git also does not prevent to use a SHA-1 as branch name. Luckily, Github does
  not allow to create or push such branch names. But another Git hosting service
  may allow this.

- You probably need to install different software than I do. Participating in a
  project like webinstall.dev or brew.sh requires coordination, and you might not
  get approval for your addition.

- If you need to customize a-la-carte, then fork it on Github and run the
  `./generate-install-md` script to regenerate the [install.md](/install.md), so
  that all `curl -sS 'https://raw.githubusercontent.com/...` URLs point to your
  own Github repository.

- Each `curl -sS 'https://raw.githubusercontent.com/...` in the
  [install.md](/install.md) refers the most recent git commit of the subfolder,
  where the `./install` script resides.

- Consequently the git commit of a script only changes, if the script changed.
  This reduces the number of times you need to reinspect a script.

- Breakage is reduced since it is fine to continue to use an old version of the
  script (to create your Docker image).

- The predecessor of this project is
  [container-image](https://github.com/SimpleValue/container-image), where it
  was not straight-forward to pick scripts à la carte. Thereby each change
  triggered a full rebuild of the Dockerfile. This created one large Docker
  image layer that takes quite a while to download. Therefore you tried to
  postpone changes to the Docker image of the development environment as long as
  possible. For the same reason a local build of the Docker image was also not
  practically, since each change triggered a full rebuild.

## Usage

Open the [install.md](/install.md) and copy `curl -sS
'https://raw.githubusercontent.com/... | bash` command of the software you like
to install.

If you are not using this in a Dockerfile and want to install something on your
own Ubuntu machine, then inspect the script behind the URL beforehand, ensure
that you trust it, and if it requires `sudo`, then change the call to `curl -sS
'https://raw.githubusercontent.com/... | sudo bash`.

Regrettably, `curl` and `ca-certificates` are not installed in the official
Docker image of Ubuntu. Therefore your Dockerfile should start like this:

```
FROM ubuntu:22.04 as base

RUN apt-get -qq update && apt-get -y -qq --no-install-recommends install -y curl ca-certificates

```

## Development

The only required script for the project is `./generate-install-md`, which
generates the [install.md](/install.md), and it is written in Clojure. To run it
you need to install [Babashka](https://github.com/babashka/babashka):

    bash < <(curl -s https://raw.githubusercontent.com/babashka/babashka/master/install)

To add a new script, add a new subfolder (or copy an existing one). It should
contain the `./install` script:

```bash
#!/bin/bash

set -e

apt-get -qq update
apt-get -y -qq --no-install-recommends install -y git
```

And a `meta.edn` file:

```clojure
{:name "git"
 :doc "Installs git."}
```

Invoke `./generate-install-md` after you commit the files to regenerate the
`install.md`.

Feel free to write the `./install` script in a different language than `bash`
(like [Babashka](https://github.com/babashka/babashka), for example), if you
already installed the required runtime in your Docker image.

## History

We use Ubuntu on the servers and dev laptops to build our SaaS with Clojure. One
of the most convenient ways to install software on Ubuntu that is not available
via `apt-get` or `snap` is:

    curl -sS https://example.com/install.sh | sudo bash

That's convenient but dangerous. Even without `sudo` the script may start to
delete your entire home folder. The web server might return a completely
different script based on time, IP, user agent, or other criteria. But it sooo
convenient 😅

A few months ago, I stumble across:

[https://webinstall.dev/](https://webinstall.dev/)

Which is beautiful and lets you install binaries without `sudo`:

    curl -sS https://webi.sh/ffmpeg | sh

However, you still have the problem that you need to trust this website, and it
takes quite some effort to submit additional scripts or host your version of
webinstall.dev. Furthermore, everything that requires `sudo`, like `apt-get`, is
not supported.

Recently, I needed to set up another VM and create a new Docker image for a new
system, and I was not satisfied with my [previous
approach](https://github.com/SimpleValue/container-image) for a while.
Therefore, I thought about how to create something similar like
[webinstall.dev](https://webinstall.dev) while avoiding some of its drawbacks:

[https://github.com/simplemono/a-la-carte](https://github.com/simplemono/a-la-carte)

The [install.md](https://github.com/simplemono/a-la-carte/blob/main/install.md)
lets you pick from a collection of install scripts. For example, the one to
install OpenJDK 20:

    curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/46b211275ce6ea4080a921e01005960e122675de/openjdk-20/install' | sudo bash

To use this script, you must add `sudo` or be root (like in a Dockerfile).
However, if you trust Github, you know that the content behind this URL is
**immutable**. Therefore, you can inspect the script once (either open the URL
or delete the `| sudo bash` part), decide if you trust it, and then use this
script forever, with the knowledge that it stays immutable (as long as
[Github.com](https://Github.com) is not hacked or changed in another way).

You probably need to install different packages like I do, and I don't like to
accept pull requests with scripts I don't need. The approach avoids this problem
since you can fork this repository on GitHub. Then you run:

    ./generate-install-md

It is a [Babashka](https://github.com/babashka/babashka) script that will
regenerate the
[install.md](https://github.com/simplemono/a-la-carte/blob/main/install.md), but
this time with URLs for your GitHub repository
([`https://raw.githubusercontent.com/your-github-username/your-repo/`](https://raw.githubusercontent.com/your-github-username/your-repo/)`...`
). In comparison to [webinstall.dev](https://webinstall.dev), you don't need to
host your own server. You can add your own scripts (just run
`./generate-install-md` afterward and commit this
[`install.md`](https://install.md)), and you can trust your Github repository
even more.

Compared to my [old approach](https://github.com/SimpleValue/container-image),
the new one also allows leveraging Docker's image layer caching more
conveniently. I'm aware of Nix, Guix, and others, I tried them, but my Linux
skills seem to be not good enough 😅
