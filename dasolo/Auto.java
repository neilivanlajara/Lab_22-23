public class Auto {
    //OV: modella una classe auto con le seguenti caratteristiche: serbatoio, velocità massima
    //e consumo medio ( km/litro)

    double serbatoio;
    double carb;
    double vel;
    double consumo;

    //costruttori 
    public Auto(double serbatoio, double vel, double consumo) throws IllegalArgumentException{
        //mod: this
        //raises: IAE -> se ci sono numeri negativi 

        if (serbatoio < 0 || vel < 0 | consumo < 0){
            throw new IllegalArgumentException("non puoi mettere numeri negativi");
        }
        this.serbatoio = serbatoio;
        this.carb = 0 ;
        this.vel = vel;
        this.consumo=consumo;
    }


    //metodi 

    public void cambiaVel(double vel){
        //mod: this.vel
        this.vel = vel;
    }

    public void riempiCarb(double carb) throws IllegalArgumentException{
        //mod: this.carb
        //raises: se c'è troppa benza da errore, oppure se la benza è negativa 
        if (carb+this.carb > this.serbatoio || carb < 0 ){
            throw new IllegalArgumentException("non va bene ");
        }
        this.carb +=carb;
    }

    public void viaggia(double velViaggio, double distanzaViaggio){
        //mod: this:carb
        this.carb -= this.consumo *distanzaViaggio;
        System.out.println("tempo necessario:" + distanzaViaggio/velViaggio);
    }
}   
