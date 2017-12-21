package appWekaLDH.wekaFinal;

import java.io.File;

import junit.framework.TestCase;

public class InterfazGraficaTest extends TestCase {
	
	public final void testCargaFicheroCpu() {
		
		File file_input = new File("datasheets/cpu.arff");
		
		assertTrue(file_input.exists());
		
	}
	
	public final void testCargaFicheroIris() {
		
		File file_input = new File("datasheets/iris.arff");
		
		assertTrue(file_input.exists());
		
	}
	
	public final void testCargaFichero() {
		
		File file_input = new File("datasheets/glass.arff");
		
		assertTrue(file_input.exists());
		
	}

}
