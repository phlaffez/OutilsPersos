package phl.outils.testsNumeriques;

public class testNumeric {
	

	public testNumeric() {
	}
	
	public boolean estEntier(String s)
	{
		try {
			Integer.parseInt(s);
			} 
		catch (NumberFormatException e)
		{
			return false;
			}
			return true;
	}
	
	

}
