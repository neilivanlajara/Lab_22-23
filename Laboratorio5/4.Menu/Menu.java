import java.lang.annotation.IncompleteAnnotationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Menu  implements Iterable<Piatto>  {
    //OVERVIEW: modella una classe che implementa la classe piatto, contente piatto(nome, tipo, costo) in una lista 
    ArrayList<Piatto> menu;

    public Menu(){
        //mod: this
        //effects: crea una lista vuota
        this.menu = new ArrayList<Piatto>();
    }

    //metodi
    public void addMenu(Object p) throws IllegalArgumentException{
        if(p==null){
            throw new IllegalArgumentException("non valido");

        }
        if(!(p instanceof Piatto)){
            throw new IllegalArgumentException("non valido");
        }
        Piatto q = (Piatto)p;
        this.menu.add(q);
    }
    
    
    @Override
    public Iterator<Piatto> iterator() {
        // TODO Auto-generated method stub
        return new Iterator<Piatto>(){

            @Override
            public boolean hasNext() {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public Piatto next() {
                // TODO Auto-generated method stub
                return null;
            }

        };
    }

    // //in pratica questo iteratore lo uso dopo 
    // public Iterator<Piatto> restituisciMenu(int tipo){
    //     class IteratorPiatti implements Iterator<Piatto>{
    //         int tipo = 0 ; 

    //         IteratorPiatti(){

    //         }
    //         IteratorPiatti(int tipo){
    //             this.tipo = tipo;
    //         }
    //         @Override
    //         public boolean hasNext() {
    //             // TODO Auto-generated method stub
    //             return false;
    //         }
    //         @Override
    //         public Piatto next() {
    //             // TODO Auto-generated method stub
    //             return null;
    //         }
    //     }
    //     return new IteratorPiatti(tipo);
    // }


    public static void main(String[] args) {
        //provare se Menu funziona aggiungendo dei piatti e stampando se
        //effettivamente sono dentro la lista menu 

        List<Piatto> menu = new ArrayList<Piatto>();

        Scanner in = new Scanner(System.in);


        while(in.hasNext()){
            String nome = in.next();
            String tipo = in.next();
            String costo = in.next();
            Piatto temp = new Piatto(nome, tipo, costo);
            menu.add(temp);
        }

        for (Piatto piatto : menu) {
            System.out.println(piatto.nome + " "+ piatto.tipo +" "+ piatto.costo);
        }
        
    }

    
    
}
