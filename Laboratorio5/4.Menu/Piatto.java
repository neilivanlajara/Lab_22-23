
public class Piatto {
    //OVERVIEW: modella una classe che descrive un piatto con le sue caratterisiche (nome, tipo prezzo)
    String nome;
    String tipo;
    String costo;

    //costruttore
    public Piatto(String nome, String  tipo, String costo) throws IllegalArgumentException{
       

        this.nome= nome;
        this.tipo = tipo;
        this.costo = costo;
    }

    public String getTipo(){ return this.tipo;}


    
}
