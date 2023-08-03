import java.util.*;
public class Main
{
    public static StringBuffer cipher(String plain, String key){
        StringBuffer res = new StringBuffer();
        StringBuffer newKey = new StringBuffer(key);
        int count = 0;
        for(int i=key.length();i<plain.length();i++){
            newKey.append(key.charAt(count));
            count = (count+1)%key.length();
        }
        for(int i=0;i<plain.length();i++){
            res.append((char)(((int)plain.charAt(i)+(int)newKey.charAt(i)-194)%26+97));
        }
        return res;
    }
    public static StringBuffer original(String cipher, String key){
        StringBuffer res = new StringBuffer();
        StringBuffer newKey = new StringBuffer(key);
        int count = 0;
        for(int i=key.length();i<cipher.length();i++){
            newKey.append(key.charAt(count));
            count = (count+1)%key.length();
        }
        for(int i=0;i<cipher.length();i++){
            int cipher_char = (int)cipher.charAt(i);
            int newKey_char = (int)newKey.charAt(i);
            int diff = cipher_char - newKey_char + 26;
            res.append((char)((diff)%26+97));
        }
        return res;
    }
	public static void main(String[] args) {
		System.out.println("Enter the key:");
		Scanner sc = new Scanner(System.in);
		String key = sc.nextLine();
		System.out.println("Enter the plain text: ");
		String plain = sc.nextLine();
		StringBuffer cipher = cipher(plain,key);
		System.out.println("Cipher text:"+ cipher);
		System.out.println("Original plain text:"+original(new String(cipher),key));
	}
}
