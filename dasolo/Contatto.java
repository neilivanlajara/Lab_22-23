import javax.naming.ldap.ExtendedRequest;

public class Contatto {
    //OV: modella una class contatto con tutte le sue peculiarità 
    String nome;
    String cognome;
    String telefono;
    String indirizzo;

    //costruttori
    
    //costruttore con tutti i parametri 
    public Contatto(String nome, String cognome, String telefono, String indirizzo){
        //mod: this
        this.nome =nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.indirizzo= indirizzo;
    }

    //costruttore senza email
    public Contatto(String nome, String cognome, String telefono){
        //mod: this
        this.nome =nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.indirizzo= "";
    }

    //costruttore senza tel e mail
    public Contatto(String nome, String cognome){
        //mod: this
        this.nome =nome;
        this.cognome = cognome;
        this.telefono = "";
        this.indirizzo= "";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

   

    @Override
    public boolean equals(Object o){
        if (o == null){
            return false;
        }
        if (!(o instanceof Contatto)){
            return false;
        }
        Contatto c =  (Contatto)(o);
        return c.cognome== this.cognome && c.nome == this.nome ;
    }

    @Override
    public String toString(){
        
        return this.nome + " " + this.cognome + " " + this.telefono + " " + this.indirizzo;
    }
    public static void main(String[] args) {
        
    }
}
