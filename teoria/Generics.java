public class Generics<T,U> {
    //OVERVIEW: definisce una tupla con due valori generici anche distinti 
    T val1;
    U val2;


    //Costruttore 

        public Generics(T val1, U val2 ){
            //MODIFIES: this
            //EFFECTS: inizializza this con due valori di tipi generici (anche diversi)
            this.val1= val1;
            this.val2= val2;

        }

        public Generics() {
        }

        //metodi 
        public T getval1(){
            return this.val1;
        }
        

        public U getVal2(){
            return this.val2;
        }   
        
        public String toString(){
            return "val1: "+ this.getval1() + " val2 " + this.getVal2();
        }

        //esempio di uso di generics come metodo 
        
    public static void main(String[] args) {
        
        Generics<Integer, String> T  = new Generics<>(7, "ciao");

        System.out.println(T.toString());
    }
}
