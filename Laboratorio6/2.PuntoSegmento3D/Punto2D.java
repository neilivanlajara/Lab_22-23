
public class Punto2D{
    //OVERVIEW: modella un punto immuatabile (quindi i setter non hanno senso) su un piano cartesiano

    private final double x; 
    private final double y;

    //costruttori

    public Punto2D(double x, double y){
        //modifies: this 
        //effects: inizializza this con coordinate x e y
        
        this.x = x;
        this.y = y;
        
    }

    public Punto2D(){
        //modifies: this
        //effects: 

        this.x = 0 ; 
        this.y = 0;
    }
    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }
     @Override
     public boolean equals(Object q) {
        if((q instanceof Punto2D)){
            Punto2D p = (Punto2D)q;

            if(p.x == this.x && p.y == this.y){
                return true;
            }   
            return false;
        }
        return false;
     }

    @Override
    public String toString(){
        //modifies: 
        //effects: return 
        return "Punto2D - (x: " + this.getX() + " , y " + this.getY();
    }

    //repOk non c'è perchè i nostri metodi accettano tutto
    //anche se sono final e sono immutabili, non facciamo nessun clone, perché sono di tipo primitivo e puntano 
    //direttamente ad una heap
}
