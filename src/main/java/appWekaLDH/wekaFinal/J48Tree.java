package appWekaLDH.wekaFinal;

import java.io.File;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

/**
 * Apply J48Tree from weka to the data set
 * @author Elliott Dorta
 */
public class J48Tree {

	/**
	 * J48Tree class constructor
	 * @param path
	 */
	
	public String resultado;
	
	public J48Tree(File file_data) {
			
				Instances trainIns = null;
				J48 j;
				
				try	{
			          
			           
						ArffLoader loader = new ArffLoader();
			           
			           loader.setFile(file_data);
			           trainIns = loader.getDataSet();
			          
			           
			           trainIns.setClassIndex(trainIns.numAttributes()-1);
			           
			           j = (J48)Class.forName("weka.classifiers.trees.J48").newInstance();
			           
			           j.buildClassifier(trainIns);
			           
			           Evaluation eval = new Evaluation(trainIns);
			           
			           eval.crossValidateModel(j, trainIns, 10, new Random(1));
			           
			           
			              try {
			            	  resultado = "";
			                  resultado = eval.toClassDetailsString();
			                  resultado += "\n";
			                  resultado += eval.toCumulativeMarginDistributionString();
			                  resultado += "\n";
			                  resultado += eval.toSummaryString();
			                  resultado += "\n";
			                  resultado += eval.toMatrixString();
			                  resultado += "\n";
			                  
			            	  
			              } catch(Exception e) {
			            	  e.getMessage();
			              }
			              
			           
			} catch(Exception e) {
		        e.printStackTrace();
		    }
	}

}
