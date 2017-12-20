package appWekaLDH.wekaFinal;

import java.io.File;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.LinearRegression;

/**
 * Apply LinearRegression from Weka to the data set
 * @author Héctor Figueras
 *
 */
public class LinearRegressionWeka {
	
	
	private Evaluation eval;
	/**
	 * class constructor 
	 * @param file from datasheet
	 */
	public LinearRegressionWeka(File file_data) {
			
			LinearRegression model;
			//Instance me = null;
		
			try{
				ArffLoader loader = new ArffLoader();
		           
		        loader.setFile(file_data);
				
		        Instances data = new Instances(
						new BufferedReader(
								new FileReader(file_data)));
				data.setClassIndex(data.numAttributes() - 1);
				
				
				model = new LinearRegression();
				model.buildClassifier(data);
				//me = data.lastInstance();
				
				eval = new Evaluation(data);
				eval.crossValidateModel(model, data, 10, new Random(1));
		        
				//System.out.println(eval.toSummaryString());
				
		} catch(Exception e) {
	        e.printStackTrace();
	    }

	}
	
	String PrintResult() throws Exception {
		
		String resultado = "Linear Regression";
		resultado += "\n";
		resultado += eval.toSummaryString();
		resultado += "\n";
        
        return resultado;
	}

}

