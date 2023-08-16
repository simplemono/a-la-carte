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

- You probably need to install different software than I do. Participating in a
  project like webinstall.dev or brew.sh requires coordination, and you might not
  get approval for your addition.

- If you need to customize a-la-carte fork it on Github and run the
  `./generate-install-md` script to regenerate the [install.md](/install.md), so
  that all `curl -sS 'https://raw.githubusercontent.com/...` URLs point to your
  own Github repository.

## Usage

Open the [install.md](/install.md) and copy `curl -sS
'https://raw.githubusercontent.com/... | bash` command of the software you like
to install.

If you are not using this in a Dockerfile and want to install something on your
own Ubuntu machine, then inspect the script behind the URL beforehand, ensure
that you trust it, and if it requires `sudo`, then change the call to `curl -sS
'https://raw.githubusercontent.com/... | sudo bash`.

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
