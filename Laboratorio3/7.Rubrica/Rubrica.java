import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rubrica  {
    
    public static void  doppioni(List<Contatto> c){
        for (int i = 0; i < c.size(); i++) {
            for (int j = i+1; j < c.size(); j++) {
                
                // System.out.println(c.get(i).equals(c.get(j)) + " i: " + i+ " j: "+j);
                // if (i!=j)
                // System.out.println("----------------------------I -----------------");

                // System.out.println(c.get(i).getNome());
                // System.out.println(c.get(i).getCognome());
                // System.out.println(c.get(i).getMail());
                // System.out.println(c.get(i).getTelefono());
                // System.out.println("----------------------------J -----------------");
                // System.out.println(c.get(j).getNome());
                // System.out.println(c.get(j).getCognome());
                // System.out.println(c.get(j).getMail());
                // System.out.println(c.get(j).getTelefono());
                // System.out.println("----------------------------FINE-----------------");

                if ( c.get(i).equals(c.get(j))){
                    System.out.println("duplicato ");
                    System.out.println(c.get(i).toString());

                }
            }
        }

        
    }
    public static void main(String[] args) {
        List<Contatto> list = new ArrayList<Contatto>();

        Scanner in = new Scanner(System.in);
        
        // while(in.hasNext()){
        //     String nome = in.next();
        //     String cognome = in.next();
        //     String mail = in.next();
        //     String telefono = in.next();
        //     Contatto temp = new Contatto(nome, cognome, mail, telefono);
        //     System.out.println("contatto appena inserito");
        //     System.out.println(temp.getNome());
        //     System.out.println(temp.getCognome());
        //     System.out.println(temp.getMail());
        //     System.out.println(temp.getTelefono());
        //     //System.out.println("contatto appena inserito" +temp.toString());
        //     list.add(temp);
        // }
        /*for (Contatto contatto : list) {
            System.out.println(contatto.toString());
        }*/
        while(in.hasNext()){
            
            String nome = in.next();

            String cognome = in.next();

            String mail = in.next();

            String telefono = in.next();
            Contatto temp = new Contatto("Joe",  "Henry",  "jhenry@bix.net",  "5553456");
            Contatto preso = new Contatto(nome, cognome, mail, telefono);
            System.out.println(temp.toString()+" temp"); //Joe Henry jhenry@bix.net 5553456
            System.out.println(preso.toString()+" preso");//Joe Henry jhenry@bix.net 5553456

            System.out.println(temp.equals(preso)); // false 
           // System.out.println(temp.equals(temp));
            list.add(temp);
            // System.out.println("contatto appena inserito");
            // System.out.println(temp.getNome());
            // System.out.println(temp.getCognome());
            // System.out.println(temp.getMail());
            // System.out.println(temp.getTelefono());
            //System.out.println("contatto appena inserito" +temp.toString());
        }
        for (Contatto contatto : list) {
            System.out.println(contatto);
        }
        
        // Contatto a = new Contatto("Joe",  "Henry",  "jhenry@bix.net",  "5553456");
        // Contatto b = new Contatto("Joe",  "Henry",  "jhenry@bix.net",  "5553456");
        // list.add(a);
        // list.add(b);
        doppioni(list);

        // System.out.println(a.equals(b));
    }
}
