package gui;

import geometry.Circle;
import geometry.Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

/**
 * 
 * @author Paulius Balasevicius
 * @version 2015-02-22
 */
public class EvoCanvas extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private List<Shape> mShapes;

	private final double UNITS_TO_PIXELS;

	private boolean explicitCall;

	public EvoCanvas(double unitsToPixels){
		//mShapes = new ArrayList<Shape>();
		UNITS_TO_PIXELS = unitsToPixels;
		this.setBackground(Color.DARK_GRAY);

		this.setBackground(Color.BLACK);
		
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		if( explicitCall && mShapes != null){
			
			for(Shape shape: mShapes){
				if(shape instanceof Circle) {
					renderCircle((Circle) shape, g2);
				} 
//				else if (shape instanceof EvoPolygon) {
//					//renderPolygon(shape);
//				}
			}
			
		} else {


		}

		setExplicitCall(false);
	}

	/**
	 * 
	 * @param circle - The circle to be rendered.
	 * @param g - The graphics context object needed for drawing.
	 */
	public void renderCircle(Circle circle, Graphics2D g){		
		
		int radius = (int) (circle.getRadius() * UNITS_TO_PIXELS);
		int posX = (int) ( (circle.getReference().getX() - radius) * UNITS_TO_PIXELS);
		int posY = (int) ( (circle.getReference().getY() - radius) * UNITS_TO_PIXELS);

		g.setColor(Color.CYAN);
//		g.fillOval(posX, posY, radius, radius);
		g.drawOval(posX, posY, radius, radius);
	}

	public void updateShapes(List<Shape> lst){
		mShapes = lst;
	}   

	public boolean isExplicitCall(){
		return this.explicitCall;
	}

	public void setExplicitCall(boolean tf){
		this.explicitCall = tf;
	}
	
}