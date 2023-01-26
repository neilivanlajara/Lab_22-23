package teoria;
public class TriangoloEquilatero implements Poligono {
    double Lato;

    @Override
    public double getPerimetro(){
        return Lato*3;
    }

    @Override
    public int getFacce() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean regolare() {
        // TODO Auto-generated method stub
        return false;
    }
}
