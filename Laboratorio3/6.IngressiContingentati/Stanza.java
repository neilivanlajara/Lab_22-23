import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Stanza {

    //OVERVIEW: gestisce la capienza delle stanza, sottraendo oppure aggiungendo una persona alla volta nella staza scelta
    int cap;
    int persone =0 ;
    public Stanza(int cap){
        this.cap = cap;
        this.persone = 0 ; 
    }

    public void addPersone() throws InputMismatchException{
        if(this.persone + 1 > this.cap){
            throw new InputMismatchException("Capienza massima raggiunta nella stanza");
        }
        this.persone++;
    }

    public void subPersone() throws InputMismatchException{
        if(this.persone - 1 < 0){
            throw new InputMismatchException("Non ci sono persone nella stanza");
        }
        this.persone--;
    }

    public void ope(char c)throws InputMismatchException{
        switch(c){
            case '+':
                this.addPersone();
                break;
            case'-':
                this.subPersone();
                break;
            default:
                throw new InputMismatchException("Simbolo sbagliato!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Create "+ args.length+" stanze");
        List<Stanza> list = new ArrayList<Stanza>();
        for (String q : args) {
            //System.out.println(q);
            Stanza temp = new Stanza(Integer.parseInt(q));
            list.add(temp);
        }

        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            int idx = in.nextInt()-1;
            char op = in.next().charAt(0);

            try{
                list.get(idx).ope(op);
            }catch(InputMismatchException e ){
                System.out.println(e.getMessage()+  idx+1 );
            }catch(IndexOutOfBoundsException q){
                System.out.println("la stanza "+ idx+1 + " non esiste");
            }
            // for (Stanza q : list) {
            //     System.out.println("la stanza " +q.cap +" ha dentro ");
                
            //     System.out.println(q.persone);
            // }
        }
        int totpersone = 0 ;
        for (Stanza singolo : list) {
            totpersone+=singolo.persone;
        }

        System.out.println("ci sono in totale "+ totpersone+"  persone");
    }

}
