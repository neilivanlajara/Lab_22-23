import java.util.Scanner;

public class Orario {
    //OVERVIEW: costruisce il formato di un orario a 24 oppure 12 
    int h;
    int m;
    boolean pm;
    //COSTRUTTORE
    public Orario(){
        //MOD: this
        //costruttore a zero parametri 
        this.h =0 ;
        this.m= 0 ; 
        this.pm =false;
    }
    public Orario(int h , int m)throws IllegalArgumentException{
        //MODIFIES: this
        // EFFECTS: se h supera 23 oppure è minore di 0, se m supera 59 oppure minore di 0 
        // lancia IllegalArgumentException
        if (h > 23 || h <0 ){
            throw new IllegalArgumentException("L'ora dev'essere compresa tra 0 e 23");
        }
        if(m > 59 || m <0){
            throw new IllegalArgumentException("I minuti devono essere compresa tra 0 e 59");
        }
         this.h = h;
        this.m = m;
    }
    public Orario(int h , int m, String s)throws IllegalArgumentException{
        //MODIFIES: this
        // EFFECTS: se h supera 23 oppure è minore di 0, se m supera 59 oppure minore di 0 
        // lancia IllegalArgumentException
        if (h > 12 || h <0 ){
            throw new IllegalArgumentException("L'ora dev'essere compresa tra 0 e 23");
        }
        if(m > 59 || m <0){
            throw new IllegalArgumentException("I minuti devono essere compresa tra 0 e 59");
        }
         this.h = h;
        this.m = m;
        this.pm = (s == "PM") ? true : false;   
    }

    //METODI
    public void setH(int h ){
        //MOD: this
        //EFF: setta h il valore passato 
        this.h = h;
    }
    public void setM(int m ){
        //MOD: this
        //EFF: setta m il valore passato 
        this.m = m;
    }
    public int getH(){
        //EFF: restituisce l'ora
        return this.h;
    }
    public int getM(){
        //EFF: restituisce i minuti
        return this.m;
    }

    public void avanza(int ore, int minuti){
        //MOD: this
        //EFFECTS: modifica l'ora, aggiungendo del tempo


        //prima gestisco la somma dei minuti

        int tempMin = (this.m+ minuti >59) ? ((this.m + minuti) %60) : this.m+minuti ;
        int oreRiporto =( this.m + minuti) / 60;

        //adesso gestisco i minuti
        int sommaOre = this.h + ore + oreRiporto;
        int tempOre = (sommaOre >23)? ((sommaOre) % 24): sommaOre;

        this.m = tempMin;
        this.h = tempOre;
    }

    public String getOra24(){
        //MOD: 
        //EFFECTS: restitiusce l'orario formato 24h 
        String resOra = (this.h > 9) ? (this.h+"") : "0"+this.h;
        String resMin = (this.m > 9) ? (this.m+"") : "0"+this.m;

        return resOra+":"+resMin;

    }

    public String getOra12(){
        //MOD: 
        //EFF: restitiusce l'orario in formato 12h
        int tempOra = this.h %12;
        String amORpm = (tempOra > 0) ? "PM" : "AM"; // anche questo è da sistemare
        String resOra = (tempOra > 9) ? (tempOra+"") : "0"+tempOra;
        String resMin = (this.m > 9) ? (this.m+"") : "0"+this.m;
        return resOra + ":" + resMin + " "+ amORpm;
    }

    public boolean equals(Object o){
        if( !(o instanceof Orario)){return false;}
        Orario q = (Orario)o;

        return (this.h == q.h && this.m == q.m);
    }

    public static void main(String[] args) {
        System.out.println("Ciao!");

        Scanner in = new Scanner(System.in);

        try{
            Orario o = new Orario(15,40);
            System.out.println(o.getOra12());
            System.out.println(o.getOra24());
            System.out.print("+");
            while(in.hasNext()){
                int h = in.nextInt();
                int m = in.nextInt();
                o.avanza(h, m);
                System.out.println(o.getOra12());
                System.out.println(o.getOra24());
            System.out.print("+");

            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
