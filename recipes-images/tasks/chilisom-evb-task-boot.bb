# This recipe is intended as a 'simpler' replacement for task-base.
# Please communicate your use cases and suggestions to the mailinglist(s)

DESCRIPTION = "Basic task to get a device online"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PR = "r8"

inherit task

# packages which content depend on MACHINE_FEATURES need to be MACHINE_ARCH
#
PACKAGE_ARCH = "${MACHINE_ARCH}"

# Poke extra recomendations into the list using your machine.conf
#
MACHINE_EXTRA_RRECOMMENDS ?= ""

#
# Select between dropbear and openssh
# Set TASK_BASIC_SSHDAEMON = "openssh-sshd openssh-sftp openssh-sftp-server" in your DISTRO config to get openssh(d)
#

#
# The section below is designed to match with task-boot, but doesn't depend on it to allow for more freedom 
# when writing image recipes.
# It also avoids the choice between connman/networkmanager/ifupdown since that is an image feature, not a
# distro feature.
#
# Util-linux (u)mount is included because the busybox one can't handle /etc/mtab being symlinked to /proc/mounts
#

#
# The following section is split in 3:
#   1) Machine features: kernel modules and userspace helpers for those
#   2) Distro features: packages associated with those
#   3) Nice to have: packages that are nice to have, but aren't strictly needed  
#
RRECOMMENDS_${PN} = "\
	${MACHINE_EXTRA_RRECOMMENDS} \
	htop \
    "
