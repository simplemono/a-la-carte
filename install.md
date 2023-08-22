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

## Clojure CLI

Installs the latest version of
Clojure (https://clojure.org/guides/install_clojure#_linux_instructions)

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/2555ec6605a704704737d2d22be77d84c1f5f4ad/clojure/install' | bash
```

## dev-user

Adds an user `dev` who is allowed to use `sudo`. Thereby a Docker image must not run with `root` user during development.

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/07dfbcdea76d89374eab4584af8e61bf528fa3ec/dev-user/install' | bash
```

## docker-ce

Installs Docker Community Edition (CE) on Ubuntu (based on https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-22-04)

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/9aa5cbc72a10fd6f59c0ef873db2a0b6fda4693a/docker-ce/install' | bash
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

## OpenJDK 20

Installs OpenJDK 20

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/46b211275ce6ea4080a921e01005960e122675de/openjdk-20/install' | bash
```

## pip3

Pip is a tool for installing Python packages. Installs pip for Python 3.

```bash
curl -sS 'https://raw.githubusercontent.com/simplemono/a-la-carte/dc17eb5b2c3b4ddd38747b2a268913de242bfd6f/pip3/install' | bash
```
