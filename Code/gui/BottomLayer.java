package gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


/*
 * ---------------------------------------
 * | ||  -------O-----------------  << >> |
 * ---------------------------------------
 */
/**
 * 
 * @author Paulius Balasevicius
 * @version 2015-02-22
 */
public class BottomLayer extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JButton buttonPlayPause;
	private JButton buttonPrevious;
	private JButton buttonNext;
	// Seekbar?
	
	public BottomLayer(){
		setupButtons();
	}
	
	public void setupButtons(){
		buttonPlayPause = new JButton("PP");
		buttonPrevious = new JButton("<<");
		buttonNext = new JButton(">>");
		
		String dashRow = "--------------------------------------------";
		dashRow += dashRow + "------O---------------";
		JButton progressBar = new JButton(dashRow);
		
		this.setLayout( new BoxLayout(this, BoxLayout.X_AXIS) );
		this.add( buttonPlayPause );
		this.add( progressBar );
		this.add( buttonPrevious );
		this.add( buttonNext );
	}
}