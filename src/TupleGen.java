
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public class TupleGen{
    public static void main(String[] args) {
        int numElements = 20;
        String[][] array = populateArray(new String[numElements][2]);
        for (int i=0;i<numElements;i++){
            System.out.println(array[i][0] + "\t" + array[i][1]);
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
        return false;
    }
}