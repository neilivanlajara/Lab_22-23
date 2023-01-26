import java.util.ArrayList;
import java.util.Scanner;

public class LeggiInteri {
    public static void readIntInto(ArrayList<? super Integer> i){
        Scanner in = new Scanner(System.in);

        while(in.hasNextInt())
            i.add(in.nextInt());
    }

    public static void main(String[] args) {
        ArrayList<Integer> li = new ArrayList<>();
        readIntInto(li);

        for (Number i : li) {
            System.out.println(i);
        }
    }
}
