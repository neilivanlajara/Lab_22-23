import java.security.DigestException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;
import javax.swing.text.html.FormSubmitEvent;

public class Famiglia {
    //modella la classe famiglia con un certo numero di persone e reddito ed infine verifiche la sua soglia di povertà
    double reddito;
    int dimensione;
    public Famiglia(double reddito, int dimensione) throws InputMismatchException{
        //mod: this
        //raises: IME -> se la dimensione non è positiva
        this.reddito= reddito;
        this.dimensione= dimensione;
    }
    // il metodo `public boolean sottoSogliaPoverta(double costoCasa, double costoCibo) 
    // throws InputMismatchException` che restituisce `true` se la somma tra `costoCasa` e 
    // `costoCibo` (moltiplicato per la `dimensione` della famiglia) è maggiore della metà 
    // del `reddito` della famiglia (costoCibo è il costo medio mensile del cibo per ogni 
    // individuo, mentre costoCasa è unico mensile per la famiglia); Il metodo lancia una 
    // `InputMismatchException` 
    // se costoCasa o costoCibo non sono positivi;
    public boolean sottoSogliaPoverta(double costoCasa, double costoCibo) throws InputMismatchException{
        //mod: 
        //effects true -> se costocasa*12 + costocibo*12*this.dimensione > reddito 
        //altrimenti false 
        return costoCasa*12 + costoCibo*12*this.dimensione > reddito;

    }

    public String toString(){
        return this.dimensione +" persone con reddito complessivo di"+ this.reddito;
    }

    public static void main(String[] args) {
       ArrayList<Famiglia> f = new ArrayList<Famiglia>();
        double costoCasa = Double.parseDouble(args[0])  ;

        double costoCibo = Double.parseDouble(args[1])  ;
        System.out.println("costo casa:"+ costoCasa+ "  costo cibo"+ costoCibo);
        Scanner s = new Scanner(System.in);

        System.out.println("inserisci il redito e la dimensione di una famiglia: ");
        while(s.hasNext()) {
			double tmpRed = s.nextDouble();
			int tmpDim = s.nextInt();

			Famiglia tmpFam = new Famiglia(tmpRed,tmpDim);

			if(tmpFam.sottoSogliaPoverta(costoCasa,costoCibo)) {
				f.add(tmpFam);
			}

			System.out.println("Inserisci il reddito e la dimensione di una famiglia (Ctrl+D per terminare la lettura)");
		}

        System.out.println("ecco tutte le famiglie: ");
        for (Famiglia q : f) {
            System.out.println(q.dimensione);
        }
    }
}
