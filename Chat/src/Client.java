import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Jian-Bin Liu on 12/24/2016.
 * Client
 */
public class Client {
    public static void main(String[] args){
        try{
            // create client and assign the ip and port of server
            Socket socket = new Socket("localhost", 8888);
            // get the output stream, send info to server
            OutputStream outputStream = socket.getOutputStream();  //字節輸出流
            PrintWriter printWriter = new PrintWriter(outputStream);    //將輸出流包裝為打印流
            printWriter.write("username: admin, password: 123");
            printWriter.flush();    //清空緩衝區
            socket.shutdownOutput();    //關閉輸出流

            printWriter.close();
            outputStream.close();
            socket.close();

        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
