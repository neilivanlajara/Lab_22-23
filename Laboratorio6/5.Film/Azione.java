public class Azione extends Film{

    //overview: classe film che estende film, tutto uguale tranne la penale di 3€ al giorno 

    public Azione(int id , String titolo, Date dataNoleggio){
        super(id, titolo, dataNoleggio);
    }

    @Override
    public double calcolaPenaleRitardo() {
        
        return ;
    }
    
}
