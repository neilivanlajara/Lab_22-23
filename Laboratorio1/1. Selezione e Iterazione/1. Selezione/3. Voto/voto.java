public class voto {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);

        System.out.println(x);

        switch(x){
            case (x < 60):
            System.out.println("non suff");
            break;
            default:
            System.out.println("default");
        }
    }
}
