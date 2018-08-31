package phl.outils.panneaux.outilsStandards;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JButtonGraph extends JButton
{

	public JButtonGraph() {
		// TODO Auto-generated constructor stub
	}

	public JButtonGraph(String nom,int width, int height, Color couleur, String icon)
	{
		this.setText(nom);
		this.setPreferredSize(new Dimension(width, height));              
		this.setBackground(couleur);
		Font police = new Font("Tahoma", Font.BOLD, 14);
//		this..setBounds(new Rectangle(218, 21, 129, 33));  dans l'exemple
		this.setFont(police);
		this.setIcon(new ImageIcon(icon));
	}
	
}
