package DSProjectThree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This Class is responsible for the parsing of the csv files
 * Input will be given in String paths and the files must be 
 * locally available in your Hard drive
 * @author GT
 */
public class CSVParser {
    String path = "";
    ArrayList inputFileContent = new ArrayList();
    ArrayList results = new ArrayList();
    
    public CSVParser(String path){
        this.path = path;
    }
    
    /**
     * Read input data from local Files
     */
    void readInputFile(){
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                inputFileContent.add(data);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Responsible to parse the local file's data into an arraylist 
     * called results
     */
    public ArrayList parse(){
        readInputFile();
        
        for(int line=0; line<inputFileContent.size(); line++){
            String lineContent = (String)inputFileContent.get(line);
            ArrayList<String> entry = new ArrayList<String>();
            
            String[] array = lineContent.split(", ");
            for(int i=0; i<array.length; i++){
                entry.add(array[i]);
            }
            results.add(entry);
        }
        return results;
    }
    
    /**
     * Method to print the content of the csv file in a uniform patern
     */
    public void printParsedData(){
        for(int line=0; line<results.size(); line++){
            ArrayList<String> entry = (ArrayList<String>)results.get(line);
            for(int i=0; i<entry.size(); i++){
                System.out.print("[\""+entry.get(i)+"\"]");
            }
            System.out.println();
        }
    }
    
}

