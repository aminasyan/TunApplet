/*
 * Copyright (C) 2015 aminasyan
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.tunapplet;

import com.jcraft.jsch.HostKey;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import java.applet.Applet;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import net.propero.rdp.Common;
import net.propero.rdp.Rdesktop;
import net.propero.rdp.RdesktopException;
import net.propero.rdp.applet.RdpApplet;
import java.util.Random;
import javax.swing.JOptionPane;
import org.vncviewer.VncViewer;

/**
 *
 * @author aminasyan
 */
public class TunApplet extends javax.swing.JApplet {
    String host;
    int port;
    int timeout;
    public enum RemoteProto {
        VNC,
        RDP
    };
    RemoteProto remoteType;
    JSch jsch = new JSch();
    HostKey sshKey;
    String serverKey = "<your server key>";
    Session session;
    Random generator = new Random();

    /**
     * Initializes the applet TunApplet
     */
    @Override
    public void init() {
        this.host = this.getParameter("sshhost");
        this.port = Integer.parseInt(this.getParameter("sshport"));
        this.timeout = Integer.parseInt(this.getParameter("sshtimeout"));
        
        /* Create and display the applet */
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    initComponents();
                }
            });
        } catch (InvocationTargetException itx){
            JOptionPane.showMessageDialog( this, itx.getMessage());
        } catch ( InterruptedException iex) {
            JOptionPane.showMessageDialog( this, iex.getMessage());
        }
        
        disconnectButton.setEnabled(false);
    }

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        vncTextField = new javax.swing.JTextField();
        vncLabel = new javax.swing.JLabel();
        usrLabel = new javax.swing.JLabel();
        usrTextField = new javax.swing.JTextField();
        pwLabel = new javax.swing.JLabel();
        pwPasswordField = new javax.swing.JPasswordField();
        connectButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();
        statusSeparator = new javax.swing.JSeparator();
        statusScrollPane = new javax.swing.JScrollPane();
        statusTextPane = new javax.swing.JTextPane();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(400, 180));
        setMinimumSize(new java.awt.Dimension(400, 180));
        setPreferredSize(new java.awt.Dimension(402, 180));
        getContentPane().setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 235;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 12, 0, 0);
        getContentPane().add(vncTextField, gridBagConstraints);

        vncLabel.setText("VNC/RDP Server:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 14, 0, 0);
        getContentPane().add(vncLabel, gridBagConstraints);

        usrLabel.setText("Username:");
        usrLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 14, 0, 0);
        getContentPane().add(usrLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 235;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        getContentPane().add(usrTextField, gridBagConstraints);

        pwLabel.setText("Paasword:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 14, 0, 0);
        getContentPane().add(pwLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 235;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        getContentPane().add(pwPasswordField, gridBagConstraints);

        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 18, 0, 0);
        getContentPane().add(connectButton, gridBagConstraints);

        disconnectButton.setText("Disconnect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        getContentPane().add(disconnectButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 401;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 0);
        getContentPane().add(statusSeparator, gridBagConstraints);

        statusScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        statusScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        statusTextPane.setEditable(false);
        statusTextPane.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        statusTextPane.setAutoscrolls(false);
        statusScrollPane.setViewportView(statusTextPane);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 395;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 2, 0);
        getContentPane().add(statusScrollPane, gridBagConstraints);
    }// </editor-fold>                        

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        vncTextField.setEnabled(false);
        usrTextField.setEnabled(false);
        pwPasswordField.setEnabled(false);
        connectButton.setEnabled(false);
        disconnectButton.setEnabled(true);
        try {
            this.go();
        } catch (Exception conEx) {
            JOptionPane.showMessageDialog(this,
                    conEx.getMessage());
        }

        // JOptionPane.showMessageDialog(rootPane, "Message");
        // statusLabel.setText("Blah Blah Blah!");
    }                                             

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
         try {
                this.stop();
            } catch (Exception disEx) {
                JOptionPane.showMessageDialog(this,
                        disEx.getMessage());
            }
        vncTextField.setEnabled(true);
        usrTextField.setEnabled(true);
        pwPasswordField.setEnabled(true);
        connectButton.setEnabled(true);
        disconnectButton.setEnabled(false);
        statusTextPane.setText("status:");
        // JOptionPane.showMessageDialog(rootPane, "Message");
        // statusLabel.setText("Blah Blah Blah!");
    }                                                


    // Variables declaration - do not modify                     
    public javax.swing.JButton connectButton;
    public javax.swing.JButton disconnectButton;
    public javax.swing.JLabel pwLabel;
    public javax.swing.JPasswordField pwPasswordField;
    public javax.swing.JScrollPane statusScrollPane;
    public javax.swing.JSeparator statusSeparator;
    public javax.swing.JTextPane statusTextPane;
    public javax.swing.JLabel usrLabel;
    public javax.swing.JTextField usrTextField;
    public javax.swing.JLabel vncLabel;
    public javax.swing.JTextField vncTextField;
    // End of variables declaration                   

    public void go() throws Exception {
        String clwidth = this.getParameter("clientwidth");
        String clheight = this.getParameter("clientheight");
        int rndOffset = this.generator.nextInt(48) + 51;
        String user = this.usrTextField.getText();
        String password = new String(this.pwPasswordField.getPassword());
        String[] server = this.vncTextField.getText().split(":");
        String tunnelRemoteHost = server[0];
        int tunnelRemotePort;
        int tunnelLocalPort;
        if(server.length == 1) {
            remoteType = RemoteProto.valueOf("RDP");
            tunnelRemotePort = 3389;
            tunnelLocalPort = 3391 + rndOffset;
        } else {
            remoteType = RemoteProto.valueOf("VNC");
            tunnelRemotePort = 5900 + Integer.parseInt(server[1]);
            tunnelLocalPort = 5900 + rndOffset;
        }

        this.session = this.jsch.getSession(user, this.host, this.port);
        localUserInfo lui = new localUserInfo();
        this.session.setUserInfo(lui);
        this.session.setPassword(password);
        this.session.connect(timeout);
        this.sshKey = this.session.getHostKey();
        if(this.sshKey.getKey().equals(this.serverKey)) {
            this.session.setPortForwardingL(tunnelLocalPort, tunnelRemoteHost, tunnelRemotePort);
            statusTextPane.setText("Connected, starting "+remoteType.toString());
            switch (remoteType) {
                case VNC:
                    MyVncViewer rdopts = new MyVncViewer();
                    
                    rdopts.host = "localhost";
                    rdopts.port = tunnelLocalPort;
                    rdopts.inSeparateFrame = true;
                    rdopts.showControls = false;
                    rdopts.init();
                    rdopts.start();
                    break;
                case RDP:
                    String[] rdopts1 = new String[]{"-g", clwidth + "x" + clheight, "-u", user, "localhost:" + tunnelLocalPort};
                    MyRdpApplet NewRdpApplet = new MyRdpApplet();
                    NewRdpApplet.init();
                    NewRdpApplet.setRargs(rdopts1.length);
                    System.arraycopy(rdopts1, 0, NewRdpApplet.rargs, 0, rdopts1.length);
                    NewRdpApplet.start();
                    break;
            }
        } else {
            statusTextPane.setText("SSH Key does not match!");
        }

    }

    @Override
    public void stop() {
        if(this.session.isConnected()) {
            this.session.disconnect();
        }

    }
}
class localUserInfo implements UserInfo {
    String passwd;

