import java.net.SocketTimeoutException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SvolgiCalcolo {


    public  static void Hi(){
        System.out.println("Calcolatrice inizializzata, valore: 3  \n Inserisci <operatore> <operando>. es: + 3 \n Per terminare inserire il carattere '='.");
    }
    public static void main(String[] args) {
        CalcolatriceConMemoria calc = new CalcolatriceConMemoria(0.0) ;

        //quando non viene passato niente nell'args, inzializzo a 0 

        if(args.length > 0)
			calc = new CalcolatriceConMemoria(Integer.parseInt(args[0]));
		
        System.out.println("Calcolatrice inizializzata, valore: " + calc.getMem());
        Hi();

        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            char op = in.next().charAt(0);

            if (op=='='){
                break;
            }
            
            Double num = in.nextDouble();
            try{
                calc.operate(op, num);
            }catch(DivideByZeroException e){
                System.out.println(e.getMessage());
                Hi();
            }
            System.out.println("valore in memoria: " + calc.getMem());

        }

        System.out.println("Il risultato finale e' " + calc.getMem());

        
    }
}
