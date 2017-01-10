
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jianbin Liu
 */
public class StartSever extends JFrame implements ActionListener {

    private JButton startServerBtn; // start server
    private JButton closeServerBtn;  // end the server
//    private Service
    
    public StartSever(){
        setLayout(new FlowLayout());
        startServerBtn = new JButton("Start Server");
        closeServerBtn = new JButton("Close Server");
        add(startServerBtn);
        add(closeServerBtn);
        setTitle("Server");
        setSize(250,100);
        setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
        startServerBtn.addActionListener(this);
        closeServerBtn.addActionListener(this);
    }
    
    public static void main(String[] args){
        new StartSever();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startServerBtn){
            System.out.println("Welcome");
            try {
                ServerSocket serversocket=new ServerSocket(9998);
                Socket socket=null;
                System.out.println("");
                while(true){
                    socket=serversocket.accept();
                    System.out.println("Welcome");
                    SocketThread thread = new SocketThread(socket);
                    thread.start();

                }

            }catch(IOException h){
                h.printStackTrace();
            }
            
            
        }
        
    }
    
    
}
