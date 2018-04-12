package phl.outils.panneaux.outilsStandards;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreTest extends JFrame
{
	private outilsStandTest pan;

	public FenetreTest()
	{
		this.setSize(800,600);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);  
		 String titrePan = "Tests";
		 Color colFond = Color.GREEN;
		 Color colEnt = Color.lightGray; 
		 Color coulTexPP= Color.black;
		 Color centfont = Color.red;
		 Color cboutex = Color.DARK_GRAY;
		 Color cboufon = Color.RED;
		 Color panTab = Color.CYAN;
		 Color coulPanText = Color.WHITE;
		 Color colEntTex = Color.black;
		pan = new outilsStandTest(titrePan,colFond,coulTexPP,panTab,coulPanText,colEnt,
                colEntTex,cboufon,cboutex);
		this.add(pan);
	this.setVisible(true);
	}
	
}
