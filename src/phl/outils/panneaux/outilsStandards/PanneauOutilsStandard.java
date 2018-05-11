package phl.outils.panneaux.outilsStandards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class PanneauOutilsStandard  extends JPanel

/*
 * Cette classe est destinée à l'affichage des petites tables annexes, telles
 * que la table pays, ou la table genre. Ces tables sont utilisées en lecture
 * par les tables de données, mais en écriture uniquement en maintenance,pour
 * ajouter de nouvelles entrées. Leurs tailles étant finies,on n'a pas besoin
 * d'y venir souvent. (On peut travailler avec 20 couleurs de timbres par exemple
 * Il s'agit d'un panneau qui doit être intégré dans une fenêtre
 * Il faudra dériver un panneau de celui-ci pour chaque table
 

*/
{
	// couleurs:sont initialisées par le constructeur
	// peuvent être modifiéées par des setters
	// n'ont pas à êtrelues par des getters
	private Color coulFond;          // couleur fond du panneau
	private Color coulTextPP;        // couleur texte principal
	protected Color coulPanTab;        // couleur de fond du panneau d'affichage de la table
	private Color coulPanText;       // couleur d'affichage du texte de la table
	private Color coulEntete;        // couleur du fond de l'en tête de la table
	private Color coulEnteteText;    // couleur du texte de l'en tête de la table
	private Color coulBoutonFond;     // couleur des boutons
	private Color coulBoutonText;    // couleur du texte des boutons
	
	// Messages fixes, titres, etc. Pour internationaliser, mettre les messages
			// dans une MessageFactory. Idée à creuser
			
	
	private JLabel action1 = new JLabel("Entrez la valeur à ajouter ci dessous:");
	private JLabel action2 = new JLabel("Cliquez sur une entrée pour modifier le libellé");
	
	private JLabel attention = new JLabel("Attention, s'agissant de tables annexes, avec contraintes d'intégrité,");
	private JLabel attention2 = new JLabel("Il n'est pas possible de supprimer une entrée ici.");
	private JLabel attention3 = new JLabel("Seules la modification d'un libellé ou l'insertion d'une");
	private JLabel attention4 = new JLabel("nouvelle valeur sont possibles");
	
	 
	
	// composants du panneau d'en tête:
	
	private JLabel titrePan = new JLabel();
	private JPanel entetePan = new JPanel();
	private JPanel actionPan = new JPanel();
	private GridBagConstraints grilleCont = new GridBagConstraints();

			
			
			// Boutons
	
	protected JButtonOutils boutonAjout;     // initialisé dans une fonction privée spéciale
	protected JButtonOutils boutonRetour;    // Même remarque
	
	
	     //  Menus: Il faut en mettre, c'est obligatoire
			
			// Champ de saisie
	
	protected JTextField champSaisie= new JTextField();
			
			// Affichage tables
	protected JTable table;
	protected JPanel panTable = new JPanel();
	
	
	// panneau bas pour le bouton de retour
	
	JPanel panBas = new JPanel();
	
	// Les differents Layout managers
	BorderLayout topLayout;
	
	
	// Constructeur:
	
	public PanneauOutilsStandard(String titrePan,
			                                  Color colFond,
			                                  Color coulTexPP,
			                                  Color coulPanTab,
			                                  Color coulPanText,
			                                  Color colEnt,
			                                   Color colEntTex,
			                                   Color cboufon,
			                                   Color cboutex) 
	
	
	
	{
		// initialisation
		
		this.coulFond=colFond;
		this.coulTextPP = coulTextPP;
		this.coulPanTab = coulPanTab;
		this.coulPanText = coulPanText;
		this.coulEntete = colEnt;
		this.coulEnteteText = colEntTex;
		this.setBackground(this.coulFond);
		this.setSize(new Dimension(800,400));
		
		// couleurs:
		this.coulEntete = colEnt;
		this.coulBoutonText=cboutex;
		this.coulBoutonFond=cboufon;
		
		// Titre du panneau
	
		this.titrePan.setText(titrePan);
		
		Font font = new Font("Courier", Font.BOLD, 30);
		this.titrePan.setFont(font);	
		this.titrePan.setForeground(this.coulPanText);
		this.titrePan.setHorizontalAlignment(JLabel.CENTER);
		this.entetePan.setBackground(this.coulEntete);
		this.entetePan.add(this.titrePan);
		
		// Panneau gauche: saisie
		this.actionPan.setPreferredSize(new Dimension(400,400));
		this.actionPan.setLayout(new GridBagLayout() );

		
		this.grilleCont.gridx=0;
		this.grilleCont.gridy=0;
		this.grilleCont.gridheight=1;
		this.grilleCont.gridwidth=6;
		this.grilleCont.anchor=GridBagConstraints.FIRST_LINE_START;
		this.actionPan.add(this.action1,grilleCont);
		this.grilleCont.gridwidth = GridBagConstraints.REMAINDER;
		
		this.grilleCont.gridx=0;
		this.grilleCont.gridy=1;
		this.grilleCont.gridheight=1;
		this.grilleCont.gridwidth=4;
		this.champSaisie.setBackground(Color.WHITE);
		this.champSaisie.setSize(new Dimension(300,40));
		this.champSaisie.setVisible(true);
		Font f = new Font("Courier", Font.BOLD, 14);
		this.champSaisie.setFont(f);
		this.champSaisie.setPreferredSize(new Dimension(200,50));
		this.actionPan.add(this.champSaisie,grilleCont);
		
		this.grilleCont.gridx=4;
		this.grilleCont.gridy=1;
		this.grilleCont.gridheight=1;
		this.grilleCont.gridwidth=2;
		this.grilleCont.anchor=GridBagConstraints.FIRST_LINE_END;
		this.boutonAjout = new JButtonOutils("Ajouter",100,40,this.coulBoutonFond);
		this.boutonAjout.setForeground(this.coulBoutonText);
		this.actionPan.add(this.boutonAjout,grilleCont);
		this.grilleCont.gridwidth = GridBagConstraints.REMAINDER;
		
		this.grilleCont.gridx=0;
		this.grilleCont.gridy=2;
		this.grilleCont.gridheight=1;
		this.grilleCont.gridwidth=6;
		this.grilleCont.anchor=GridBagConstraints.FIRST_LINE_START;
		this.actionPan.add(this.attention,grilleCont);
		this.grilleCont.gridwidth = GridBagConstraints.REMAINDER;
		
		
		this.grilleCont.gridx=0;
		this.grilleCont.gridy=3;
		this.grilleCont.gridheight=1;
		this.grilleCont.gridwidth=6;
		this.actionPan.add(this.attention2,grilleCont);
		this.grilleCont.gridwidth = GridBagConstraints.REMAINDER;
	
		this.grilleCont.gridx=0;
		this.grilleCont.gridy=4;
		this.grilleCont.gridheight=1;
		this.grilleCont.gridwidth=6;
		this.actionPan.add(this.attention3,grilleCont);
		this.grilleCont.gridwidth = GridBagConstraints.REMAINDER;
		
		
		this.grilleCont.gridx=0;
		this.grilleCont.gridy=5;
		this.grilleCont.gridheight=1;
		this.grilleCont.gridwidth=6;
		this.actionPan.add(this.attention4,grilleCont);
		this.grilleCont.gridwidth = GridBagConstraints.REMAINDER;

		// Panneau de droite: affichage de la table
		// elle doit être passée en paramètres
		
		this.panTable.setBackground(this.coulPanTab);
		this.panTable.setSize(new Dimension(400,300));
		
		// Panneau bas avec bouton de retour
		
		this.boutonRetour = new JButtonOutils("Quitter",100,50,this.coulBoutonFond);
		this.boutonRetour.setForeground(this.coulBoutonText);
		this.panBas.setBackground(Color.LIGHT_GRAY);
		this.panBas.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.panBas.add(this.boutonRetour);
		
		this.initTable();      // affiche la table adequate
		
		// Mise en place des composants au niveau hiérarchique supérieur:
		topLayout = new BorderLayout();
		this.setLayout(topLayout);
		this.add(this.entetePan,BorderLayout.NORTH);
		this.add(this.actionPan,BorderLayout.WEST);
		this.add(this.panTable,BorderLayout.CENTER);
		this.add(this.panBas,BorderLayout.SOUTH);
		
		

		
		
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
	
	protected abstract void initBoutons();
	protected abstract void initMenu();
	protected abstract void initTable();


}
