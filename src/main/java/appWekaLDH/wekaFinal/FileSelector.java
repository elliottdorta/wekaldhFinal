package appWekaLDH.wekaFinal;


import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *Seleccionar los ficheros
 * 
 */
public class FileSelector{
    public File chooseFiles(){
        JFileChooser chooser = null;
        File entradas = null;
        try{
            chooser = new JFileChooser();
            chooser.setMultiSelectionEnabled(true);
            chooser.setFileFilter(new FileNameExtensionFilter("ARFF","arff"));
            int retorno = chooser.showOpenDialog(null);
            
            if(retorno == JFileChooser.APPROVE_OPTION){
                entradas = chooser.getSelectedFile();
            }
            return entradas;
        }finally{
            chooser = null;
            entradas = null;
        }
    }
    
    public File chooseDirectory(){
        JFileChooser chooser = null;
        File diretorio = null;
        try{
            chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int retorno = chooser.showOpenDialog(null);
            
            if(retorno == JFileChooser.APPROVE_OPTION){
                diretorio = chooser.getSelectedFile();
            }
            return diretorio;
        }finally{
            chooser = null;
            diretorio = null;
        }
    }
}