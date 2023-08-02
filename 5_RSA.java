import java.math.*;
import java.util.*;

public class Main {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter prime number p: ");
        BigInteger p = scanner.nextBigInteger();
        System.out.print("Enter prime number q: ");
        BigInteger q = scanner.nextBigInteger();
        System.out.print("Enter public exponent e: ");
        BigInteger e = scanner.nextBigInteger();
        BigInteger n = p.multiply(q);
        BigInteger totient = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger d = e.modInverse(totient);
    	  System.out.println("The value of d = " + d);
    	  System.out.println("Enter the message to be sent: ");               
    	  BigInteger m = scanner.nextBigInteger();
    	  BigInteger cipher_text = m.modPow(e,n);
    	  System.out.println("Encrypted message is : " + cipher_text);
    	  BigInteger msg = cipher_text.modPow(d,n);
    	  System.out.println("Decrypted message is : " + msg);
    }
 
}
