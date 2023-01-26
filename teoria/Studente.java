import java.util.ArrayList;

public class Studente {
    int matricola;
    String nome;
    ArrayList<String> corsi;

    public Studente(int matricola, String nomeString){
        this.matricola = matricola;
        this.nome = nome;
        this.corsi= new ArrayList<String>();
    }
    
    public String getNOme(){
        return this.nome;   
    }

    public int getMatricola(){
        return this.matricola;
    }

    // public boolean frequenta(String corso){

    // }

    
}
