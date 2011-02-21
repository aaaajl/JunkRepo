echo "Install yum plugin"
yum -y install yum-plugin-fastestmirror
echo "Update linux kernel"
yum -y update kernel
echo "Install RPMFusion Repo"
rpm -ivh http://download1.rpmfusion.org/free/fedora/rpmfusion-free-release-stable.noarch.rpm
yum -y localinstall --nogpgcheck http://download1.rpmfusion.org/free/fedora/rpmfusion-free-release-stable.noarch.rpm http://download1.rpmfusion.org/nonfree/fedora/rpmfusion-nonfree-release-stable.noarch.rpm
rpm -ivh http://download1.rpmfusion.org/nonfree/fedora/rpmfusion-nonfree-release-stable.noarch.rpm
echo "Install mp3"
yum -y install xmms xmms-mp3 xmms-faad2 xmms-pulse xmms-skins \
audacious audacious-plugins-freeworld* \
rhythmbox gstreamer-plugins-ugly gstreamer-plugins-bad gstreamer-ffmpeg \
amarok xine-lib-extras-freeworld
echo "Install mplayer"
yum -y install mplayer mplayer-gui gecko-mediaplayer mencoder
wget http://www.mplayerhq.hu/MPlayer/releases/codecs/all-20100303.tar.bz2
mkdir -p /usr/lib/codecs
tar -jxvf all-20100303.tar.bz2 --strip-components 1 -C /usr/lib/codecs/
yum -y install vlc
echo "Install DVD Playback"
wget http://www.mjmwired.net/resources/files/atrpms.repo
cp ./atrpms.repo /etc/yum.repos.d/atrpms.repo
rpm --import http://packages.atrpms.net/RPM-GPG-KEY.atrpms
yum -y --enablerepo=atrpms install libdvdcss
rpm -yivh msttcore-fonts-2.0-3.noarch.rpm
echo "Install flash player"
rpm -yivh http://linuxdownload.adobe.com/adobe-release/adobe-release-i386-1.0-1.noarch.rpm
rpm --import /etc/pki/rpm-gpg/RPM-GPG-KEY-adobe-linux
yum -y install flash-plugin
echo "Full update"
yum -y update
