import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class New{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] agenda =  {"","","", "", "", ""};
        
        while(orariDisponibili(agenda).length > 0) {
			int[] o = orariDisponibili(agenda);

			System.out.println("Puoi prenotare un appuntamento alle " + Arrays.toString(o).substring(1,Arrays.toString(o).length()-1)); //approccio smart ma hacky, meglio fare un metodo pulito che faccia questa stringa.

			System.out.println("Qual è il tuo nome?");
			String nome = in.next();
			System.out.println("A che ora vorresti l'appuntamento?");
			int orario = in.nextInt();

			try{
				prenota(agenda, orario, nome);
			} catch(NullPointerException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			} catch(ArrayStoreException f) {
				System.out.println(f.getMessage());
			} catch(IllegalArgumentException g){ //Questa eccezione può avvenire se l'orario non è valido (in tal caso non porta a termine del programma) o se l'agenda non ha gli slot corretti (in tal caso bisogna terminare)
				System.out.println(g.getMessage());
				
				if(g.getMessage() == "L'agenda non ha 6 slot")
					System.exit(0);
			}

		}

		in.close();

		try{
			stampaAgenda(agenda);
		} catch(NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}

       
    }
    public static void prenota(String[] agenda, int ora, String nome) throws NullPointerException, ArrayStoreException, IllegalArgumentException{
        //mod: this
        //raise: NPE -> se agenda è nulla, ArrayStExce-> se ora è già occupata, IllegaArgu -> se l'ora è sbagliata
        
        //controllo se agenda non è null
        if(agenda.length==0){
            throw new NullPointerException("agenda vuota");
        }
        //controllo se l'array sia valido  
        if(agenda.length!=6){
            throw new IllegalArgumentException("formato agenda errata");
        }

        //controllo se il nome dello studenti sia giusto
        if(nome==""){
            throw new IllegalArgumentException("nome vuoto");

        }

        //controllo se l'ora è valida 
        if(ora <13 || ora > 18){
            throw new IllegalArgumentException("orario sbagliato");
        }

        //controllo se l'appuntamento che voglio prenotare non sia già stato prenotato 
        if(agenda[ora%13]!=""){
            throw new ArrayStoreException("orario già occupato");
        }

        agenda[ora%13]= nome;
    }

    public static void stampaAgenda(String[] agenda) throws NullPointerException, IllegalArgumentException{
        //mod: 
        //effect: stampa l'agenda
        //raises:  NPE -> se agenda è nulla, IAE -> ??
        int count = 13;
        for (String q : agenda) {

            System.out.println("alle"+ count + "è fissato l'appuntamento di "+ q);
            count++;
        }
    }
    public static int[] orariDisponibili(String[] agenda) throws NullPointerException, IllegalArgumentException{
        //mod: -
        //effect: return gli orari disponibili nell agenda 
        //raises: NPE -> agenda null, IAE -> ??

        if (agenda.length==0){
            throw new NullPointerException("agenda vuota");
        }
       int[] orari = new int[10];
       int count = 0; 
       int SlotLiberi= 0 ;
       for (String e : agenda) {
            if (e == ""){
                orari[count]= 13 + count;
                SlotLiberi++;
            }
            count++;
       }

       int[]res = new int[SlotLiberi];
       int w = 0 ;
       for (int i : orari) {
        if (i !=0){
            res[w] = i ;
            w++;
        }
       }
       return res;
        
    }
}