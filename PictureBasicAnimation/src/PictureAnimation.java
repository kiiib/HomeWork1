import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.io.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;

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

public class PictureAnimation extends JFrame {

    private Interpolator<Integer> diameter;
    private Interpolator<Float> blue;
    private Interpolator<Integer> xShift;
    private JLabel labelPic;
    enum State {

        INIT_ENLARGE,
        ENLARGE,
        INIT_SHRINK,
        SHRINK
    }

    public PictureAnimation(String title) {
        super(title);
        diameter = new Interpolator(Integer.class);
        blue = new Interpolator(Float.class);
        xShift = new Interpolator(Integer.class);

        add(new JPanel() {
            Image image;

            @Override
            public void setOpaque(boolean isOpaque) {
                super.setOpaque(isOpaque);
            }
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                int size = diameter.get();
                int shift = xShift.get();

                try {
                    image = ImageIO.read(new File("images.jpg"));
                }
                catch (Exception ex) {
                    System.out.println("No this jpg!");
                }

                g.drawImage(image, 50 + shift, 50 + shift, size, size, new Color(1, .5f, 1, 0.1f), null);
                g.setColor(new Color(1, 1, 1, blue.get()));
                g.fillRect(50 + shift, 50 + shift, size, size);
            }
        });

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        startAnimation();

    }

    private void startAnimation() {
        int interval = 1000 / Interpolator.frameRate;
        new Timer(interval, new ActionListener() {

            State state = State.INIT_ENLARGE;

            @Override
            public void actionPerformed(ActionEvent e) {
                switch (state) {
                    case INIT_ENLARGE:
                        diameter.restart(0, 100, 800, 2.0);
                        blue.restart(0, 1.0, 800, 2.0);
                        xShift.restart(0, 100, 800, 2.0);
                        state = State.ENLARGE; // wait for ending of animation
                        break;
                    case INIT_SHRINK:
                        diameter.restart(100, 0, 1000, 0.5);
                        blue.restart(1.0, 0.0, 1000, 0.5);
                        xShift.restart(100, 0, 1000, 0.5);
                        state = State.SHRINK;  // wait for ending of animation
                        break;
                    case ENLARGE:
                    case SHRINK:
                        if (diameter.finished()) {
                            if (state == State.ENLARGE) {
                                state = State.INIT_SHRINK;
                            } else {
                                state = State.INIT_ENLARGE;
                            }
                            break;
                        }
                        diameter.update();
                        blue.update();
                        xShift.update();
                        repaint();
                        break;
                    default:
                        return;
                }
            }
        }).start();
    }

    public static void main(String args[]) {
        new PictureAnimation("Picture Animation");
    }
}
