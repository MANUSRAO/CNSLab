import java.util.*;
public class Main
{
	public static void main(String[] args) {
		int n, size, rate;
		System.out.println("Enter the size of the bucket: ");
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		System.out.println("Enter the number of packets: ");
		n = sc.nextInt();
		System.out.println("Enter the rate supported: ");
		rate = sc.nextInt();
		ArrayList<Integer> burst = new ArrayList();
		System.out.println("Enter the burst of packets:");
		for(int i=0;i<n;i++){
		    burst.add(sc.nextInt());
		}
		int curr = 0;
		for(int i=0;i<n;i++){
		    if(curr + burst.get(i) >size){
		        System.out.println("Buffer overflow, packet thrown:"+burst.get(i));
		    }
		    else{
		        curr += burst.get(i);
		        System.out.println("Packet added to buffer:"+burst.get(i));
		        if(curr>rate){
		            curr-=rate;
		            System.out.println("Packet removed:"+rate);
		        }
		        else{
		            System.out.println("Idle Time");
		        }
		    }
		}
	}
}
