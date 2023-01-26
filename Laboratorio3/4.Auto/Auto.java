import java.beans.VetoableChangeListener;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.print.attribute.IntegerSyntax;

public class Auto {
    int cap; 
    int velMax;
    int consumoMedio;
    double benza;
    public Auto(int cap, int velMax , int consumoMedio ){
        //MODIFIES: inizializzo l'auto
        this.cap = cap; 
        this.velMax = velMax;
        this.consumoMedio = consumoMedio;  
        this.benza = 0.0 ;
    }
    //* riempire il serbatoio con una certa quantità di carburante; 
    public void benzina(int ancoraBenza){
       

        this.benza +=(double)ancoraBenza;
    }

    // cambiare la velocità dell'auto;
    public void setVel(int nuovoVel){
        this.velMax= nuovoVel;
    }

    // pianificare un viaggio con in input: una distanza e una velocità di percorrenza. 
    //Il metodo deve calcolare il tempo di percorrenza ed aggiornare il carburante sottraendo quello consumato.
    // (<L. riforniti> <km da fare> <velocità>)
    public void viaggio(int kmDaFare, int velCurr) throws InputMismatchException{
        //Effects: calcola i consumi del viaggio, e quanto carburante mi rimane 
        //Raises: InputMismatchException se litri inseriti è <0 oppure > di cap, se velCur è minore di zero oppure > di velMax
        //se non mi rimarrà carburante suff per finire il viaggio 
        if(this.cap < this.benza || this.benza <0 ){
            throw new InputMismatchException("litri di benzina non valido"+ this.benza);
        }
        
        if(this.velMax < velCurr || velCurr <=0){throw new InputMismatchException("L'auto non va così veloce. velocità limitata a"+this.velMax+" km/h");}
        
        if(this.benza- (double)kmDaFare/ (double)consumoMedio <0 ){
            throw new InputMismatchException("Non hai carburante sufficiente"+ "\n"+ "ti rimangono "+this.benza+".L di carb");
        }

        double tempo = kmDaFare/ (double)velCurr ;
       // System.out.println("debug format tempo " + tempo);
       DecimalFormat a = new DecimalFormat("#");
       DecimalFormat b = new DecimalFormat(".##");
        System.out.println("Tempo neccessario: ");
        System.out.print(a.format(tempo)+ "ore ");
        System.out.print(b.format(tempo).substring(2)+" minuti \n " );
        
        //
        System.out.println("debug km da fare"+ kmDaFare+ " e cap "+ consumoMedio);
        System.out.println("///////////////////////////////////////");
        
        double consumo = (double)kmDaFare/ (double)this.consumoMedio;
         System.out.println(this.benza +"   "+ consumo);
         System.out.println("///////////////////////////////////////");
         
         //tolgo la benza
         benzina(-(int)(consumo));
         System.out.println("ti rimangono "+ this.benza +" Litri");
        //System.out.println(this.benza);
        }
    //riempire il serbatoio con una certa quantità di carburante; 

    public static void main(String[] args) {

        //es. 40 200 20 -> cap, velMax e consumoMedio

        Integer cap = Integer.parseInt(args[0]) ;
        Integer velMax = Integer.parseInt(args[1]);
        Integer consumoMedio = Integer.parseInt(args[2]);


        //costruisco l'auto

        Auto bmw = new Auto(cap, velMax, consumoMedio);

        //scanner 

        Scanner in  = new Scanner(System.in);

        System.out.println("Inserisci una tratta (<L. riforniti> <km da fare> <velocità>)");
        int totkm=0;
        while(in.hasNext()){
            //es. 30 120 50 --> benza, velocitàCurr, e tempo medio 
            bmw.benzina(in.nextInt());
            int kmDaFare = in.nextInt();
           // System.out.println("km da fare"+ kmDaFare);
            int velCur = in.nextInt();
           // System.out.println("vel cur"+ velCur);

            try{
                bmw.viaggio(kmDaFare, velCur);
                totkm+=kmDaFare;
            }catch(InputMismatchException e){
                System.out.println(e.getMessage());
            }
            System.out.println("Inserisci una tratta (<L. riforniti> <km da fare> <velocità>)");

        }

        System.out.println("hai percorso: "+ totkm+ " totali");
    }

}
