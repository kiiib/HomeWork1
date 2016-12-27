import java.io.*;
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
            printWriter.write("username: haha, password: 123");
            printWriter.flush();    //清空緩衝區
            socket.shutdownOutput();    //關閉輸出流

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String info = null;
            //循環讀取客戶端的資訊
            while ((info = bufferedReader.readLine()) != null){
                System.out.println("I am client , server said: " + info);
            }

            //close
            bufferedReader.close();
            inputStream.close();
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
