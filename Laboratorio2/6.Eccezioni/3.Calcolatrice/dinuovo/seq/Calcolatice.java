import java.util.InputMismatchException;
import java.util.Scanner;

public class Calcolatice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double tot = 0.0;
        char op = '+';
        System.out.println("per terminare inserire il carattere '='");
        System.out.println("risultato= "+ tot);
        try{
            while (true){
                String s = in.nextLine();
                String[] toSplit = s.split(" ");
                op = toSplit[0].charAt(0);
                if (op=='='){
                    break;
                }
               double o1= Double.parseDouble(toSplit[1]);
    
               tot =calculate( tot, o1, op);
               System.out.println( "risultato "+op +"= "+ tot);
           }


        }catch(InputMismatchException | DivisionByZeroException e){
            System.out.println(e.getMessage());
        }
        System.out.println("il risutato finale è "+ tot);
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
            return o1 / o2;
            default:
            return 1;

        }
    }
}
