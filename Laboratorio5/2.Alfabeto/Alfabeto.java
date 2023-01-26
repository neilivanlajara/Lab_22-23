import java.util.Iterator;

public class Alfabeto implements Iterable<Integer>{
    //OVERVIEW: modella una classe che itera le lettere del alfabeto lowercase contando la distanza tra la prima e la seconda messa
    int prima;
    int seconda;
    //costruttori
    public Alfabeto(char x , char y )throws IllegalArgumentException{
        //mod: this
        //effects: controlla se gli input inseriti siano giusti, 1. sono delle lettere minuscole, 2. x sia minore di y
        // altrimenti lancia IllegalArgumentException
        if(!check(x)){
            throw new IllegalArgumentException("Prima lettera non valida");
        }
        if(!check(y)){
            throw new IllegalArgumentException("Seconda lettera non valida");
        }


        if((int)x > (int)y){
            throw new IllegalArgumentException("la prima lettera è successiva alla seconda");
        }

        this.prima = (int)x;
        this.seconda = (int)y;
        // System.out.println(this.prima );
        // System.out.println(this.seconda);
    }

    public boolean check(char c){
        //mod: 
        //effects: controlla solo se è una lettera minuscole 
        return ((int)c > 91 && (int)c < 122);
    }

    public Iterator<Integer> iterator(){
        return new Iterator<Integer>(){
            int count =0 ; 
            @Override
            public boolean hasNext() {
                return Alfabeto.this.prima+ this.count <= Alfabeto.this.seconda;
            }

            @Override
            public Integer next() {
                // TODO Auto-generated method stub
                Integer res = Alfabeto.this.prima + this.count;
                this.count++;

                return res;
            }

        };
    }
    public static void main(String[] args) {
        try{
            char primo = args[0].charAt(0);
            char secondo = args[1].charAt(0);

            Alfabeto q = new Alfabeto(primo, secondo);

            Iterator<Integer> i = q.iterator();

            while(i.hasNext()){
                Integer t = i.next();
                int l = t;
                System.out.println((char)l);

            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
