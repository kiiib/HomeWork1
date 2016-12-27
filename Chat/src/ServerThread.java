import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Jianbin Liu on 12/27/2016.
 * Class: handle server thread
 */
public class ServerThread extends Thread {
    Socket socket = null;
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    //線程執行操作，響應Client的請求
    public void run(){
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        try{
            // obtain input stream and read the information of client
            inputStream = socket.getInputStream();  //字節輸入流
            inputStreamReader = new InputStreamReader(inputStream);   //字節流轉為字符流
            bufferedReader = new BufferedReader(inputStreamReader);  // 為輸入流添加緩衝
            String info = null;
            //循環讀取客戶端的資訊
            while ((info = bufferedReader.readLine()) != null){
                System.out.println("I am server, client said: " + info);
            }
            socket.shutdownInput(); // close the inputStream

            // get the output stream, response client request
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream); //包裝為打印流
            printWriter.write("Welcome!");
            printWriter.flush();

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                // close relative resource
                if(printWriter != null)
                    printWriter.close();
                if(outputStream != null)
                    outputStream.close();
                if(bufferedReader != null)
                    bufferedReader.close();
                if(inputStreamReader != null)
                    inputStreamReader.close();
                if(inputStream != null)
                    inputStream.close();
                if(socket != null)
                    socket.close();

            }catch (IOException e){
                e.printStackTrace();
            }

        }

    }
}
