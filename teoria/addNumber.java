import java.util.ArrayList;
import java.util.Arrays;

public class addNumber {
    public static double add(ArrayList<? extends Number> l){
        double sum = 0 ; 

        for (Number e : l) {
            sum += e.doubleValue();
            //perché l'intero ha double value? perché lo ha anche number 
        }

        return sum; 
    }

    public static void main(String[] args) {
        ArrayList<Integer> src = new ArrayList<>(Arrays.asList(1,2,3,4));

        System.out.println(add(src));
    }
}
