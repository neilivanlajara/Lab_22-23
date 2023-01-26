package teoria.mammifero;

public class Topo extends Mammifero {

    @Override
    String getVerso() {
        return "Squick";
    }
    @Override
    public double getPeso(){
        return this.peso *1000;
    }
    
}
