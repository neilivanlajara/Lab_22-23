import java.net.InetAddress;
import java.util.Scanner;

public class Stanza {
   int[] stanza;
   int[] copia;

   public Stanza(int x ) throws IllegalArgumentException{
    //mod:this 
    //effects: crea una stanza, cioè un array, pari all'indice x 
    if( x < 1){
        throw new IllegalArgumentException("ma cosa fai? non è possibile avere una stanza con capienza negativa");
    }
    this.stanza = new int[x];
    this.copia = stanza;
   }

   //costruttori
   public  int check(){
    return stanza.length;
   }

   public void addStanza(int idx, int val){
    this.stanza[idx] = val;
   }
   
   public void mostra(){
    int count = 1; 
        for (int i : stanza) {
            System.out.println("stanza numero: "+ count+ " capienza"+ i );
            count++;
        }
   }

   public void accedi(int idx, int val)throws IllegalArgumentException{
    if (this.stanza[idx]== 0){
        throw new IllegalArgumentException("capienza massima raggiunta nella stanza"+ (idx +1) );
    }else if (this.stanza[idx] + val > this.copia[idx] ) {
        throw new IllegalArgumentException("non c'è nessuno qui"+ (idx +1) );

    }
    
    if(val < 0){
        this.stanza[idx]--;
    }else{
        this.stanza[idx]++;
    }
   }

   public static void main(String[] args) {
        int x = (args.length);
        Stanza s = new Stanza(x);
        int count = 0 ; 
        
        for (String va : args) {
            System.out.println(va);
            int q = Integer.parseInt(va);
            s.addStanza( count, q);
            count++;
        }
        System.out.println(s.check());

        System.out.println("-------------");
        s.mostra();

        //ok


        Scanner in = new Scanner(System.in);
        


        while(in.hasNext()){
            int idx = in.nextInt() ;
            char op = in.next().charAt(0);

            if(op =='+'){
                s.accedi(idx -1 ,-1);
            }else{
                s.accedi(idx-1 , +1);
            }
        }   
   }
   
}
