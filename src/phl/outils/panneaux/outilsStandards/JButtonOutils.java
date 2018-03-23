package phl.outils.panneaux.outilsStandards;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;



public class JButtonOutils extends JButton
{
	
	public JButtonOutils(String nom,int width, int height, Color couleur)
	{
		this.setText(nom);
		this.setPreferredSize(new Dimension(width, height));              
		this.setBackground(couleur);
		Font police = new Font("Tahoma", Font.BOLD, 14);
		this.setFont(police);
	}
}
