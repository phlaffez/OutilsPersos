package phl.outils.panneaux.outilsStandards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanneauOutilsStandard  extends JPanel

/*
 * Cette classe est destinée à l'affichage des petites tables annexes, telles
 * que la table pays, ou la table genre. Ces tables sont utilisées en lecture
 * par les tables de données, mais en écriture uniquement en maintenance,pour
 * ajouter de nouvelles entrées. Leurs tailles étant finies,on n'a pas besoin
 * d'y venir souvent. (On peut travailler avec 20 couleurs de timbres par exemple
 * Il s'agit d'un panneau qui doit être intégré dans une fenêtre
 

*/
{
	// couleurs:sont initialisées par le constructeur
	// peuvent être modifiéées pardessetters
	// n'ont pas à êtrelues par des getters
	private Color coulFond;          // couleur fond du panneau
	private Color coulTextPP;        // couleur texte principal
	private Color coulPanTab;        // couleur de fond du panneau d'affichage de la table
	private Color coulPanText;       // couleur d'affichage du texte de la table
	private Color coulEntete;        // couleur du fond de l'en tête de la table
	private Color coulEnteteText;    // couleur du texte de l'en tête de la table
	private Color coulBotonFond;     // couleur des boutons
	private Color coulBoutonText;    // couleur du texte des boutons
	
	// Messages fixes, titres, etc. Pour internationaliser, mettre les messages
			// dans une MessageFactory. Idée à creuser
			
	
	private JLabel action1 = new JLabel("Entrez la valeur à ajouter ci dessous");
	private JLabel action2 = new JLabel("Cliquez sur une entrée pour modifier le libellé");
	/*
	private JLabel attention = new JLabel("Attention, s'agissant de tables annexes, avec contraintes d'intégrité,");
	private JLabel attention2 = new JLabel("Il n'est pas possible de supprimer une entrée ici.");
	private JLabel attention3 = new JLabel("Seul la modification d'un libellé ou l'insertion d'une");
	private JLabel attention4 = new JLabel("sont possibles");
	// TODO il serait bon de remplacer ces 4 JLabel par un JText
	 * je laisse pour garder le texte du JtexField suivant qui devra être initialisé dans le constructeur
	 * */
	 
	
	// composants du panneau d'en tête:
	
	private JLabel titrePan = new JLabel();
	private JPanel entetePan = new JPanel();
	
	JTextField attention = new JTextField();
	

			
			
			// Boutons
	
	private JButtonOutils boutonAjout;     // initialisé dans une fonction privée spéciale
	private JButtonOutils boutonRetour;    // Même remarque
	
	     //  Menus: Il faut en mettre, c'est obligatoire
			
			// Champ de saisie
	
	private JTextArea champSaisie= new JTextArea();
			
			// Affichage tables
	
	private String[] titres = {"id","Nom"};
	private Object [][] datas;
	private JTable table;
	
	
	// Les differents Layout managers
	BorderLayout topLayout;
	
	
	// Constructeur:
	
	public PanneauOutilsStandard(String titrePan,Color colFond,
			                                   Color cenT,
			                                   Color CentFont) 
	{
		// initialisation
		
		this.setBackground(colFond);
		
		// Titre de la fenêtre
		this.coulEntete = cenT;
		this.titrePan.setText(titrePan);
		
		Font font = new Font("Courier", Font.BOLD, 30);
		this.titrePan.setFont(font);	
		this.titrePan.setForeground(CentFont);
		this.titrePan.setHorizontalAlignment(JLabel.CENTER);
		this.entetePan.setBackground(cenT);
		this.entetePan.add(this.titrePan);
		
		
		// Mise en place des cmposants au niveau hiérarchique supérieur:
		topLayout = new BorderLayout();
		this.setLayout(topLayout);
		this.add(this.entetePan,BorderLayout.NORTH);
		
		

		
		
		// initialisation menus et boutons
		initMenu();
		initBoutons();
	}
	
	// getters et setters
	// pas nécessaire de mettre des getters et setters pour toutes les variables
	// Il faut modifier pour une prise en compte effective des changements de couleur

	
	public void setCoulFond(Color c)
	{
		this.coulFond = c;
	}
	
	public void setCoulTextPP(Color c)
	{
		this.coulTextPP=c;
	}
	
	public void setCoulPanTab(Color c)
	{
		this.coulPanTab = c;
	}
	
	public void setCoulPanText(Color c)
	{
		this.coulPanText = c;
	}
	
	public void setcoulEntete(Color c)
	{
		this.coulEntete=c;
	}
	
	public void setCoulEnteteText(Color c)
	{
		this.coulEnteteText = c;
	}
	
	
	// initialisation des boutons et menus
	
	private void initBoutons()
	{
		
	}
	
	private void initMenu()
	{
		
	}
	
	

}
