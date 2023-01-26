public class multiplo {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        
        if(x%y==0){
            System.out.println(x + " è multiplo di "+ y);
        }else{
            System.out.println(x + " non è multiplo di "+ y);

        }

    }
}
