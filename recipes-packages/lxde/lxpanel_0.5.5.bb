DESCRIPTION = "LXDE Panel"
SECTION = "x11"
DEPENDS = "menu-cache gdk-pixbuf"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=9d19a9495cc76dc96b703fb4aa157183"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz \
           file://alarm.patch"

SRC_URI[md5sum] = "6162b7e8d912a41f9c075fe982370bfb"
SRC_URI[sha256sum] = "729c3dc52e343fe15dfde40475875c2b3670b3b37958c6c1e4c936242cdc2e9b"

inherit autotools gettext

RDEPENDS_${PN} = "lxmenu-data menu-cache"
FILES_${PN}-dbg += "${libdir}/lxpanel/plugins/.debug"

