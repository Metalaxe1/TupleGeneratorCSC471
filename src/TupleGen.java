
import java.util.Random;

public class TupleGen{
    public static void main(String[] args) {
        int numElements = 2000;
        String[][] array = populateArray(new String[numElements][2]);
    }
    
    public static String[][] populateArray(String[][] temp){
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