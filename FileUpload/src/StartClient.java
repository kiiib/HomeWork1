
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jianbin Liu
 */
public class StartClient extends JFrame implements ActionListener {
    public static void main(String[] args) {
        StartClient client = new StartClient();
    }

    private Box box1, box2, box3, baseBox;
    private JLabel username, password;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JButton loginBtn, registerBtn;
        
    public StartClient(){
        setLayout(new FlowLayout());
        init();
        setTitle("Client");
        setSize(200, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    
    private void init() {
        username = new JLabel("Username");
        password = new JLabel("Password");
        usernameText = new JTextField(10);
        passwordText = new JPasswordField(10);
        loginBtn = new JButton("Login");
        registerBtn = new JButton("Regist");
        box1 = Box.createHorizontalBox();
        box2 = Box.createHorizontalBox();
        box3 = Box.createHorizontalBox();
        box1.add(username);
        box1.add(Box.createHorizontalStrut(8));
        box1.add(usernameText);
        box2.add(password);
        box2.add(Box.createHorizontalStrut(8));
        box2.add(passwordText);
        box3.add(loginBtn);
        box3.add(Box.createHorizontalStrut(8));
        box3.add(registerBtn);
        baseBox = Box.createVerticalBox();
        baseBox.add(box1);
        baseBox.add(Box.createVerticalStrut(5));
        baseBox.add(box2);
        baseBox.add(Box.createVerticalStrut(5));
        baseBox.add(box3);
        baseBox.add(Box.createVerticalStrut(5));
        add(baseBox);
        loginBtn.addActionListener(this);
        registerBtn.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loginBtn){
            
        }
        
        if(e.getSource()==registerBtn){
            new Register();
        }
    }
    
    
}
