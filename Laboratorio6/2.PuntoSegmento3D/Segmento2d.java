import java.util.ArrayList;
import java.util.Scanner;

public class Segmento2d {
    // OVERVIEW: modella un segmento immutabile sul piano cartesiano, costituito da 2 punti 3d

    Punto2D a , b;
    //costruttori
    public Segmento2d(Punto2D a , Punto2D b)throws IllegalArgumentException{
        //Req: a e b non sono nulli e non sono uguali
        //Mod: this
        //effects: se sono uguali lancia IllegalArgumentexception
        
        if(a == null)
            throw new IllegalArgumentException("a non può essere null");
        
        if(b== null)
            throw new IllegalArgumentException("b non può essere null");

        if (a.equals(b)){
            throw new  IllegalArgumentException("non possono essere uguali");
        }
        this.a = a ;//quello che dovremmo dovuto fare se non fosse stato immutabile -> this.a = (Punto2s)a.clone();
        this.b = b;
    }

    public Punto2D getA() {
        return a;
    }

    public Punto2D getB() {
        return b;
    }

    public double length(){
        //eff: ritorna la lunghezza del segmento 
        double dx = this.getA().getX() - this.getB().getX();
        double dy = this.getA().getY() - this.getB().getY();

        return Math.sqrt(dx*dx + dy*dy);

    }

    @Override
    public String toString(){
        return "Segmento 2d - a: "+ this.a + ", b "+ this.b ;
    }


    // public boolean repOk(){
    //     //
    // }
    public static void main(String[] args) {
        //Punto2D p = new Punto2D();

        double minlen = Double.parseDouble(args[0]);
        Scanner in = new Scanner(System.in);

        ArrayList<Segmento2d> l = new ArrayList<Segmento2d>();

        while(in.hasNext()){
            double ax = Double.parseDouble(in.next()); // facciamo la conversione per motivi di incompatibilità della lingua nell'inserimento input, in italiano il separatore è la virgola, mentre in inglese è il punto 
            double ay = Double.parseDouble(in.next());
            double bx = Double.parseDouble(in.next());
            double by = Double.parseDouble(in.next());

            //IllegalArgumentException è un'eccezione unchecked quindi potremmo anche non fare il controllo 

            Punto2D a = new Punto2D(ax, ay);
            Punto2D b = new Punto2D(bx, by);


            try{
                Segmento2d seg = new Segmento2d(a, b);
                l.add(seg);
            }catch (IllegalArgumentException e ){
                System.out.println(e.getMessage());
            }
        
        }
        System.out.println("Segmenti di lunghezza superiore a"+ minlen);

        for (Segmento2d segmento2d : l) {
            if (segmento2d.length() < minlen){
                System.out.println(segmento2d);
            }
        }


    }

}
