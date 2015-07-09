# TunApplet
<div class="markdown-body">
  <p>Welcome to the TunApplet wiki!</p>

<p>I have created this applet in an effort to simplify ssh tunneling access &amp; provide user friendly experience. The applet will create a tunnel to your SSH gateway and establish a connection to either Remote Desktop or VNC screen. The name of the VNC or RDP server has to be resolvable by the SSH gateway. The applet will distinguish between VNC &amp; RDP protocols by the presence of ":" in the remote server name, for ex. "myserver:1"  would be a VNC screen and "myserver" would default to and RDP connection.</p>

<p>Screenshots:
<img src="https://github.com/aminasyan/TunApplet/wiki/pics/TunApplet.jpeg" alt="TunApplet.jpeg"></p>

<p>The applet uses the following libraries;</p>

<p>jsch-0.1.52.jar (Java SSH library) <a href="http://www.jcraft.com/jsch/">http://www.jcraft.com/jsch/</a>
java-getopt-1.0.13.jar             <a href="https://www.gnu.org/software/java-getopt/">https://www.gnu.org/software/java-getopt/</a>
log4j-1.2.16.jar                   <a href="http://logging.apache.org/log4j/">http://logging.apache.org/log4j/</a>
properJavaRDP.jar                  <a href="http://sourceforge.net/projects/properjavardp/">http://sourceforge.net/projects/properjavardp/</a>
VncViewer.jar                      <a href="http://www.tightvnc.com/download.php">http://www.tightvnc.com/download.php</a></p>

<p>NOTE: I had to recompile VncViewer.jar and put it in a package "org.vncviewer" per Oracle Java recommendation.</p>

<p>Please keep in mind that as of Java 7 update ?? unsigned or self-signed applets are blocked from running. For testing purposes you can try Java 6 after which you can decide to buy a code signing certificate for your applet and libraries.</p>

<p>The applet requires the following parameters to function</p>

<p>  -  The address of your SSH gateway. 
                    -  The port your SSH server listens.
               -  The SSH connection timeout value.
              -  Show VNC Viewer controls.
           -  Open VNC viewer in new window, always yes.
              -  The Remote Desktop width.
              -  The Remote Desktop height.</p>

<p>For the Remote Desktop width/height parameter you can optionally use included JavaScript code to determine optimal full size window.</p>

</div>
