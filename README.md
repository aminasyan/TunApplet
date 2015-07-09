<html>
<head>
<title>TunApplet</title>
<meta name="generator" content="Bluefish">
<meta name="author" content="">
<meta name="date" content="">
<meta name="copyright" content="">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="ROBOTS" content="NOINDEX, NOFOLLOW">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8">
<meta http-equiv="content-style-type" content="text/css">
<meta http-equiv="expires" content="0">
</head>
<body>
<div class="markdown-body">

<p>I have created this applet in an effort to simplify ssh tunneling access &amp; provide user friendly experience. The applet will create a tunnel to your SSH gateway and establish a connection to either Remote Desktop or VNC screen. The name of the VNC or RDP server has to be resolvable by the SSH gateway. The applet will distinguish between VNC &amp; RDP protocols by the presence of ":" in the remote server name, for ex. "myserver:1"  would be a VNC screen and "myserver" would default to and RDP connection.</p>

<p>Screenshots:</p>


<p><img src="https://github.com/aminasyan/TunApplet/screenshots/TunApplet.jpeg" alt="TunApplet.jpeg"></p>


<p>The applet uses the following libraries;</p>

<table>
<tr>
<td>jsch-0.1.52.jar (Java SSH library)</td>
<td><a href="http://www.jcraft.com/jsch/">http://www.jcraft.com/jsch/</a></td>
</tr>
<tr>
<td>java-getopt-1.0.13.jar</td>
<td><a href="https://www.gnu.org/software/java-getopt/">https://www.gnu.org/software/java-getopt/</a></td>
</tr>
<tr>
<td>log4j-1.2.16.jar</td>
<td><a href="http://logging.apache.org/log4j/">http://logging.apache.org/log4j/</a></td>
</tr>
<tr>
<td>properJavaRDP.jar</td>
<td><a href="http://sourceforge.net/projects/properjavardp/">http://sourceforge.net/projects/properjavardp/</a></td>
</tr>
<tr>
<td>VncViewer.jar</td>
<td><a href="http://www.tightvnc.com/download.php">http://www.tightvnc.com/download.php</a></td>
</tr>
</table>

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
</body>
</html>
