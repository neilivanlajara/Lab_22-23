import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Punto {
    double x; 
    double y;

    public Punto(double x , double y){
        this.x = x; 
        this.y = y;
    }

    public Punto(){
        this.x= 0 ;
        this.y=0 ; 
    }

    public Punto(double x){
        this.x = x;
    }

    //* `public double getX()` : restituisce l'ascissa del punto.
    public double getX(){
        //effects: restitiuisce il valore di x
        return this.x;
    }

    public double getY(){
        //effects: restitiuisce il valore di y
        return this.y;
    }
    public void setX(double x){
        //modifies: modifica il valore di x uguale al parametro passato
        this.x = x;
    }
    public void setY(double y){
        //modifies: modifica il valore di y uguale al parametro passato
        this.y = y;
    }

    public void setXY(double x, double y){
        //modifies: modifica i valori di x e y 
        this.x = x;
        this.y= y;
    }  

    public String toString(){
        return "{Punto:"+this.x+", "+ this.y+"}";
    }

    public boolean equals(Object o)throws InputMismatchException{
        //effects: true se i due oggetti passati sono uguali
        //raises: InputMismatchEXception se l'oggetto passato non è un oggetto punto 
        if( !(o instanceof Punto)){
            throw new InputMismatchException("non mi hai passato un oggetto punto!");
        }
        Punto q = (Punto)o;
        
        return (q.getX()==this.getX() && q.getY()==this.getY());
        
    }
    public static void sup(){
        System.out.println("Inserire i punti (<x> <y>) \n Terminare la lettura con CTRL+D");
    }

    public double distanza(Punto p){

        //EFFECTS: calcolo distanza euclidiana
        return Math.sqrt((this.y - p.getY()) * (this.y - p.getY()) + (this.x- p.getX()) * (this.x- p.getX()));
        

    }

    public static void distanzaMaggiore(List<Punto> list){
        double max = -99999 ; 
        String res = "";

        for (Punto punto : list) {
            for (Punto punto2 : list) {
                if (!punto.equals(punto2)){
                    if(punto2.distanza(punto) > max){
                        System.out.println("Punto.distanzaMaggiore() \n "+ punto.toString() + "\n"+ punto2.toString());
                        System.out.println("----> "+ punto2.distanza(punto));
                        res = "I punti più distanti sono: \n" + punto.toString() + "\n"+ punto2.toString();
                        max = punto.distanza(punto2);
                    }
                }
            }
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        // Punto p = new Punto(3,4);
        // Punto o  = new Punto(3,5);
        // System.out.println(o.toString());
        // System.out.println(p.toString());
        // System.out.println(p.distanza(o));

        Scanner in = new Scanner(System.in);

        List<Punto> list = new ArrayList<Punto>();
        sup();

        while(in.hasNext()){
            double x = in.nextDouble();
            double y = in.nextDouble();
            
            Punto temp = new Punto(x, y);
            list.add(temp);

        }

        distanzaMaggiore(list);

        
    }

}
