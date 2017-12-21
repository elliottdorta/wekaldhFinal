package appWekaLDH.wekaFinal;



import java.io.File;

import org.junit.Test;

import junit.framework.TestCase;
import weka.classifiers.trees.J48;


public class J48TreeTest extends TestCase {

	@Test
	public void test() {
		assertNotNull("Not yet implemented");
	}

	
	public final void testJ48Tree() {
		File file_import = new File("datasheets/iris.arff");
		J48Tree tester = new J48Tree(file_import);
		assertNotNull(tester);
	}
	
	public final void testPrintResult() throws Exception {
		File file_import = new File("datasheets/iris.arff");
		J48Tree tester = new J48Tree(file_import);	
		assertTrue(tester.resultado != "");	
	}
	
	public final void testClassWekaJ48Tree() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		J48 j48 = (J48)Class.forName("weka.classifiers.trees.J48").newInstance();
		assertNotNull(j48);
	}

}