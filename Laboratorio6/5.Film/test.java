import java.time.LocalDate;
import java.util.Date;
public class test {
    public static void main(String[] args) {
        LocalDate q= LocalDate.of(2002, 05, 01);  
        Film f = new Film(02,  "Azione" ,q);

        System.out.println(f.id+ " "+ f.titolo+""+ f.dataNoleggio.getEra());
        
    }
}
