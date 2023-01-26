import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;;
public class Event {
    //OVERVIEW: si genera un calendario nella quale si possono inserire degli eventi, come un agenda
    Date data;
    String nome;

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    //COSTRUTTORE
    public Event(Date data, String nome){
        //MOD: THIS
        this.data= data;
        this.nome = nome;
    }

    //METHODS
    public String getNome(){
        //EFF: restituisce il nome 
        return this.nome;
    }
    public Date getData(){
        //EFF: restituisce la Data
        return this.data;
    }

    public boolean equals(Object o){
        //EFF: compara due Event, prima castando
        if(o == null){
            return false;
        }
        if(!(o instanceof Event)){
            return false;
        }
        Event q = (Event)o;

        return q.data == this.data && q.nome ==this.nome;
    }

    public Event copiaEvento(int n){
        //MOD: - 
        //EFFECTS: return un evento con nome uguale a this, ma con una data +n diverso
        
        Date res ;
        Calendar c = Calendar.getInstance();
        c.setTime(this.data);
        c.add(Calendar.DATE, n);
        res = (Date) c.getTime();


        return new Event(res, this.nome);
    }

    public static void main(String[] args) {
        
    }

}
