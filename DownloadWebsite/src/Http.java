import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Jianbin Liu on 11/21/2016.
 */
public class Http {

    public static void main(String args[]) throws IOException{
        //loadURL(args[0]);
    }

    public static String loadURL(String request) throws IOException{
        URL u = new URL(request);
        URLConnection connection = u.openConnection();

        InputStream stream = connection.getInputStream();
        Reader decoder = new InputStreamReader(stream, "UTF-8");
        BufferedReader in = new BufferedReader(decoder);

        String line;
        String newsTitle = "";
        int beg = 0;
        int end = 0;
        while ((line = in.readLine()) != null){
            //System.out.println(line);
            while(true){
                if(beg != 0) break; // in case the second one which also have <title> appears
                if(line.indexOf("<title>") < 0) break;
                beg = line.indexOf("<title>");
                end = line.indexOf("</title>");
                newsTitle = line.substring(beg + 7, end);
            }
        }

        System.out.println(newsTitle);
        in.close();

        return newsTitle;
    }
}
