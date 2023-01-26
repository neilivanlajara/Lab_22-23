public class test {
    public static void main(String[] args) {
        // char[][] JavaCharArray = new char[3][3];


        // for (char[] cs : JavaCharArray) {
        //     for (char q : cs) {
        //         System.out.println(q == 0);
        //     }
        // }

        boolean turno = true;
        int n = 5;

        while(n>0){
            turno = !(turno); // ci sta 

            System.out.println(turno);
            n++;
        }
    }
}
