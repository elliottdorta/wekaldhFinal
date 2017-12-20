package appWekaLDH.wekaFinal;

import java.io.File;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import java.io.BufferedReader;
import java.io.FileReader;
import weka.core.Instance;
import weka.classifiers.functions.LinearRegression;

/**
 * Apply LinearRegression from Weka to the data set
 * @author Héctor Figueras
 *
 */
public class LinearRegressionWeka {
	
	LinearRegression model;
	Instance me = null;
	/**
	 * class constructor 
	 * @param file from datasheet
	 */
	public LinearRegressionWeka(File file_data) {
		
			try{
				ArffLoader loader = new ArffLoader();
		           
		        loader.setFile(file_data);
				
		        Instances data = new Instances(
						new BufferedReader(
								new FileReader(file_data)));
				data.setClassIndex(data.numAttributes() - 1);
				//treinar modelo
				model = new LinearRegression();
				model.buildClassifier(data);
				me = data.lastInstance();
		                 
		} catch(Exception e) {
	        e.printStackTrace();
	    }

	}
	
	String PrintResult() throws Exception {
		
		String resultado = "";
		resultado = model.toString();
		resultado += "\n";
		resultado += me.toString();
		resultado += "\n";
        
        return resultado;
	}

}

