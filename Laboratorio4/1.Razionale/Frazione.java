public class Frazione {
    //OVERVIEW: questa class genera dei numeri razionali, e le rappresenta in numero intero oppure fratto
    int num;
    int den;

    public Frazione(int num, int den)throws ArithmeticException{
        if (den ==0){
            throw new ArithmeticException("Denominatore dev'essere diverso da 0");
        }
        this.num = num;
        this.den = den;
    }

    //i metodi getter e setter per il numeratore ed il denominatore

    public int getNum(){
        return this.num;
    }

    public int getDen(){
        return this.den;
    }

    public void setNum(int newNum){
        this.num = newNum;
    }

    public void setDen(int newDen){
        this.den = newDen;
    }

    public double valore()throws ArithmeticException{
        //MODIFIES: 
        //EFFECTS: restitiusce il rapporto tra num e den, 
        //         se den = 0 lancia ArithmeticException
        if(this.den==0){
            throw new ArithmeticException("Denominatore uguale a 0");
        }
        return (double)this.num/this.den;
    }

    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        int den = Integer.parseInt(args[1]);
        Frazione f;
        
        try {
            
             f = new Frazione(num, den);
             //Il razionale e' 12/3 o 4.0
             System.out.println("Il razionale e'"+ f.getNum()+"/"+ f.getDen()+" o "+f.valore());

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

    }
}
