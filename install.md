## android-tools-adb

The adb (Android Debug Bridge) of the Android-SDK.

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/dc17eb5b2c3b4ddd38747b2a268913de242bfd6f/android-tools-adb/install' | bash
```

## caddy

Installs caddyserver.com - A fast and extensible multi-platform
 HTTP/1-2-3 web server with automatic HTTPS

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/4ab9d35b9d037a8dbbe8e9e6978c4dcc43b8fb1b/caddy/install' | bash
```

## clj-kondo

Installs [clj-kondo](https://github.com/clj-kondo/clj-kondo).

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/999b9e4c1589e7faaa0d9537dc1fbbf56ab22f98/clj-kondo/install' | bash
```

## Clojure CLI

Installs the latest version of
Clojure (https://clojure.org/guides/install_clojure#_linux_instructions)

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/aa29e3ea57a92817446be9a5a81faaca578f217c/clojure/install' | bash
```

## datomic

Installs Datomic Pro (https://docs.datomic.com/pro/releases.html). The default version is `1.0.7021` use the environment variable `DATOMIC_VERSION` to change it.

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/41b9c3d9c34793778c6292c5dd67660ab57e5e24/datomic/install' | bash
```

## dev-user

Adds an user `dev` who is allowed to use `sudo`. Thereby a Docker image must not run with `root` user during development.

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/07dfbcdea76d89374eab4584af8e61bf528fa3ec/dev-user/install' | bash
```

## docker-ce

Installs Docker Community Edition (CE) on Ubuntu (based on https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-22-04)

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/c8fb451fd3d13eb7d07b910af42bd5e60b257565/docker-ce/install' | bash
```

## docker-compose-plugin

The Compose plugin for Docker (https://docs.docker.com/compose/install/linux/#install-using-the-repository)

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/8f65408ba3b0a448ee00c51c3aeb96b511347642/docker-compose-plugin/install' | bash
```

## frida

Dynamic instrumentation toolkit for developers, reverse-engineers, and security researchers. Learn more at frida.re.

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/dafe5af58096a5f051b8b0e44daaa2c236bae352/frida/install' | bash
```

## gcloud

Installs the Google Cloud SDK (based on: https://cloud.google.com/sdk/docs/install#deb)

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/a5c6a0cc925aae70ba5da6ff11e6d0ff35876e6b/gcloud/install' | bash
```

## gcsfuse

Installs Cloud Storage FUSE (based on: https://cloud.google.com/storage/docs/gcsfuse-install)

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/83bad9e8bef0f0c85a7d689907c3fcfaddafc36f/gcsfuse/install' | bash
```

## git

Installs git.

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/8f0c6cd47e375be3aa4d461fa587469fececea3f/git/install' | bash
```

## git-lfs

Installs [git-lfs](https://git-lfs.com/) based on
 https://docs.github.com/en/repositories/working-with-files/managing-large-files/installing-git-large-file-storage (requires
 Babashka).

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/d103e9aaa78085ce0bf000cbff6d2d12937db494/git-lfs/install' | bb
```

## github-actions-runner

Installs [GitHub Actions Runner](https://github.com/actions/runner).

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/3502add1da17d3e25e6bb14581d856c4a4c755d5/github-actions-runner/install' | bash
```

## google-chrome

Installs Google Chrome.

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/dbb0bb2f3ebd2b7f63ca86486eefb311149e3253/google-chrome/install' | bash
```

## google-cloud-profiler

The Google Cloud Profiler for Java (see https://cloud.google.com/profiler/docs/profiling-java)

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/2cd2afb10a523df25f8b4befb5caf96464d26651/google-cloud-profiler/install' | bash
```

## kubectl

Installs kubectl to manage Kubernetes.

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/9d1494c64d28637fdb866e6c928870a3009b7157/kubectl/install' | bash
```

## maven3

Installs the latest version of [Maven3](https://maven.apache.org/) (requires Babashka).

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/60a01eb6466e06e8013120eb598b3246e9e6a1f3/maven3/install' | bb
```

## nodejs-21

Installs the NodeJS v21 (based on: https://github.com/nodesource/distributions#installation-instructions)

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/04e705c538397b4a8f425a60b21c21e70604411b/nodejs-21/install' | bash
```

## OpenJDK 20

Installs OpenJDK 20

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/46b211275ce6ea4080a921e01005960e122675de/openjdk-20/install' | bash
```

## packer

[Packer](https://www.packer.io/) is a tool that lets you create identical machine images for multiple platforms from a single source template. Packer can create golden images to use in image pipelines.

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/f73de88bdf6ec01d7732be9f603f23515963e58f/packer/install' | bash
```

## pip3

Pip is a tool for installing Python packages. Installs pip for Python 3.

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/dc17eb5b2c3b4ddd38747b2a268913de242bfd6f/pip3/install' | bash
```

## redis

Installs [redis](https://redis.io/).

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/2e12fb272fad22a4229bd5abc2fb24e63f2ec59d/redis/install' | bash
```

## terraform

Installs terraform.io (based on: https://learn.hashicorp.com/tutorials/terraform/install-cli)

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/012be48aaf68f2048fab87e7bd2b7a91be2b30a1/terraform/install' | bash
```

## yarn

Installs yarn (yarnpkg.com).

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/b1fee250b7e5182299917db28d91cd9a965dd179/yarn/install' | bash
```
