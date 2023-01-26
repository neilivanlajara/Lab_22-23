
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Famiglia {
    double reddito;
    int dimensione;
    public Famiglia(double reddito, int dimensione) throws InputMismatchException{
        //MODIFIES: inizializza famiglia
        //RAISES: se dimensione della famiglia è negativa solleva un'eccezione

        this.reddito = reddito;

        if(dimensione<0){
            throw new InputMismatchException("dimensione non può essere negativa");
        }
        this.dimensione = dimensione;
    }
    public double getReddito(){
        return this.reddito;
    }
    public double getDimensione(){
        return this.dimensione;
    }
    public boolean sottoSogliaPoverta(double costoCasa, double costoCibo) throws InputMismatchException{
        //MODIFIES: nothing 
        //EFFECTS: true se (costoCasa + costoCibo) * (dimensione) > reddito / 2 
        //RAISES: se costoCasa o costoCibo < 0 solleva InputMismatchException
        
        if (costoCibo < 0 || costoCasa <0 ){
            throw new InputMismatchException("input sbagliati. ");
        }
        return ((costoCasa+ costoCibo)*this.dimensione > (this.reddito/2));
    }

    public String toString(){
        return "Questa famiglia è composta da"+ this.getDimensione() + " e ha un reddito pari a "+ this.getReddito();
    }

    public static void main(String[] args) {
        Integer costoCasa = Integer.parseInt(args[1]);
        Integer costoCibo = Integer.parseInt(args[0]);
        Scanner in = new Scanner(System.in);
        List<Famiglia> famiglieSottoSoglia = new ArrayList<Famiglia>();


        System.out.println("Inserisci il reddito e la dimensione di una famiglia (Ctrl+D per terminare la lettura)");

        while(in.hasNext()){
            double reddito = in.nextDouble();
            Integer dimensione = in.nextInt();

            Famiglia temp = new Famiglia(reddito, dimensione);

            if(temp.sottoSogliaPoverta(costoCasa, costoCibo)){
                famiglieSottoSoglia.add(temp);
            }

            System.out.println("Inserisci il reddito e la dimensione di una famiglia (Ctrl+D per terminare la lettura)");

        }

        System.out.println();
        System.out.println("ci sono "+ famiglieSottoSoglia.size()+ "sotto la soglia di povertà ");
        System.out.println("eccole: ");

        for (Famiglia q : famiglieSottoSoglia) {
            System.out.println(q);
        }
    }
}

