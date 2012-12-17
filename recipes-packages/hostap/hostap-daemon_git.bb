DESCRIPTION = "User space daemon for extended IEEE 802.11 management"

require hostap-daemon-0.7.inc

PR = "r1"
SRCREV = "83fa07226debc2f7082b6ccd62dbb1cd47c30472"
PV = "0.7.3+0.8.0-rc"
PR_append = "gitr${SRCPV}"
FILESPATHPKG =. "hostap-daemon-git:"

DEFAULT_PREFERENCE = "-1"

LIC_FILES_CHKSUM="file://README;md5=88c7ff788965e2440b1fde2353f01167"
LICENSE="GPLv2"

S = "${WORKDIR}/git/hostapd"

SRC_URI = "git://w1.fi/srv/git/hostap.git;protocol=git \
	file://defconfig \
	file://init"

S = "${WORKDIR}/git/hostapd"

do_configure() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	echo "CFLAGS += -I${STAGING_INCDIR}" >> .config
	echo "LIBS += -L${STAGING_LIBDIR}" >> .config
}
