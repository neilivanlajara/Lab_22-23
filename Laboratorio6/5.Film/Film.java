import java.sql.Date;
import java.time.LocalDate;

public  class Film {
    //OVERVIEW: modella una classe immutabile film 

    //attributi 

    int id;
    String titolo;
    LocalDate dataNoleggio;

    public Film(int id, String titolo, LocalDate dataNoleggio){
        //mod: this 
        //effects:
        this.id  = id;
        this.titolo= titolo;
        this.dataNoleggio = dataNoleggio;
    }

    // public double calcolaPenaleRitardo() {
    //     //mod:
    //     //effects: calcola la penale del film, 2.5€ per ogni giorno in ritardo 
    //     double diff = 2.5;
    //     if ((LocalDate.now().getDayOfYear() -this.dataNoleggio.getDayOfYear()) > 7){
    //         return diff*(double)(LocalDate.now().getDayOfYear() -this.dataNoleggio.getDayOfYear());
    //     }
        
    //     return 0;
    // }



}
