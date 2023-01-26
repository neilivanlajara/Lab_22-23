import java.security.DigestInputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Asteroide {
    double massa;
    double distanza;
    //OVERVIEW: definisce l'asteroide e la sua distanza dalla terra 
    public Asteroide(double massa, double distanza) throws InputMismatchException{
        //EFFECTS: inizializza gli attributi dell'asteroide
        if (massa <0 || distanza <0 ){
            throw new InputMismatchException("input sbagliato"+ massa + "  "+ distanza);
        }
        this.massa = massa;
        this.distanza = distanza;
    }

    public double getMassa(){return this.massa;}

    public double getDistanza(){return this.distanza;}

    public double forzaGravitazionale(){
        //EFFECTS: ritorna la forza gravitazionale con la formula massa * distanza^2
        return this.massa / (this.distanza*this.distanza);
    }

    public static void main(String[] args) {
        //forza gravitazionale di soglia:
        Double soglia = Double.parseDouble(args[0]);

        List<Asteroide> list = new ArrayList<Asteroide>();

        Scanner in = new Scanner(System.in);

        System.out.println("inidicare gli attributi di asteroide massa - distanza ");
        while(in.hasNext()){
            double tempDistanza = in.nextDouble();
            double tempMassa = in.nextDouble();

           try{
            Asteroide temp = new Asteroide(tempMassa, tempDistanza);
            if ( temp.forzaGravitazionale()< soglia){
                list.add(temp);
            }
           }catch (InputMismatchException e ){
            System.out.println(e.getMessage());
           }
            


            System.out.println("permedere ctrl + d per terminare ");
        }

        System.out.println("ci sono "+ list.size()+ " asteroide pericolosi");
        System.out.println("eccoli: ");

        for (Asteroide p : list) {
            System.out.println("Asteroide pericoloso a distanza"+ p.distanza + " del peso di "+ p.massa);

        }
        if(list.size()>0){
            System.out.println("Lanciate Bruce Willis!");
        }
    }

}
