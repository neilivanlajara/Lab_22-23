import java.lang.invoke.VarHandle.AccessMode;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class Armageddon {
    double massa;     //in kg
    double distanza; //in km

    public Armageddon(double massa, double distanza)throws IllegalArgumentException{
        //mod: this
        if (massa<0 || distanza <0){
            throw new IllegalArgumentException("input sbagliati");
        }

        this.massa = massa;
        this.distanza = distanza;
    }

    //metodi

    public boolean pericolo(double soglia){
        //mod: 
        //eff: true -> se la seguente formula
        return this.massa / (this.distanza*this.distanza) <= soglia;
    }


    // public double forzaGravitazionale(){
    //     //EFFECTS: ritorna la forza gravitazionale con la formula massa * distanza^2
    //     return this.massa / (this.distanza*this.distanza);
    // }

    public static void main(String[] args) {
        ArrayList <Armageddon> a = new ArrayList<Armageddon>();
        double soglia = Double.parseDouble(args[0]);
        System.out.println("ecco la soglia"+ soglia);
        Scanner in = new Scanner(System.in);
        
        while(in.hasNext()){
            double distanza = in.nextDouble();
            double peso = in.nextDouble();

            Armageddon temp = new Armageddon(peso, distanza);

            if (temp.pericolo(soglia)){
                a.add(temp);
            }
        }
        for (Armageddon q : a) {
            System.out.println(q.distanza + " "+ q.massa);
        }
    }
}
