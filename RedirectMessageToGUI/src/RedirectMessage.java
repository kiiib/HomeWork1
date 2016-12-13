import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by Jianbin Liu on 12/13/2016.
 */
public class RedirectMessage extends JFrame{

    private JTextArea codeTextArea; // the text area putting javascript code
    private JButton runButton;  // the button running the code of codeTextArea
    private JTextArea codeResultArea;   // the text area outputting the code result

    public RedirectMessage(){
        super("RedirectMessage");
        Box box = Box.createHorizontalBox();    // create box

        String demoCode = "print('hello')\n" +
                "var a = 1\n" +
                "var b = 2\n" +
                "print(a+b)";

        codeTextArea = new JTextArea(demoCode, 10, 10);
        box.add(new JScrollPane(codeTextArea));

        runButton = new JButton("RUN");
        box.add(runButton);

        runButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ScriptEngineManager factory = new ScriptEngineManager();
                        ScriptEngine engine = factory.getEngineByName("JavaScript");
                        try{
                            engine.eval(codeTextArea.getText());
                            OutputStream stream = new OutputStream() {
                                public void write(int b) throws IOException {
                                    codeResultArea.append(String.valueOf((char) b));
                                    if(b == '\n') {
                                        codeResultArea.setCaretPosition(codeResultArea.getDocument().getLength());
                                    }
                                }
                            };
                            System.setOut(new PrintStream(stream));
                        }catch (ScriptException h){
                            h.printStackTrace();
                        }
                    }
                }
        );

        codeResultArea = new JTextArea("you need to click run button twice!!!!\n", 10, 10);
        codeResultArea.setEditable(false);
        box.add(new JScrollPane(codeResultArea));

        add(box);
    }

}
