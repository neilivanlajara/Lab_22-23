public class StringSet {
    //OVERVIEW: set di Stringeri 

    private String[] els;


    StringSet(){

    }

    public void insert(String x ){
        if(els == null){
            //quindi inizializzo il primo elemento
            els = new String[]{x};
        }else if (!(this.contains(x))){
            String[] tmp = new String[els.length+1];
            for (int i = 0; i < els.length; i++) {
                tmp[i]  = els[i];
            }
            tmp[els.length] = x ;
            this.els = tmp;
        }
    }

    // public void remove(String x ){
        
    // }

    public String choose() throws IndexOutOfBoundsException{
        if (els== null){
            throw new IndexOutOfBoundsException("array vuoto");
        }
        return els[0];
    }

    public boolean contains(String x){ 
        for (String  i : this.els) {
                if(i.equals(x)){
                    return true;
                }
        }
        return false;
    }

    public String toString(){
        String ret = "array";
        for (String i : els) {
            ret+= i + " ";
        }
        return ret;
    }


    public static void main(String[] args) {
        StringSet s = new StringSet();
        s.insert(1);
        s.insert(2);

        System.out.prStringln(s);
    }
}
