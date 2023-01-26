
public class test {
    public static void main(String[] args) {
        
        int count  =0 ; 
        int n = 2 ;

        while(count!= 5){
            if(primo(n)){
                System.out.println(n);
                count++;
            }
            n++;
        }
    }

    public static boolean primo(int n){
        for (int i = 2; i < n; i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
