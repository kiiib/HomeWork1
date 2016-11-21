import javax.swing.*;

/**
 * Created by Jianbin Liu on 11/22/2016.
 */
// Interpolator
class Interpolator<T> {

    public static int frameRate = 100; // frames/sec
    protected double start, end;
    protected double power;
    protected int counter, max;
    protected Class cls;

    public Interpolator(Class cls) {
        this.cls = cls;
        restart(0, 0, 10, 1);
    }

    public void restart(double s, double e, int msec, double p) {
        start = s;
        end = e;
        max = msec * frameRate / 1000;
        power = p;
        counter = 0;
    }

    public boolean finished() {
        return counter == max;
    }

    public void update() {
        if (counter < max) {
            counter++;
        }
    }

    public T get() {
        double ratio = counter / (double) max;
        double value = start + (end - start) * Math.pow(ratio, power);
        if (cls == Float.class) {
            return (T) new Float(value);
        } else if (cls == Integer.class) {
            return (T) new Integer((int) value);
        } else {
            return (T) new Double(value);
        }
    }
}
public class PictureAnimation extends JFrame{

    private JLabel labelPic;

    private Interpolator<Integer> diameter;
    private Interpolator<Float> blue;
    private Interpolator<Integer> xShift;

    public PictureAnimation(String title){
        super(title);

        Icon pic = new ImageIcon(getClass().getResource("images.jpg"));
        labelPic = new JLabel(pic);
        labelPic.setIcon(pic);
        add(labelPic);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]){
        new PictureAnimation("Picture Animation");
    }
}
