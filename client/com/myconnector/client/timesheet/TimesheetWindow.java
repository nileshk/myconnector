package com.myconnector.client.timesheet;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.apache.log4j.Logger;

import com.myconnector.client.gui.LoginDialog;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class TimesheetWindow {

    Logger logger = Logger.getLogger(TimesheetWindow.class);

    JFrame frame;

    public TimesheetWindow() {
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
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;        
        
        frame.setLocation(x, y);
        frame.setSize(width, height);        
        //frame.pack();
        frame.setVisible(true);
    }

    private void connectDialog() {
        logger.debug("connectDialog()");
        LoginDialog loginDialog = new LoginDialog(frame, null); //TODO LoginInterface
    }
}
