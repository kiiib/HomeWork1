import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
            // waiting for the connection of Client
            System.out.println("Server will be start, waiting for connection with Client");
            Socket socket = serverSocket.accept();
            // obtain input stream and read the information of client
            InputStream inputStream = socket.getInputStream();  //字節輸入流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);   //字節流轉為字符流
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  // 為輸入流添加緩衝
            String info = null;
            //循環讀取客戶端的資訊
            while ((info = bufferedReader.readLine()) != null){
                System.out.println("I am server, client said: " + info);
            }
            socket.shutdownInput(); // close the inputStream

            // close relative resource
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