    localUserInfo() {
    }

    @Override
    public String getPassword() {
        return this.passwd;
    }

    @Override
    public boolean promptYesNo(String str) {
        return true;
    }

    @Override
    public String getPassphrase() {
        return null;
    }

    @Override
    public boolean promptPassphrase(String message) {
        return true;
    }

    @Override
    public boolean promptPassword(String message) {
        return true;
    }

    @Override
    public void showMessage(String message) {
    }
}
class MyVncViewer extends VncViewer {
    MyVncViewer() {
    }

    @Override
    public void readParameters() {
        this.offerRelogin = false;
        this.showOfflineDesktop = false;
        this.deferScreenUpdates = 20;
        this.deferCursorUpdates = 10;
        this.deferUpdateRequests = 0;
        this.debugStatsExcludeUpdates = 0;
        this.debugStatsMeasureUpdates = 0;
        this.socketFactory = null;
    }
    
    @Override
    public String readParameter(String name, boolean required) {
        return null;
    }
}
class MyRdpApplet extends RdpApplet {
    String[] rargs;
    String redirect;
    RdpThread rThread = null;

    MyRdpApplet() {
    }

    @Override
    public void init() {
    }

    public void setRargs(int i) {
        this.rargs = new String[i];
    }

    @Override
    public void start() {
        Common.underApplet = true;
        this.rThread = new RdpThread(this.rargs, this.redirect, this);
        this.rThread.start();
    }
}

class RdpThread extends Thread {
    String[] args;
    String redirect = null;
    Applet parentApplet = null;
    public RdpThread(String[] args, String redirect, Applet a) {
        this.parentApplet = a;
        this.args = args;
        this.redirect = redirect;
    }

    @Override
    public void run() {
        this.setPriority(10);
        try {
            Rdesktop.main(this.args);
            if(this.redirect != null) {
                URL e = new URL(this.redirect);
                this.parentApplet.getAppletContext().showDocument(e);
            }
        } catch (RdesktopException rdEx) {
            System.err.println(rdEx.getClass().getName() + ": " + rdEx.getMessage());
        } catch (MalformedURLException urEx) {
            System.err.println(urEx.getClass().getName() + ": " + urEx.getMessage());
        }
        Common.underApplet = false;
    }
    
}
