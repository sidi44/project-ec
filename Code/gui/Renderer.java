package gui;

import geometry.Shape;

import java.awt.Color;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Paulius Balasevicius
 * @version 2015-02-22
 */
public class Renderer extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private EvoCanvas canvas;
	
	public Renderer(int width, int height, double unitsToPixels){
		this.setSize(width, height);
		this.setLocationRelativeTo(null); // Position the frame at the centre of the screen.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		canvas = new EvoCanvas(unitsToPixels);
		BottomLayer botLayer = new BottomLayer();
		JPanel mainPanel  = new JPanel();
		
		/*
		 * Box Layout
		 * -----------------------
		 * |   height level 1    |
		 * |----------------------
		 * |   height level 2    |
		 * -----------------------
		 */
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(canvas);
		mainPanel.add(botLayer);
		
		
		
		this.setContentPane(mainPanel);		
		this.setVisible(true);
	}
	
	public void doDraw() {

		getCanvas().setBackground(Color.RED);
		int counter = 0;
		
		while(counter < 20){
			try {
				Thread.sleep(1000);

				canvas.setExplicitCall(true);
				canvas.repaint();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void renderShapes(List<Shape> shapes){
		canvas.updateShapes(shapes);
		canvas.setExplicitCall(true);
		canvas.repaint();
	}
		
	public EvoCanvas getCanvas(){
		return canvas;
	}
		
}

