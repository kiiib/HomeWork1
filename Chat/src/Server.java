import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Jian-Bin Liu on 12/24/2016.
 * Server
 */
public class Server {
    public static void main(String[] args){
        try{
            // create a server socket, and assign the port
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = null;
            // record client #
            int clientCount = 0;

            // waiting for the connection of Client
            System.out.println("Server will be start, waiting for connection with Client");

            //一直等待連線
            while (true){
                //accept 方法開始監聽，等待Client連線
                socket = serverSocket.accept();
                //create a server thread
                ServerThread serverThread = new ServerThread(socket);
                //start thread
                serverThread.start();

                clientCount++;
                System.out.println("Client amount: " + clientCount);

                InetAddress address = socket.getInetAddress();
                System.out.println("current client IP address: " + address.getHostAddress());
            }
            //serverSocket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
