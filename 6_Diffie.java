import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter prime number p: ");
        BigInteger p = scanner.nextBigInteger();

        System.out.print("Enter base g: ");
        BigInteger g = scanner.nextBigInteger();

        System.out.print("User 1: Enter private key a: ");
        BigInteger a = scanner.nextBigInteger();

        System.out.print("User 2: Enter private key b: ");
        BigInteger b = scanner.nextBigInteger();

        // Calculate public keys
        BigInteger A = g.modPow(a, p);
        BigInteger B = g.modPow(b, p);

        System.out.println("User 1's public key: " + A);
        System.out.println("User 2's public key: " + B);

        // Calculate shared secret keys
        BigInteger sharedKey1 = B.modPow(a, p);
        BigInteger sharedKey2 = A.modPow(b, p);

        System.out.println("Shared secret key for User 1: " + sharedKey1);
        System.out.println("Shared secret key for User 2: " + sharedKey2);

        scanner.close();
    }
}
