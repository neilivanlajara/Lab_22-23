import java.util.Comparator;

public abstract class Solido implements Comparator {


    public abstract String tipo();

    public abstract double volume();

    @Override
    public int compare(Object o1, Object o2){
        Solido s1 = (Solido)o1;
        Solido s2 = (Solido)o2;

        if (s2.volume() > s1.volume())
				return 1;
			else if (s2.volume() < s1.volume())
				return -1;
        //questo viene usato nel sort 
		return 0;
    }
    
}
