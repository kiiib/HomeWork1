import java.awt.Graphics;

/**
 *
 * @author borson
 */
public class MyLine implements Drawable {
    public int left, top, width, height;
    public MyLine(int left, int top, int width, int height) {
        this.left= left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        //g.drawOval(left, top, width, height);
        //g.drawRect(left, top, width, height);
        g.drawLine(left, top, width, height);
    }
}
