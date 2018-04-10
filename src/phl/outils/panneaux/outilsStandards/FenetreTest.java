package phl.outils.panneaux.outilsStandards;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreTest extends JFrame
{
	private PanneauOutilsStandard pan;

	public FenetreTest()
	{
		this.setSize(800,600);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);  
		 String titre = "Tests";
		 Color cf = Color.GREEN;
		 Color cenT = Color.lightGray;
		 Color centfont = Color.red;
		 Color cboutex = Color.DARK_GRAY;
		 Color cboufon = Color.RED;
		pan = new PanneauOutilsStandard(titre,cf,cenT,centfont,cboufon,cboutex);
		this.add(pan);
	this.setVisible(true);
	}
	
}
