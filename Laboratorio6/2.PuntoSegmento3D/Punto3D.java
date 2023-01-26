
public class Punto3D {
    //OVERVIEW: modella un punto 3D immutabile nello spazio
    private Punto2D p;
    //invece di fare il sottotipo, si ridichia

    double z;


    
    public Punto3D(double x, double y , double z)  {
        p = new Punto2D(x, y );
        this.z = z ; 
    }

    public double getx(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getZ(){
        return this.z;
    }

    @Override
    public String toString(){
        return "Punto "
    }

    @Override
    public boolean equals(Object obj){

        if(obj.getClass() == this.getClass()){
            Punto2D  p = (Punto3D)obj;

            
            if(this.getX() == p.getX() && (this.getY() ==p.getY()) && (this.z==p.z)){
                return true;
            }
        }
    }

    public static void main(String[] args) {
        Punto2D p = new Punto3D(1, 3, 5);
        Punto2D p = new Punto2D(1, 3, 5); 
        //secondo il principio di sost di liskov questo dovrebbe essere uguale, ma non va uguale 
        //
    }


}
