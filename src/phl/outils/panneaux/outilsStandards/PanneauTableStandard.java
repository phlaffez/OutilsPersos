package phl.outils.panneaux.outilsStandards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public abstract class PanneauTableStandard extends JPanel{
	
	/*
	 * Cette classe est destinée à l'affichage des tables principales, telles
	 * que la table auteurs, ou la table livres. 
	 * Il s'agit d'un panneau qui doit être intégré dans une fenêtre
	 * Il faudra dériver un panneau de celui-ci pour chaque table
	 * Doivent être inclus un bouton pour créer un nouvel enregistrement
	 * un bouton de tri
	 * un bouton de recherche 
	 * et un bouton pour effacer "en masse"
	 * un double clic sur une ligne doit afficher le détail d'une fiche
	 * une colonne doit être ajoutée pour la sélection (cases à cocher)
	 

	*/
	
	
	// couleurs:sont initialisées par le constructeur
	// peuvent être modifiéées par des setters
	// n'ont pas à être lues par des getters
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
	
	private JLabel action1 = new JLabel("Double clic sur une ligne pour afficher les détails");
	
	
	// composants du panneau d'en tête:
	
	private JLabel titrePan = new JLabel();
	private JPanel entetePan = new JPanel();
	// Boutons
	
protected JButtonOutils boutonAjout;     // initialisé dans une fonction privée spéciale
protected JButtonOutils boutonRetour;    // Même remarque
protected JButtonOutils boutonRecherche; // Même remarque
protected JButtonOutils boutonSupprime;  // Même remarque
protected JButtonOutils boutonTri;      // Même remarque. Peut être clic sur entetes de colonnes pour remplacer ??


 //  Menus: Il faut en mettre, c'est obligatoire

protected JTable table;
protected JPanel panTable = new JPanel();


// panneau bas pour lesboutons

JPanel panBas = new JPanel();

// Le LayoutManager (on utilisera North, Center et South)
BorderLayout topLayout;


//Constructeur:

	public PanneauTableStandard(String titrePan,
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
			
			// Panneau central: affichage de la table
			// elle doit être passée en paramètres
			
			this.panTable.setBackground(this.coulPanTab);
			this.panTable.setSize(new Dimension(400,300));
		
		
			this.initTable();      // affiche la table adequate
			
			// Panneau bas avec boutons 
			
			this.boutonAjout = new JButtonOutils("Ajouter",120,50,this.coulBoutonFond);
			this.boutonRetour = new JButtonOutils("Quitter",120,50,this.coulBoutonFond);
			this.boutonRecherche = new JButtonOutils("Chercher",120,50,this.coulBoutonFond);
			this.boutonTri = new JButtonOutils("Trier",120,50,this.coulBoutonFond);
			this.boutonSupprime = new JButtonOutils("Supprimer",120,50,this.coulBoutonFond);
			
			this.boutonAjout.setForeground(this.coulBoutonText);
			this.boutonRetour.setForeground(this.coulBoutonText);
			this.boutonRecherche.setForeground(this.coulBoutonText);
			this.boutonTri.setForeground(this.coulBoutonText);
			this.boutonSupprime.setForeground(this.coulBoutonText);
	
			this.panBas.setBackground(Color.LIGHT_GRAY);
			this.panBas.setLayout(new FlowLayout(FlowLayout.CENTER));
			this.panBas.add(this.boutonAjout);
			this.panBas.add(this.boutonRecherche);
			this.panBas.add(this.boutonTri);
			this.panBas.add(this.boutonSupprime);
			this.panBas.add(this.boutonRetour);
		
			// Mise en place des composants au niveau hiérarchique supérieur:
			topLayout = new BorderLayout();
			this.setLayout(topLayout);
			this.add(this.entetePan,BorderLayout.NORTH);
			this.add(this.panTable,BorderLayout.CENTER);
			this.add(this.panBas,BorderLayout.SOUTH);
		
			// initialisation menus et boutons
			initMenu();
			initBoutons();
			
			
		
	}
	
	// initialisation des boutons et menus
	
		protected abstract void initBoutons();
		protected abstract void initMenu();
		protected abstract void initTable();
		

		
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
	
	

}
