#Angstrom image for Grinn HMI

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp"

DISTRO_UPDATE_ALTERNATIVES ??= ""
ROOTFS_PKGMANAGE_PKGS ?= '${@base_conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "${ROOTFS_PKGMANAGE} ${DISTRO_UPDATE_ALTERNATIVES}", d)}'

CONMANPKGS ?= "connman connman-plugin-loopback connman-plugin-ethernet connman-plugin-wifi connman-systemd"
CONMANPKGS_libc-uclibc = ""

IMAGE_INSTALL += " \
	angstrom-task-boot \
	chilisom-evb-task-basic \
	${CONMANPKGS} \
	${ROOTFS_PKGMANAGE_PKGS} \
        vsftpd \
        thttpd \
	python \
	python-dbus \
	libstdc++ \
	ntpdate \
	nano \
	task-sdk-target \
	tslib-conf \
	tslib-tests \
	tslib-calibrate \
	qt4-embedded \
	qt4-embedded-plugin-mousedriver-tslib \
	mtd-utils \
"

IMAGE_LINGUAS = "en-us pl-pl de-de"

IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "tinylogin shadow"

export IMAGE_BASENAME = "hmi-image"

inherit image
