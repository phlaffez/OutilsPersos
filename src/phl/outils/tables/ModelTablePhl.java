package phl.outils.tables;

import javax.swing.table.AbstractTableModel;

public class ModelTablePhl extends AbstractTableModel{
	
	private Object[][] data;
	   private String[] title;
	  

	public ModelTablePhl() {
		// TODO Auto-generated constructor stub
	}
	
	public ModelTablePhl(Object[][] data, String[] title){
	      this.data = data;
	      this.title = title;
	      
	}
	
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.title.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.data.length;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return this.data[arg0][arg1];
	}
	
	public void setValueAt(Object value, int row, int col) {
	         this.data[row][col] = value;
	   }
	
	
	
	public boolean isCellEditable(int row, int col){
	      return false;    // on ne change rien depuis les tables
	   }
	
	
	
	   //Ajout d'une ligne
	// repris du cours Openclassroom
	   public void addRow(Object[] data){
	      int indice = 0;
	      int nbRow = this.getRowCount();
	      int nbCol = this.getColumnCount();
	       
	      Object temp[][] = this.data;
	      this.data = new Object[nbRow+1][nbCol];
	       
	      for(Object[] value : temp)
	         this.data[indice++] = value;
	       
	          
	      this.data[indice] = data;
	      temp = null;
	      //Cette méthode permet d'avertir le tableau que les données
	      //ont été modifiées, ce qui permet une mise à jour complète du tableau
	      this.fireTableDataChanged();
	      System.out.println("addrow");
	      
	      
	      
	   }
	      
	      // retrait d'une ligne
	   // repris du cours Openclassroom
	      
	      public void removeRow(int position){
	          
	          int indice = 0;
	          int indice2 = 0;
	         int  nbRow = this.getRowCount()-1, nbCol = this.getColumnCount();
	          Object temp[][] = new Object[nbRow][nbCol];
	           
	          for(Object[] value : this.data){
	             if(indice != position){
	                temp[indice2++] = value;
	             }
	             System.out.println("Indice = " + indice);
	             indice++;
	          }
	          this.data = temp;
	          temp = null;
	          //Cette méthode permet d'avertir le tableau que les données
	          //ont été modifiées, ce qui permet une mise à jour complète du tableau
	          this.fireTableDataChanged();
	      this.fireTableDataChanged();
	   }
	      
	    //Retourne le titre de la colonne à l'indice spécifié
	      // pris dans le cours Openclassroom, mais je trouve pas utile
	      public String getColumnName(int col) {
	        return this.title[col];
	      }
	    
	

}
