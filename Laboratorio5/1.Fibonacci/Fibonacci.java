import java.util.Iterator;

public class Fibonacci implements Iterable<Integer>{
    
    int n;

    public Fibonacci(int n){
        this.n = n ; 
    }

    public ope(int n){
        if(this.n ==0){
            return 0;
        }
        if(this.n ==1 || this.n == 2){
                return 1; 
        }
        return ope(this.n-2) + ope(this.n-1);
    }

    public Iterator<Integer> iterator(){
        
        
        return new Iterator<Integer>(){

            @Override
            public boolean hasNext(){
                //EFFECTS: restitiusce true quando vi è più di un pretendente, altrimenti false  

                return ;
            }
        };
        
    }

}