package phl.outils.testsNumeriques;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testNumericTest {

	@Test
	void testEstEntier() {
		boolean a = new testNumeric().estEntier("12");
		assertTrue("test entier vrai",a);
		a = new testNumeric().estEntier("12.5");
		assertFalse("test decimal",a);
		
		new testNumeric().estEntier("douze");
		assertFalse("test texte",a);
	}

}
