import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.concurrent.SynchronousQueue;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author Jianbin Liu
 */
public class MouseDrawing extends JPanel {
	Point begin, current;
	LinkedList<Drawable> drawables;
	//int drawState = 0;	// 0 is Rect, 1 is Circle, 2 is Line
	enum DrawType{
		Rect, Circle, Line;
	}
	DrawType drawState = DrawType.Rect;
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
			switch (drawState){
				case Rect:
					g.drawRect(minX, minY, maxX-minX, maxY-minY);
					break;
				case Circle:
					g.drawOval(minX, minY, maxX-minX, maxY-minY);
					break;
				case Line:
					g.drawLine(begin.x, begin.y, current.x, current.y);
					break;
			}

		}
		for(Drawable drawable : drawables) {
			drawable.draw(g);
		}
//		g.drawOval(100, 200, 50, 50);
//		g.drawRect(100, 100, 150, 150);
//		g.drawLine(100, 100, 200, 200);
	}
	private class MyListener extends MouseInputAdapter  {

		@Override
		public void mousePressed(MouseEvent e) {
			begin = e.getPoint();
//			System.out.println("begin is "+begin);
			//System.out.println(drawState);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			current = e.getPoint();
			int minX = Math.min(begin.x, current.x);
			int maxX = Math.max(begin.x, current.x);
			int minY = Math.min(begin.y, current.y);
			int maxY = Math.max(begin.y, current.y);
			switch (drawState){
				case Rect:
					MyRect rect = new MyRect(minX, minY, maxX-minX, maxY-minY);
					drawables.add(rect);
					break;
				case Circle:
					MyOval oval = new MyOval(minX, minY, maxX-minX, maxY-minY);
					drawables.add(oval);
					break;
				case Line:
					MyLine line = new MyLine(begin.x, begin.y, current.x, current.y);
					drawables.add(line);
					break;
			}
			//System.out.println(drawables.toString());
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			current = e.getPoint();
			repaint();
		}
	}
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("MouseDrawing");
		MouseDrawing mypanel = new MouseDrawing();
		//frame.add(mypanel);

		frame.setSize(1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton cleanCanvasButton = new JButton("clean canvas");    // button with clean the canvas
		JToggleButton drawRectButton =  new JToggleButton("Rectangle",true);    // button with draw the Rectangle
		JToggleButton drawCircleButton =  new JToggleButton("Circle");    // button with draw the Circle
		JToggleButton drawLineButton =  new JToggleButton("Line");    // button with draw the Line

		Panel ButtonGroup = new Panel();
		ButtonGroup.add(cleanCanvasButton);
		ButtonGroup.add(drawRectButton);
		ButtonGroup.add(drawCircleButton);
		ButtonGroup.add(drawLineButton);

		//frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(BorderLayout.NORTH, ButtonGroup);
		frame.getContentPane().add(BorderLayout.CENTER, mypanel);
		frame.setVisible(true);


        cleanCanvasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				mypanel.drawables.clear();
				mypanel.repaint();
            }
        });
		drawRectButton.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					System.out.println("select rect");
					drawCircleButton.setSelected(false);
					drawLineButton.setSelected(false);
					mypanel.drawState = DrawType.Rect;
				}
				else{
					System.out.println("un select rect");
					if(!drawCircleButton.isSelected() && !drawLineButton.isSelected()){
						drawRectButton.setSelected(true);
						mypanel.drawState = DrawType.Rect;
					}
				}
			}
		});
		drawCircleButton.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					System.out.println("select Circle");
					drawRectButton.setSelected(false);
					drawLineButton.setSelected(false);
					mypanel.drawState = DrawType.Circle;
				}
				else{
					System.out.println("un select Circle");
					if(!drawRectButton.isSelected() && !drawLineButton.isSelected()){
						drawCircleButton.setSelected(true);
						mypanel.drawState = DrawType.Circle;
					}
				}
			}
		});
		drawLineButton.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					System.out.println("select line");
					drawCircleButton.setSelected(false);
					drawRectButton.setSelected(false);
					mypanel.drawState = DrawType.Line;
				}
				else{
					System.out.println("un select line");
					if(!drawRectButton.isSelected() && !drawCircleButton.isSelected()){
						drawLineButton.setSelected(true);
						mypanel.drawState = DrawType.Line;
					}
				}
			}
		});

	}

//	private class ButtonHandler implements ActionListener{
//        public void actionPerformed(ActionEvent event){
//            JOptionPane.showMessageDialog( MouseDrawing.this, String.format(
//                    "You pressed: %s", event.getActionCommand() ) );
//        }
//    }
}
