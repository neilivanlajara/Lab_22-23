import java.util.Iterator;

public class Primi implements Iterable <Integer> {
    //OVERVIEWS: modello una classe che trova i numeri primi sotto la soglia data, costruendo un iteratore stand alone 
     int n; 

    public Primi(int n) throws IllegalArgumentException{
        //MOD: this
        //EFF: se n < 0 -> Illegal

        if(n<=0){ throw new IllegalArgumentException("Solo numeri positivi");}

        this.n = n; 
    }

    //metodi

    public void setN(Integer nuovoN){
        //MOD: this
        //EFF: do ad N un nuovo valore: vediamo se funziona visto che ho messo private
        this.n = nuovoN;
    }

    @Override
    public Iterator<Integer> iterator() {
        // TODO Auto-generated method stub
        return new Iterator<Integer> (){
            private int count = 0; 
            private int min = 2; 
            @Override
            public boolean hasNext() {
                
                return Primi.this.n> this.count ;
            }

            @Override
            public Integer next() {
                //mod:
                //eff: trovo il numero primo successivo tra count e Primi.this.n;

                    while(Primi.this.n> this.count){
                        if(primo(this.min)){
                            this.count++;
                            int res = this.min;
                            this.min ++;
                            return res;
                        }
                        this.min++;
                     }
                return -1;
            }

            public  boolean primo(int n){
                for (int i = 2; i < n; i++) {
                    if(n%i==0){
                        return false;
                    }
                }
                return true;
            }
            

        };
    }
    public static void main(String[] args) {
        //int n = Integer.parseInt(args[0]);
        Primi q = new Primi(Integer.parseInt(args[0]));
        Iterator<Integer> w =  q.iterator();

        
        while(w.hasNext()){
            System.out.println(w.next());
        }
    }
    
}
