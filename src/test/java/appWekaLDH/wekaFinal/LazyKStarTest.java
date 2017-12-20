package appWekaLDH.wekaFinal;

import java.io.File;

import junit.framework.TestCase;
import weka.classifiers.lazy.KStar;

public class LazyKStarTest extends TestCase {

	public final void testLazyKStar() {
		File file_import = new File("datasheets/iris.arff");
		LazyKStar tester = new LazyKStar(file_import);
		assertNotNull(tester);
	}
	
	public final void testPrintResult() throws Exception {
		File file_import = new File("datasheets/iris.arff");
		LazyKStar tester = new LazyKStar(file_import);	
		String resultado = tester.PrintResult();
		assertTrue(resultado != "");	
	}
	
	public final void testClassWekaLazyKStar() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		KStar star = (KStar)Class.forName("weka.classifiers.lazy.KStar").newInstance();
		assertNotNull(star);
	}

}
