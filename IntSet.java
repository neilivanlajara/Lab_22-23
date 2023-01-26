import javax.swing.text.html.FormView;

public class IntSet {
    //OVERVIEW: set di interi 

    private int[] els;


    IntSet(){

    }

    public void insert(int x ){
        if(els == null){
            //quindi inizializzo il primo elemento
            els = new int[]{x};
        }else if (!(this.contains(x))){
            int[] tmp = new int[els.length+1];
            for (int i = 0; i < els.length; i++) {
                tmp[i]  = els[i];
            }
            tmp[els.length] = x ;
            this.els = tmp;
        }
    }

    // public void remove(int x ){
        
    // }

    public int choose() throws IndexOutOfBoundsException{
        if (els== null){
            throw new IndexOutOfBoundsException("array vuoto");
        }
        return els[0];
    }

    public boolean contains(int x){ 
        for (int  i : this.els) {
                if(i == x ){
                    return true;
                }
        }
        return false;
    }

    public String toString(){
        String ret = "array";
        for (int i : els) {
            ret+= i + " ";
        }
        return ret;
    }


    public static void main(String[] args) {
        IntSet s = new IntSet();
        s.insert(1);
        s.insert(2);

        System.out.println(s);
    }
}
