/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
/**
 *
 * @author Jianbin Liu
 */
public class Register extends JFrame implements ActionListener {
    private Box box1, box2, baseBox;
    private JLabel username, password, password2;
    private JTextField usernameText;
    private JPasswordField passwordText, passwordText2;
    private JButton cancelBtn, registerBtn;
    private Socket socket = null;
    
    public Register(){
        setLayout(new FlowLayout());
        init();
        setTitle("Register");
        setSize(250, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    private void init() {
        username = new JLabel("Username");
        password = new JLabel("Password");
        password2=new JLabel("Password again");
        usernameText = new JTextField(10);
        passwordText = new JPasswordField(10);
        passwordText2 = new JPasswordField(10);
        cancelBtn = new JButton("Cancel");
        registerBtn = new JButton("Register");
        box1 = Box.createVerticalBox();
        box2 = Box.createVerticalBox();
        box1.add(username);
        box1.add(Box.createVerticalStrut(10));
        box1.add(password);
        box1.add(Box.createVerticalStrut(10));
        box1.add(password2);
        box1.add(Box.createVerticalStrut(10));

        box2.add(usernameText);
        box2.add(Box.createVerticalStrut(10));
        box2.add(passwordText);
        box2.add(Box.createVerticalStrut(10));
        box2.add(passwordText2);
        box2.add(Box.createVerticalStrut(10));
        baseBox=Box.createHorizontalBox();
        baseBox.add(box1);
        baseBox.add(Box.createHorizontalStrut(5));
        baseBox.add(box2);
        add(baseBox);
        add(registerBtn);
        add(cancelBtn);
        cancelBtn.addActionListener(this);
        registerBtn.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == registerBtn){
            String username = usernameText.getText().trim();
            String password1 = new String(passwordText.getPassword()).trim();
            String password2 = new String(passwordText2.getPassword()).trim();
            if(username == null|| "".equals(username)){
                    JOptionPane.showMessageDialog(null, "Username can't be empty");
                    return ;
            }
            if(password1==null || "".equals(password1)){
                    JOptionPane.showMessageDialog(null, "Password can't be empty");
                    return ;
            }
            if(!(password1.equals(password2))){
                    JOptionPane.showMessageDialog(null, "password different");
                    return ;
            }
            // sent data to server
            Users user = new Users();
            user.setUsername(username);
            user.setPassword(password1);
            
            //System.out.println(username + "     " + password1);
            CommandTranser cmd = new CommandTranser();
            cmd.setCmd("register");
            cmd.setData(user);
            
            try{
                socket = new Socket("localhost", 9998);
                
                
            }catch(UnknownHostException h){
               h.printStackTrace();
            }catch(IOException h) {
                h.printStackTrace();
            } finally {
                clossAll();
            }
            
        }
        //init text
        if(e.getSource()==cancelBtn){
            usernameText.setText(null);
            passwordText.setText(null);
            passwordText2.setText(null);
        }
    }
    
    public void clossAll(){
        try {
            socket.close();
        }catch(IOException h){
            h.printStackTrace();
        }
    }
}



