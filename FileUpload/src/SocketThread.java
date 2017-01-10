/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Jianbin Liu
 */
public class SocketThread extends Thread {
    private Socket socket = null;
    private ObjectInputStream ois = null;    //input stream
    private ObjectOutputStream oos = null;    //output stream
    private UserService us = new UserService();
    private FileService fs = new FileService();
    //Init socket
    public SocketThread (Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
            CommendTranser transer=(CommendTranser) ois.readObject();
            transer = execute(transer);
            oos.writeObject(transer);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public CommendTranser execute(CommendTranser transer){
        String cmd = transer.getCmd();
        if(cmd.equals("login")){
            Users users=(Users)transer.getData();
            boolean flag=us.Denglu(users);
            transer.setFlag(flag);
            if(flag){
                transer.setResult("Login Successfully");
            }else{
                transer.setResult("Username or password is wrong");
            }
        }else if(cmd.equals("zhuce")){
            Users users=(Users)transer.getData();
            us.zhuce(users);
            boolean flag= us.Denglu(users);
            transer.setFlag(flag);
            if(flag){
                transer.setResult("Regist Successfully");
            }else{
                transer.setResult("Regist failed");

            }
        }else if(cmd.equals("uploadFile")){
            File file=(File)transer.getData();
            fs.savefile(file);
            transer.setResult("upload Successfully");
        }
        return transer;
    }
}
