DESCRIPTION = "libgphoto2 allows you to access digital cameras"
SECTION = "libs"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=0448d3676bc0de00406af227d341a4d1"

PR = "r3"

DEPENDS = "libtool jpeg virtual/libusb0 libexif"

# The .fdi and .rules files were generated with:
#  libgphoto2-2.4.7/packaging/generic$ qemu-arm -s 1048576 -r 2.6.24 -L /OE/angstrom-dev/staging/armv5te-angstrom-linux-gnueabi/ .libs/print-camera-list
# They are release specific, so please regen when adding new releases

SRC_URI = "file://libgphoto2-${PV}.tar.gz;name=libgphoto2 \
           file://10-camera-libgphoto2-device.fdi \
           file://10-camera-libgphoto2.fdi \
           file://40-libgphoto2.rules \
"

SRC_URI[libgphoto2.md5sum] = "173e28d9e9f1e117cfebacc9cbf9ada3"
SRC_URI[libgphoto2.sha256sum] = "ad75079b42ba11593ff2f36427958f03ca43faf0ba0535ca677f61e888c8b0af"

inherit autotools pkgconfig gettext lib_package

EXTRA_OECONF = " --with-drivers=all udevscriptdir=/lib/udev ac_cv_lib_ltdl_lt_dlcaller_register=yes"

do_configure_append() {
	cd ${S}/libgphoto2_port/
	autoreconf -Wcross --verbose --install --force ${EXTRA_AUTORECONF} $acpaths
	cd ${S}
}

do_install_append() {
    install -d ${D}${datadir}/hal/fdi/information/20thirdparty
    install -m 0644 ${WORKDIR}/*.fdi ${D}${datadir}/hal/fdi/information/20thirdparty/

    install -d ${D}${sysconfdir}/udev/rules.d/
    install -m 0755 ${WORKDIR}/*.rules ${D}${sysconfdir}/udev/rules.d/
}

PACKAGES =+ "libgphotoport libgphoto2-camlibs"
FILES_libgphoto2-camlibs = "${libdir}/libgphoto2*/*/*.so*"
RRECOMMENDS_${PN} = "libgphoto2-camlibs"

FILES_libgphotoport = "${libdir}/libgphoto2_port.so.*" 

FILES_${PN} += "${base_libdir}/udev/* ${datadir}/hal"
FILES_${PN}-dbg += "${libdir}/*/*/.debug"
FILES_${PN}-dev += "${libdir}/*/*/*.la"



