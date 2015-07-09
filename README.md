<html>
<head>
<title>TunApplet</title>
</head>
<body>
<div class="markdown-body">
<p>I have created this applet in an effort to simplify ssh
tunneling access &amp; provide user friendly experience. The
applet will create a tunnel to your SSH gateway and establish a
connection to either Remote Desktop or VNC screen. The name of
the VNC or RDP server has to be resolvable by the SSH gateway.
The applet will distinguish between VNC &amp; RDP protocols by
the presence of ":" in the remote server name, for ex.
"myserver:1" would be a VNC screen and "myserver" would default
to and RDP connection.</p>
<p>Screenshots:</p>
<p><img src="https://github.com/aminasyan/TunApplet/raw/master/screenshots/TunApplet.jpeg"
alt="TunApplet.jpeg"><br>
</p>
<p>The applet uses the following libraries;</p>
<table>
<tbody>
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
</tbody>
</table>
<p>NOTE: I had to recompile VncViewer.jar and put it in a package
"org.vncviewer" per Oracle Java recommendation.</p>
<p>Please keep in mind that as of Java 7 update ?? unsigned or
self-signed applets are blocked from running. For testing
purposes you can try Java 6 after which you can decide to buy a
code signing certificate for your applet and libraries.</p>
<p>The applet requires the following parameters to function<br>
</p>
<table border="0">
<small> </small><tbody>
<small> </small><tr>
<small> </small><td valign="top"><small>&lt;param
name="sshhost" value="ssh.example.com"/&gt;</small><small><br>
</small><small> </small></td>
<small> </small><td valign="top"><small>-&nbsp; The address
of your SSH gateway.</small><small><br>
</small><small> </small></td>
<small> </small></tr>
<small> </small><tr>
<small> </small><td valign="top"><small>&lt;param
name="sshport" value="22"/&gt;</small><small><br>
</small><small> </small></td>
<small> </small><td valign="top"><small>-&nbsp; The port
your SSH server listens.</small><small><br>
</small><small> </small></td>
<small> </small></tr>
<small> </small><tr>
<small> </small><td valign="top"><small>&lt;param
name="sshtimeout" value="3000"/&gt;</small><small><br>
</small><small> </small></td>
<small> </small><td valign="top"><small>-&nbsp; The SSH
connection timeout value.</small><small><br>
</small><small> </small></td>
<small> </small></tr>
<small> </small><tr>
<small> </small><td valign="top"><small>&lt;param
name="Show Controls" value="No"/&gt;</small><small><br>
</small><small> </small></td>
<small> </small><td valign="top"><small>-&nbsp; Show VNC
Viewer controls.</small><small><br>
</small><small> </small></td>
<small> </small></tr>
<small> </small><tr>
<small> </small><td valign="top"><small>&lt;param
name="Open New Window" value="Yes"/&gt;</small><small><br>
</small><small> </small></td>
<small> </small><td valign="top"><small>-&nbsp; Open VNC
viewer in new window.</small><small><br>
</small><small> </small></td>
<small> </small></tr>
<small> </small><tr>
<small> </small><td valign="top"><small>&lt;param
name="clientwidth" value="1024"/&gt;</small><small><br>
</small><small> </small></td>
<small> </small><td valign="top"><small>-&nbsp; The Remote
Desktop width.</small><small><br>
</small><small> </small></td>
<small> </small></tr>
<small> </small><tr>
<small> </small><td valign="top"><small>&lt;param
name="clientheight" value="768"/&gt;</small><small><br>
</small><small> </small></td>
<small> </small><td valign="top"><small>-&nbsp; The Remote
Desktop height.</small><small><br>
</small><small> </small></td>
<small> </small></tr>
<small> </small>
</tbody><small> </small>
</table>
<p>For the Remote Desktop width/height parameter you can
optionally use included JavaScript code to determine optimal
full size window.<br>
</p>
</div>
</body>
</html>

