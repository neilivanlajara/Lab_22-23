import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class Pretendenti  implements Iterable<Integer>{
    
    ArrayList<Integer> pretendenti;

    public Pretendenti(int n ) throws IllegalArgumentException{
        //MODIFIES: this
        //EFFFECTS: lancia IllegalArgumentException se pretendenti < 1
        if(n< 1){
            throw new IllegalArgumentException("Ci devono essere dei pretendenti!");
        }
        this.pretendenti = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            this.pretendenti.add(i);
        }
    }

    public int last() throws IllegalArgumentException{
        if(pretendenti.size() != 1){
            throw new IllegalArgumentException("deve esserci solo un pretendente");
        }
        return this.pretendenti.get(0);
    }

    public String toString() {
        String pret = "Pretendenti: ";
        for(int i : this.pretendenti){
            pret += i + " ";
        }
        return pret;

    }

    public Iterator<Integer> iterator() {
        //EFFECTS: return un iterator che genera nuovi pretendenti da cancellare 
        //MODIFIES: null
        return new Iterator<Integer>(){

            int current = 0 ; //indice del pretedente, restituito
            boolean removed = true;  
            boolean direction = true; //true da sx-> dx || false dx->sx

            @Override
            public boolean hasNext(){
                //EFFECTS: restitiusce true quando vi è più di un pretendente, altrimenti false  

                return Pretendenti.this.pretendenti.size()>1;
            }
            @Override
            public Integer next()throws NoSuchElementException{
                //MODIFIES: this 
                //EFFECTS: restitiusce un nuovo pretendente da cancellare, e toglie il flag "rimosso", e inizia true
                // se è rimasto solo uno lancia NoSuchElements
                if(!this.hasNext()){
                    throw new NoSuchElementException("non ci sono più pretendenti") ;
                }

                if(direction){
                    this.current+=2;
                }else{
                    this.current-=2;
                }
                if(this.current >= Pretendenti.this.pretendenti.size()-1){
                    this.direction = false;
                    this.current = 2*(Pretendenti.this.pretendenti.size()-1)-(this.current);

                }

                if(this.current<=0){
                    this.direction = true;
                    this.current = -this.current;
                }

                this.removed = false ;
                return Pretendenti.this.pretendenti.get(current);
            }

            public String toString(){
                String distring = direction ? "avanti" :"indietro";
                return "Si conta da "+ Pretendenti.this.pretendenti.get(current)+ "direzione" + distring;
            }

            public void remove() throws IllegalStateException{
                //MODIFIES: pretendenti.this, this
                //EFFECTS: rimuove il pretendente restitiuto da next(), 
                // se ho già rimosso un elemento e non ho ancora chiamato next(), lancia IllegalStateException  
                if(this.removed){
                    throw new IllegalStateException("non puoi rimuovere");
                }

                Pretendenti.this.pretendenti.remove(this.current);
                removed = true;

                if(!direction){
                    current--;
                }

                if(this.current==0){
                    this.direction = true;
                }

                if(this.current == Pretendenti.this.pretendenti.size()-1){
                    this.direction = false ; 
                }

            }
    };
}


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        Pretendenti p = new Pretendenti(n);
        Iterator<Integer> i = p.iterator();
        while (i.hasNext()) {
            System.out.println(p);
            System.out.println(i);
            System.out.println("Eliminato: "+i.next());
            i.remove();
        }

        System.out.println("il numero "+p.last() + "+ il vincitore");
    }
}
