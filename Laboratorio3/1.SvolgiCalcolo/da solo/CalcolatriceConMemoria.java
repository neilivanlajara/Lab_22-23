import java.util.InputMismatchException;

public class CalcolatriceConMemoria {
    //OVERVIEW: calcolatrice, con memoria che effettua dei calcoli di base 
    
    private double mem; 

    //COSTRUTTORI:

    public CalcolatriceConMemoria(){
        //MODIFIES: this 
        //EFFECTS: inizializza mem a 0 
        this.mem = 0 ; 
    }

    public CalcolatriceConMemoria(double mem){
        //MODIFIES: this 
        //EFFECTS: inizializza mem a mem

        this.mem = mem  ; 
    }
    public double getMem(){
         //MODIFIES: none 
        //EFFECTS: restitiusce il valore corrente di mem 
        return this.mem;
    }

    public double add(double mem){
        //MODIFIES: this
        //EFFECTS: svolge l'operazione di + al mem 
        return this.mem+=mem;
    }

    public double sub(double mem){
        //MODIFIES: this 
        //EFFECTS: sottrazione 
        return this.mem-=mem;
    }

    public double mult(double mem){
        return this.mem*=mem;
    }

    public double div(double mem) throws DivideByZeroException{
        // MODIFIES: this
	    // EFFECTS: svolge l'operazione divisione tra il valore in memoria e `op2`, impostando il valore in memoria al risultato dell'operazione.
	    //
        if(this.mem  == 0 || mem ==0  ){
            throw new DivideByZeroException("Non è possibile dividere per 0");

        }
        
        return this.mem/=mem;
    }

    
    public double operate(char operator, double op2) throws InputMismatchException, DivideByZeroException {
        //MODIFIES: this
        //EFFECTS: operezione aritmetica con this e op2, eccezioni se il simbolo non è riconosciuto oppure divide per zero 

        switch(operator) {
			case '+':
				this.add(op2); //riuso i metodi creati
				return this.mem;
			case '-':
				this.sub(op2);
				return this.mem;
			case '*':
				this.mult(op2);
				return this.mem;
			case '/':
				this.div(op2); //questa operazione lancia una DivideByZeroException. Pertanto la devo o gestire, o rilanciare (modificando intestazione ed EFFECTS)
				return this.mem;
			default:
				throw new InputMismatchException("Operatore non riconosciuto");
		}

    }

}
