
abstract class Mammifero{
    int eta;
    int peso; //kg

    public double getPeso(){
        return this.peso;
    }

    public int getEta(){
        return this.eta;
    }
    abstract String getVerso();
}