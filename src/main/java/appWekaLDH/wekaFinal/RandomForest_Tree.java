package appWekaLDH.wekaFinal;

import java.io.File;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

/**
 * Apply RandomForest from weka to the data set
 * @author Miguel Aurelio Garcia Gonzalez
 */
public class RandomForest_Tree {

	private Evaluation eval;
	
	/**
	 * class constructor 
	 * @param file from datasheet
	 */
	public RandomForest_Tree(File file_data) {
		
			Instances trainIns = null;
			RandomForest rforest;
			try{
		           ArffLoader loader = new ArffLoader();
		           
		           loader.setFile(file_data);
		           trainIns = loader.getDataSet();
		          
		           
		           trainIns.setClassIndex(trainIns.numAttributes()-1);
		           
		           rforest = (RandomForest)Class.forName("weka.classifiers.trees.RandomForest").newInstance();
		           
		           rforest.buildClassifier(trainIns);
		           
		           eval = new Evaluation(trainIns);
		           
		           eval.crossValidateModel(rforest, trainIns, 10, new Random(1));
		                 
		} catch(Exception e) {
	        e.printStackTrace();
	    }

	}
	
	String PrintResult() throws Exception {
		
		String resultado = "";
        resultado = eval.toClassDetailsString();
        resultado += "\n";
        resultado += eval.toCumulativeMarginDistributionString();
        resultado += "\n";
        resultado += eval.toSummaryString();
        resultado += "\n";
        resultado += eval.toMatrixString();
        resultado += "\n";
        
        return resultado;
	}
	
}
