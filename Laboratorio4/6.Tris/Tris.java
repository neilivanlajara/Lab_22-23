import java.util.Scanner;

public class Tris {
    //OVERVIEW: gioco di tris (ma va?)
    char[][] tab;
    boolean turno;
    int conteggio;
    //costruttore 
    public Tris(){

        this.tab = new char[3][3];

        this.turno = false;
    }

    //metodi

    public char turno(){
        //MOD: 
        //EFFECTS: return di chi è il turno 
        //turno -> false tocca al giocatore 'O'

        return (this.turno) ? 'O' : 'X';
    }

    public void mossa(int x, int y) throws IllegalArgumentException{
        //MOD: this.tab
        //EFF: 'O' oppure 'X' nella tab[][], se non è null lancio IllegalArgumentException
        
        if(this.tab[x][y] != 0 ){
            throw new IllegalArgumentException("casella già presa!");
        }
        if(x >2 || x <0 || y > 2 || y < 0 ){
            throw new IllegalArgumentException("mossa non valida");
        }

        this.tab[x][y] = this.turno();
        this.turno= !(this.turno);

    }

    public boolean vittoria() {
        //EFFECTS: se il giocatore di turno ha vinto restituisce true, altrimenti false
        
            char curr = this.turno ? 'O' : 'X';
            
            for(int i=0;i<this.tab.length;i++)
                if((this.tab[i][0] == curr && this.tab[i][1] == curr && this.tab[i][2] == curr) || (this.tab[0][i] == curr && this.tab[1][i] == curr && this.tab[2][i] == curr))
                    return true;
            
            if((this.tab[0][0] == curr && this.tab[1][1] == curr && this.tab[2][2] == curr) || (this.tab[0][2] == curr && this.tab[1][1] == curr && this.tab[2][0] == curr))
                return true;
            
            return false;
        }

    public boolean terminato() {
		return this.conteggio == 9;
	}

    @Override
    public String toString(){
        //MOD: 
        //EFF: ritorna una rappresentaziona della tabella
        String res = "";
        for (char[] cs : tab) {
            res+="|";
            for (char c : cs) {
                res+=c+"|";
            }
            res+="\n";
        }
        return res;
    }
    

    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean altraPartita = true;

		while(altraPartita) {
			Tris t = new Tris();
			char turno = 0;
			
			while(true) {
				turno = t.turno();
				System.out.println("Mossa di " + turno);
				System.out.println("Inserisci: x y");
				int riga = s.nextInt();
				int colonna = s.nextInt();
				
				try {
					t.mossa(riga-1,colonna-1);
					System.out.println(t);
				} catch(IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				
				if(t.terminato()) {
					System.out.println("Mosse Finite");
					break;
				}
					
				if(t.vittoria()) {
					System.out.println("Ha vinto " + turno);
					break;
				}
			}

			System.out.println("Un'altra partita? (S/s per si)");
			char ripeti = s.next().charAt(0);
			if (ripeti == 's' || ripeti == 'S')
				altraPartita = true;
			else
				altraPartita = false;
		}
	}

}
