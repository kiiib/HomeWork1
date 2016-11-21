/**
 * Created by Jianbin Liu on 11/21/2016.
 */

import javax.swing.JFrame;

public class DownloadTest {
    public static void main(String[] args){
        DownLoadFrame downLoadFrame = new DownLoadFrame();  // create the frame
        downLoadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        downLoadFrame.setSize(1000, 600);
        downLoadFrame.setVisible(true); //display the frame
    }
}
