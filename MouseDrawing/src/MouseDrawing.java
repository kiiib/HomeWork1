
//package mousedrawing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author borson
 */
public class MouseDrawing extends JPanel {
	Point begin, current;
	LinkedList<Drawable> drawables;

	private JToggleButton drawLineButton;	// button with change mode to draw line
	private JToggleButton drawCircleButton;	// button with change mode to draw circle
	private JToggleButton drawRectButton;	// button with change mode to draw Rectangle
	//private JButton cleanCanvasButton;	// button with clean the canvas

	public MouseDrawing() {
		MyListener handler = new MyListener();
		addMouseListener(handler);
		addMouseMotionListener(handler);
		drawables = new LinkedList();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(begin != null && current != null) {
			int minX = Math.min(begin.x, current.x);
			int maxX = Math.max(begin.x, current.x);
			int minY = Math.min(begin.y, current.y);
			int maxY = Math.max(begin.y, current.y);
			g.drawOval(minX, minY, maxX-minX, maxY-minY);
		}
		for(Drawable drawable : drawables) {
			drawable.draw(g);
		}
//		g.drawOval(100, 200, 50, 50);
//		g.drawRect(100, 100, 150, 150);
//		g.drawLine(100, 100, 200, 200);
	}
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("MouseDrawing");
		MouseDrawing mypanel = new MouseDrawing();
		frame.add(mypanel);
        frame.setLayout(new FlowLayout());
		frame.setSize(1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

        JButton cleanCanvasButton = new JButton("clean canvas");    // button with clean the canvas
        cleanCanvasButton.setBounds(20, 20, 200, 50);
        frame.add(cleanCanvasButton);

        //ButtonHandler cleanCanvasHandler = new ButtonHandler();
        cleanCanvasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "pressed");
            }
        });

	}
	private class MyListener extends MouseInputAdapter  {

		@Override
		public void mousePressed(MouseEvent e) {
			begin = e.getPoint();
//			System.out.println("begin is "+begin);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			current = e.getPoint();
			int minX = Math.min(begin.x, current.x);
			int maxX = Math.max(begin.x, current.x);
			int minY = Math.min(begin.y, current.y);
			int maxY = Math.max(begin.y, current.y);
			MyOval oval = new MyOval(minX, minY, maxX-minX, maxY-minY);
			drawables.add(oval);
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			current = e.getPoint();
			repaint();
		}

	}
//	private class ButtonHandler implements ActionListener{
//        public void actionPerformed(ActionEvent event){
//            JOptionPane.showMessageDialog( MouseDrawing.this, String.format(
//                    "You pressed: %s", event.getActionCommand() ) );
//        }
//    }
}
