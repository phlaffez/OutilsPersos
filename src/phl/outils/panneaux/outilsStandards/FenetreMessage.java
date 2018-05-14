package phl.outils.panneaux.outilsStandards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FenetreMessage extends JFrame{
	
	// nom fenetre:
	private String nomFenetre;

	// titre:
	private String titre;
	private JLabel labelTitre= new JLabel();
	private JPanel jpanTitre = new JPanel();
	
	// message:
	private String msg;
	private JTextField jtf = new JTextField();
	
	private JPanel jp=new JPanel();
	private JButtonOutils bOK = new JButtonOutils("OK",100,50,  Color.RED);	
private JPanel jpbout = new JPanel();

	private int largeur;
	private int hauteur;
	private Color colFond;
	private Color colTexte;

	

	public FenetreMessage(String nomFenetre,String titre,String msg, int largeur, int hauteur, Color colFond, Color colTexte) {
		
		this.msg=msg;
		this.titre=titre;
		this.colFond=colFond;
		this.colTexte=colTexte;
		this.largeur=largeur;
		this.hauteur=hauteur;

		
		this.setSize(this.largeur, this.hauteur);
		// préparation du panneau:
		this.jp= new JPanel();
		this.jp.setSize(this.largeur, this.hauteur);
		this.jp.setBackground(this.colFond);
		this.jp.setLayout(new BorderLayout());
		
		this.setTitle(nomFenetre);
		
		this.labelTitre.setBackground(this.colFond);
		this.labelTitre.setForeground(this.colTexte);
		this.labelTitre.setText(this.titre);	
		this.labelTitre.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		this.labelTitre.setSize(this.largeur, 50);
		this.jpanTitre.setLayout(new BorderLayout());
		this.jpanTitre.add(this.labelTitre, BorderLayout.CENTER);
		
		this.jp.add(this.jpanTitre,BorderLayout.NORTH);
		
		this.jtf.setBackground(this.colFond);
		this.jtf.setForeground(this.colTexte);
		this.jtf.setEditable(false);
		this.jtf.setMargin(new Insets(10,10,10,10));
		this.jtf.setAlignmentX(JTextField.CENTER_ALIGNMENT);
		this.jtf.setText(this.msg);
		this.jp.add(this.jtf,BorderLayout.CENTER);
		
		this.bOK.addActionListener(new OkListener());
		this.jpbout.setBackground(this.colFond);this.jpbout.setLayout(new BorderLayout());
		this.jpbout.add(this.bOK,BorderLayout.EAST);
		this.jp.add(this.jpbout,BorderLayout.SOUTH);
		
		this.setContentPane(this.jp);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
				
	}
	
class  OkListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Appui bouton OK");

		
	}
	
}

}
