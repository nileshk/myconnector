package com.myconnector.client.dictionary;

import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;

import javax.swing.*;

import org.apache.log4j.Logger;

import com.myconnector.client.dictionary.proxy.DictionaryWSImpl;
import com.myconnector.client.gui.LoginDialog;
import com.myconnector.client.gui.LoginInterface;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class DictionaryWindow {

    Logger logger = Logger.getLogger(DictionaryWindow.class);

    JFrame frame;

    private DictionaryWSImpl dictionaryWS;

    public void setDictionaryWS(DictionaryWSImpl dictionaryWS) {
        this.dictionaryWS = dictionaryWS;
    }

    public DictionaryWindow() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        //JLabel label = new JLabel("Hello World");
        JButton connectButton = new JButton("Connect");
        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                connectDialog();
            }
        });
        frame.getContentPane().add(connectButton);

        //Display the window.
        int width = 400;
        int height = 300;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;

        frame.setLocation(x, y);
        frame.setSize(width, height);
        //frame.pack();
        frame.setVisible(true);
    }

    private void connectDialog() {
        logger.debug("connectDialog()");
        LoginDialog loginDialog = new LoginDialog(frame, new LoginInterface() {

            public void login(String username, String password) {
                logger.debug("username = " + username);
                logger.debug("password = " + password);
                try {
                    dictionaryWS.login(username, password);
                    logger.debug("Logged in");
                } catch (RemoteException e) {
                    // TODO handle this better
                    logger.error(e);
                }
            }
        });
    }
}
