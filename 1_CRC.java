import java.util.*;
public class Main
{
	public static String getRemainder(String msg, String poly){
	    int poly_length = poly.length();
	    StringBuffer temp = new StringBuffer(msg);
	    for(int i=0;i<poly_length-1;i++)
	        temp.append('0');
	    int temp_length = temp.length();
	    for(int i=0;i<msg.length();i++){
	        if(temp.charAt(i)=='1'){
	            for(int j=0;j<poly_length;j++){
	                if(temp.charAt(i+j)==poly.charAt(j))
	                    temp.setCharAt(i+j,'0');
	                else
	                    temp.setCharAt(i+j,'1');
	            }
	        }
	    }
	    return temp.substring(temp_length-poly_length);
	}
	
	public static void main(String[] args) {
	    String msg,poly;
		System.out.println("Enter your message:");
		Scanner sc = new Scanner(System.in);
		msg = sc.nextLine();
		System.out.println("Enter your polynomial: ");
		poly = sc.nextLine();
		String data = msg+getRemainder(msg,poly);
		System.out.println("Message transmitted is "+data);
		String recv;
		System.out.println("Enter the recieved message: ");
		recv = sc.nextLine();
		String rem = getRemainder(recv,poly);
		for(int i=0;i<rem.length();i++){
		    if(rem.charAt(i)=='1'){
		        System.out.println("Error in recieved string");
		        return;
		    }
		}
		System.out.println("No Error in recieved string");
	}
}
