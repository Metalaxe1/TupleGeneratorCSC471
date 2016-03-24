
import java.io.IOException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
    I have abided by the UNCG Honor Code for this project.
    Anthony Ratliff
    This program will create a .csv file containing randomly generated
    SSN numbers and randomly generated rates of pay from 7.50 to 50.00.
    The number of elements in the file is calculated by the numElements value.
*/

public class TupleGen{
    public static void main(String[] args) {
        int numElements = 2000;
        String[][] array = populateArray(new String[numElements][2]);
        if(createFile(array)){
            System.out.println("The file was created.");
        } else {
            System.out.println("The file was not created.");
        }
    }
    
    public static String[][] populateArray(String[][] temp){
        Random rand = new Random();
        int numberOfItemsAdded = 0;
        while (numberOfItemsAdded < temp.length){
            String ssn = randomSSN();
            boolean contains=false;
            for (int i=0;i<numberOfItemsAdded;i++){
                if (temp[i][0].equals(ssn)) contains = true;
        }
            if (!contains){
                temp[numberOfItemsAdded][0] = ssn;
                DecimalFormat formated = new DecimalFormat("#.00");
                formated.setRoundingMode(RoundingMode.CEILING);
                temp[numberOfItemsAdded++][1] = String.valueOf(formated.format((50.00 - 7.50)*rand.nextFloat() + 7.50));
            }
        }
        return temp;
    }
    
    public static String randomSSN(){
        String temp = "";
        Random rand = new Random();
        for (int i=0;i<9;i++){
            temp+= String.valueOf(rand.nextInt(10));
        }
        return temp;
    }
    
    public static boolean createFile(String[][] temp){
        boolean success = false;
        try {
            try (PrintWriter writer = new PrintWriter("projectPart4.csv")) {
                for (String[] temp1 : temp) {
                    writer.println(temp1[0] + "," + temp1[1]);
                }
            }
            success = true;
        } catch (IOException ex) {
            Logger.getLogger(TupleGen.class.getName()).log(Level.SEVERE, null, ex);
            return success;       
        }
        
        
        return success;
    }
}