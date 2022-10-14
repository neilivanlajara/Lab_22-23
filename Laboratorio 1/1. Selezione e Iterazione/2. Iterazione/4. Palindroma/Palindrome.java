import java.util.Scanner;


public class Palindrome {
    public static void main(String args[]) {
		String parola1, parola2;
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserire una parola: ");
		parola1 = sc.next();

		parola2 = new StringBuffer(parola1).reverse().toString();

		if (parola1.equals(parola2))
			System.out.println(parola1 + " e' palindroma");
		else
			System.out.println(parola1 + " non e' palindroma");
	}
}
