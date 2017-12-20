package appWekaLDH.wekaFinal;

import java.io.File;
import java.util.Random;

import javax.swing.JOptionPane;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.classifiers.rules.ZeroR;
import weka.core.converters.ArffLoader;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.trees.RandomForest;

public class M5PTree {
	
	String resultado = "\n";
	String datosarchivo = "\n";
	String ruta;
	Instances coleccion;
	int tipo;
	int crossValidation;
	
	public int getTipo() {
		return tipo;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public int getCrossValidation() {
        return crossValidation;
    }
    public void setCrossValidation(int crossValidation) {
        this.crossValidation = crossValidation;
    }
    
   
	
	public String ejecutarRandomForest(File file_data) {
        
        resultado = "\n";
        RandomForest rf = new RandomForest();
        try {
        	 ArffLoader loader = new ArffLoader();
	           
	           loader.setFile(file_data);
	           coleccion = loader.getDataSet();
        	
        	
            coleccion = loader.getDataSet();
            coleccion.setClassIndex(coleccion.numAttributes() - 1);

            datosarchivo = datosarchivo + "\nColeccion de entrenamiento:\n";
            datosarchivo = datosarchivo + coleccion.toString();
            
            rf.buildClassifier(coleccion);
           // String matrix = matrixConfusion(rf);
            resultado = resultado + rf.toString();
           // resultado = resultado + matrix;
        } catch (Exception exception) {
            resultado = exception.toString();
            mostrarMsj();
        }
        return resultado;
	}
	
	/* public String ejecutarZeroR() {
        resultado = "\n";
        ZeroR zeror = new ZeroR();
        try {
        	DataSource ar = new DataSource(ruta);
            coleccion = ar.getDataSet();
            coleccion.setClassIndex(coleccion.numAttributes() - 1);

            datosarchivo = datosarchivo + "\nColeccion de entrenamiento:\n";
            datosarchivo = datosarchivo + coleccion.toString();
            
            zeror.buildClassifier(coleccion);
            String matrix = matrixConfusion(zeror);
            resultado = resultado + zeror.toString();
            resultado = resultado + matrix;
        } catch (Exception exception) {
            resultado = exception.toString();
            mostrarMsj();
        }
        return resultado;
	  }*/
	 
	 public void mostrarMsj() {
	        JOptionPane.showMessageDialog(null, "Trate de ejecutar con otro algoritmo", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	 
	/* public String matrixConfusion(Classifier classifier) {
	        String matrix = "\n";
	        //Modelo de Test
	        Evaluation eTest;
	        try {
	            eTest = new Evaluation(coleccion);
	            // es 1 si utiliza cross validation caso contrario utiliza todo
	            // el conjungo de datos para evaluar el modelo
	            if (tipo != 1) {
	                Random rand = new Random(1);
	                //los FOLDS para cross-validation
	                int folds = getCrossValidation();
	                //llamando al metodo cross-validation
	                eTest.crossValidateModel(classifier, coleccion, folds, rand);
	            } else {
	                eTest.evaluateModel(classifier, coleccion);
	            }
	            //Muestra el resumen de la evaluacion
	            String strSummary = eTest.toSummaryString();
	            matrix = matrix + " ===== SUMARY =====\n" + strSummary;
	            // obtener confusion matrix
	            matrix = matrix + eTest.toMatrixString();
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(null, ex.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
	        }
	        return matrix;
	    }*/

}
