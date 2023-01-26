
public class Magistrale  extends Studente{
    
    public Magistrale(int matricola, String nomeString, int votoLaureaTriennale) {
        super(matricola, nomeString);
        //TODO Auto-generated constructor stub
        this.votoLaureaTriennale = votoLaureaTriennale;
    }

    int votoLaureaTriennale;

    public int getVotoTriennale(){
        return votoLaureaTriennale;
    }

    
}
