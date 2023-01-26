import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Rubrica  {
    public static void main(String[] args) {
        ArrayList<Contatto> Rubrica = new ArrayList<Contatto>();

        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            Contatto temp = new Contatto(in.next(),in.next(),in.next(),in.next());

            Rubrica.add(temp);
        }

        for (int index = 0; index < Rubrica.size(); index++) {
            Contatto temp = Rubrica.get(index);
            // System.out.println(temp.toString());
            for (int i = 0; i < Rubrica.size(); i++) {
                if(index != i){
                    if(temp.equals(Rubrica.get(i))){
                        System.out.println("ciao");
                    }
                }
            }
        }
    }
}
