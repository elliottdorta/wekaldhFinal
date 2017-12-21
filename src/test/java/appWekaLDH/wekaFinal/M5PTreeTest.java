package appWekaLDH.wekaFinal;


import java.io.File;

import org.junit.Test;

import junit.framework.TestCase;
import weka.classifiers.trees.M5P;


public class M5PTreeTest extends TestCase {

	@Test
	public void test() {
		assertNotNull("Not yet implemented");
	}

	
	public final void testJ48Tree() {
		File file_import = new File("datasheets/cpu.arff");
		M5PTree tester = new M5PTree(file_import);
		assertNotNull(tester);
	}
	
	public final void testPrintResult() throws Exception {
		File file_import = new File("datasheets/cpu.arff");
		M5PTree tester = new M5PTree(file_import);	
		String resultado = tester.PrintResult();
		assertTrue(resultado != "");	
	}
	
	
	public final void testClassWekaJ48Tree() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		M5P m5p = (M5P)Class.forName("weka.classifiers.trees.M5P").newInstance();
		assertNotNull(m5p);
	}

}