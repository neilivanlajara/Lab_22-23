import java.util.List;
import java.util.Properties;

public class Contatto {
    //OVERVIEW: questa classe serve per generare un contatto 

    String nome; 
    String cognome; 
    String mail;
    String telefono;

    //il nome, il cognome, il numero di telefono (opzionale) e l'indirizzo mail (opzionale) della persona.
    public Contatto(String nome, String cognome, String mail,String telefono){
        //costruttore con tutto 
        this.nome = nome;
        this.cognome= cognome;
        this.mail = mail;
        this.telefono = telefono;
    }

    
    // * Accedere e modificare le informazioni dell'oggetto; quindi creo i vari set e get (che sbatti)
    
    public void setNome(String nuovoNome){
        this.nome = nuovoNome;
    }
    public void setCognome(String nuovoCognome){
        this.cognome = nuovoCognome;
    }

    public String getNome(){
        return this.nome;
    }


    public String getCognome(){
        return this.cognome;
    }

    public String getTelefono(){
        return this.telefono;
    }
    
    public String getMail(){
        return this.mail;
    }
    public boolean equals(Object a){
        //EFFECTS: paragona ogni attributo e controlli che ognuno sia uguale
        if(a == null){
            return false;
        }
        if( !(a instanceof Contatto)){return false;}
        Contatto c = (Contatto)a;
        return (c.getCognome() ==this.cognome && c.getNome() ==this.cognome && c.getMail() == this.mail && c.getTelefono() ==this.telefono);
    }
    public String toString(){
        return this.nome +  " " + this.cognome+ " "+ this.mail + " "+ this.telefono;
    }

    

   


    
}
