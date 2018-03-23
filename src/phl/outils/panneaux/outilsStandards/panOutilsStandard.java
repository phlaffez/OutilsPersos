package phl.outils.panneaux.outilsStandards;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class panOutilsStandard 


//tous les composants sont des variables private
	// eventuellement accessibles par des setters, et getters, et doivent
	// être initialisés par les paramètres du constructeur
	

	// tous les composants sont des variables private
		// eventuellement accessibles par des setters, et getters, et doivent
		// être initialisés par les paramètres du constructeur
		
		private JLabel titreFenetre;
		// les divers messages:
		
		private JLabel action = new JLabel("Entrez la nouvelle valeur ci dessous:");
		private JLabel attention = new JLabel("Atention, s'agissant de tables annexes,avec contraintes d'intégrité");
		private JLabel attention2= new JLabel("dès qu'une entrée , une autre table y fait référence,");
		private JLabel attention3 = new JLabel("On ne peut supprimer une entrée depuis ce programme");
		private JLabel expose = new JLabel("Liste des entrées de la table");
		private JLabel action2 = new JLabel("Cliquezsur une entrée pour modifier un nom");
		
		// boutons:
		
		private JButtonOutils boutonAjout;
		private JButtonOutils boutonRetour;
		
		// champ de saisie
		private JTextArea champSaisie = new JTextArea();
		
		// Liste des entrées:
		// Il faut un composant table, un panneau et des ascenseurs, des datas, un titre
		// datas:
		
		private String[] titres = {"id","Nom"};
		private Object [][] datas;
		private JTable table;
	 // cosmétique:
		private JPanel panResult;  // à utiliser avec un JScrollPanel{

}
