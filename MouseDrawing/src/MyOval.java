/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package mousedrawing;

import java.awt.Graphics;

/**
 *
 * @author borson
 */
public class MyOval implements Drawable {
	public int left, top, width, height;
	public MyOval(int left, int top, int width, int height) {
		this.left= left;
		this.top = top;
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(left, top, width, height);
	}
}
