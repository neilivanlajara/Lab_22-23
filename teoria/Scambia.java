public class Scambia {
    //OV: scambia due valori, metodo statico, e facciamo lo swap tra a e b  

    public static <T> void scambia (T a, T  b ){
        //solo un valore perché dobbiamo fare lo swap
        //void perché non serve restituire <T> 
        T temp = a; 
        a = b; 
        b = temp; 
    }

    public static void main(String[] args) {
        Integer v1 = 5; 
        Integer v2 = 7; 

        scambia(v1, v2);

        System.out.println(v1 +""+  v2 );

    }

}
