import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Rubrica implements Iterable<Contatto> {
    //overview: modella una class rubrica che visualizza
    //dato un attributo i contatti di rubrica

    private ArrayList<Contatto> rubrica;

    //costruttori
    public Rubrica(){
        //modifies: this
        //effects: inizializza una lista rubrica con 0 elementi 

        this.rubrica = new ArrayList<Contatto>();


    }

    //metodi 

    public void addContatto(Contatto c) throws IllegalArgumentException{
        //mod: this
        //effects: se contatto è vuoto lancia l'errore
        //altrimenti aggiunge alla lista contatto 

        if(c ==null)
            throw new IllegalArgumentException("contatto vuoto"); 

        this.rubrica.add(c);
    }

    public void removeContatto(Contatto c) throws IllegalArgumentException{
        //mod: this
        //effects: se contatto è vuoto lancia l'errore 
        //altrimenti aggiunge alla lista contatto 
        if(c ==null)
            throw new IllegalArgumentException("contatto vuoto"); 

        this.rubrica.remove(c);

    }


    public Iterator<Contatto> iterator() { //Dragan: notare l'uso di null per evitare di scrivere il doppio costruttore di IteraPiatti e per evitare di farla Inner non Local
        return this.iterator();
    }

    public Iterator<Contatto> iterator(String nome){

        class IteraContatti implements Iterator<Contatto>{

            String nome;
            Iterator<Contatto> iters;
            Contatto next; 
            private IteraContatti(String nome){
                this.iters = Rubrica.this.rubrica.iterator();
                this.nome = nome;
            }
            @Override

            public boolean hasNext() { //hasnext cicla i piatti e se trova uno del tipo corretto 
                while(this.iters.hasNext()) {
                    Contatto tmp = this.iters.next();
                    
                    if((tmp.getNome().equals(this.nome)) || (this.nome == null)) {
                        this.next = tmp;
                        return true;
                    }
                }
                this.next = null;
                return false;
            }
            public Contatto next(){
                if(this.next == null)
                    throw new NoSuchElementException("Non ci sono più piatti");
                    
                return this.next;
            }
        }
        return new IteraContatti(nome);
    }

    public Contatto getElement(int i ){
        return this.rubrica.get(i);
    }
    public int dimensione(){
        return this.rubrica.size();
    }
    public static void main(String[] args) {
        Rubrica r = new Rubrica();
        Scanner in  =new Scanner (System.in);


        while(in.hasNext()){
           
            Contatto temp = new Contatto(in.next(),in.next(),in.next(),in.next());

            r.addContatto(temp);
        }

        Iterator<Contatto> primi = r.iterator("Joe");
		while(primi.hasNext())
			System.out.println(primi.next());

        
    }

    public ArrayList<Contatto> getRubrica() {
        return rubrica;
    }

    public void setRubrica(ArrayList<Contatto> rubrica) {
        this.rubrica = rubrica;
    }


}
