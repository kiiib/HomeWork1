import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Jianbin Liu on 11/21/2016.
 */
public class DownLoadFrame extends JFrame {
    private JLabel label1;
    private JLabel label2;
    private JTextField textWebSiteLink;
    private JButton downloadButton;

    public DownLoadFrame(){
        super("Download data");
        setLayout(new FlowLayout());    //set frame layout

        label1 = new JLabel("please enter BBC news website link");
        label1.setToolTipText("please enter BBC news the website link");
        add(label1);

        textWebSiteLink = new JTextField("http://www.bbc.com/news/uk-politics-38051579", 50);
        add(textWebSiteLink);

        downloadButton = new JButton("Download");
        add(downloadButton);

        label2 = new JLabel("here will show the news title");
        label2.setSize(500, 200);
        label2.setFont(new Font("KaiTi", Font.PLAIN, 20));
        add(label2);

        downloadButton.addActionListener((ActionEvent e) -> {
            downloadButton.setEnabled(false);
            new Thread(){
                public void run(){
                    Http http = new Http();
                    try {
                        label2.setText(http.loadURL(textWebSiteLink.getText()));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    System.out.println("download finished");
                    downloadButton.setEnabled(true);
                }
            }.start();
        });
    }   // end DownloadFrame constructor


}
