import java.util.InputMismatchException;
import java.util.Scanner;

public class Calcolatice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try{
           
           String[] toSplit = in.nextLine().split(" ");

           double o1= Double.parseDouble(toSplit[0]);
           double o2= Double.parseDouble(toSplit[2]);
           char op = toSplit[1].charAt(0);

           System.out.println( "il risulaato è " + calculate(o1, o2, op));


        }catch(InputMismatchException | DivisionByZeroException e){
            System.out.println(e.getMessage());
        }
    }

    public static double calculate(double o1, double o2, char op) throws InputMismatchException, DivisionByZeroException{
        //mod:
        //effects: restit il numero calcolato 
        //raises: IME se l'operatore non è riconosciuto

        String operatori = "+-*/";
        if (!(operatori.contains(String.valueOf(op)) )){
            throw new InputMismatchException("operatore sbagliato");
        }

        switch(op){
            case '+':
            return o1 + o2;
            case '-':
            return o1- o2;
            case '*':
            return o1 * o2;
            case '/':
            if (o2 ==0 || o1 ==0){
                throw new DivisionByZeroException("non puoi diviid");
            }
            return o1 + o2;
            default:
            return 1;

        }
    }
}
