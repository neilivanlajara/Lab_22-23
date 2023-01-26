public class Outer {
    private int n;

    public Outer(int n){
        this.n = n ; 
    }

    public static class StaticNestedClass{
        Outer o ;
        
        private StaticNestedClass(Outer o){
            this.o = o ; 
        }

        public String toString(){
            return "n is: " + this.o.n; //
        }
    }

    public static void main(String[] args) {
        Outer o = new Outer(5);

        Outer.StaticNestedClass i = new Outer.StaticNestedClass(o);

        System.out.println(i);
        System.out.println(o);

    }
}
