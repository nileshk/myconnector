package com.myconnector.client.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.apache.log4j.Logger;

/**
 * 
 * @author Nilesh Kapadia (nileshka@gmail.com)
 */
public class LoginDialog {

    Logger logger = Logger.getLogger(LoginDialog.class);

    JTextField textFieldUsername;

    JTextField textFieldPassword;
    
    LoginInterface loginService;

    public LoginDialog(JFrame owner, LoginInterface loginService) {
        this.loginService = loginService;
        
        JDialog.setDefaultLookAndFeelDecorated(true);
        JDialog dialog = new JDialog(owner, "Login", true);
        dialog.setLayout(new GridLayout(3, 2));
        //dialog.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);

        JLabel labelUsername = new JLabel("Username", JLabel.CENTER);
        JLabel labelPassword = new JLabel("Password", JLabel.CENTER);
        textFieldUsername = new JTextField();
        textFieldPassword = new JTextField();
        textFieldUsername.setText("admin");
        textFieldPassword.setText("admin");
        JButton buttonConnect = new JButton("Connect");
        JButton buttonCancel = new JButton("Cancel");
        buttonConnect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logger.debug("connect button");
                doLogin();
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logger.debug("cancel button");
                doCancel();
            }
        });

        dialog.getContentPane().add(labelUsername);
        dialog.getContentPane().add(textFieldUsername);
        dialog.getContentPane().add(labelPassword);
        dialog.getContentPane().add(textFieldPassword);
        dialog.getContentPane().add(buttonConnect);
        dialog.getContentPane().add(buttonCancel);
        
        dialog.getRootPane().setDefaultButton(buttonConnect);

        int width = 300;
        int height = 100;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;        
        
        dialog.setLocation(x, y);
        dialog.setSize(width, height);                
        //dialog.pack();
        dialog.setVisible(true);
    }

    private void doLogin() {
        String username = textFieldUsername.getText();
        String password = textFieldPassword.getText();
        loginService.login(username, password);
    }    
    
    protected void doCancel() {
        logger.debug("TODO cancel button");
    }

}
