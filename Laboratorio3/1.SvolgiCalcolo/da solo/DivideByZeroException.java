
public class DivideByZeroException extends Exception{
    DivideByZeroException(){
        super("divisione per zero ");
    }
    DivideByZeroException(String message){
        super(message);
    }
}
