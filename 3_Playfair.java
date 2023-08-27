import java.util.*;
public class Main
{
	public static void main(String[] args) {
		String temp1 = "abpple";
		String temp2 = "mbeet";
		ArrayList<String> arr1 = split(temp1);
		ArrayList<String> arr2 = split(temp2);
		int len1 = arr1.size();
		int len2 = arr2.size();
		for(int i=0;i<len1;i++){
		    System.out.println(arr1.get(i));
		}
		for(int j=0;j<len2;j++){
		    System.out.println(arr2.get(j));
		}
		char[][] table = construct("monarchy");
		String temp3 = encrypt(arr1,table);
    System.out.println(temp3);
    ArrayList<String> arr3 = split(temp3);
    System.out.println(decrypt(arr3,table));
	}
	
	public static ArrayList<String> split(String plain){
	    ArrayList<String> splitted = new ArrayList<String>();
	    if(plain.length()<=2){
	        splitted.add(plain);
	        return splitted;
	    }
	    int i=0,j=1;
	    int size = plain.length();
	    while(i<size && j<size){
	        if((i<size && j<size) && plain.charAt(i)!=plain.charAt(j)){
	            String temp = plain.charAt(i)+""+plain.charAt(j);
	            splitted.add(temp);
	            i=i+2;
	            j=j+2;
	        }
	        else if((i<size && j<size) && plain.charAt(i)==plain.charAt(j)){
	            String temp = plain.charAt(i)+"x";
	            splitted.add(temp);
	            i=i+1;
	            j=j+1;
	        }
	    }
	    if(i<size && j>=size){
           String temp = plain.charAt(i)+"x";
	       splitted.add(temp);
	    }
	    return splitted;
	}
	
	public static char[][] construct(String key){
	    Queue<Character> queue = new LinkedList<Character>();
	    for(int i=0;i<key.length();i++){
	        char ch = key.charAt(i);
	        if(ch!='j' && queue.contains(ch)==false)
	            queue.add(ch);
	    }
	    String alphabet = "abcdefghiklmnopqrstuvwxyz";
	    for(int i=0;i<alphabet.length();i++){
	        char ch = alphabet.charAt(i);
	        if(!queue.contains(ch))
	            queue.add(ch);
	    }
	    char[][] table = new char[5][5];
	    for(int i=0;i<5;i++){
	        for(int j=0;j<5;j++){
	            table[i][j] = queue.poll();
	        }
	    }
	    return table;
	}
	
	public static String encrypt(ArrayList<String> splitted, char[][] table){
	    String res="";
	    int doubles = splitted.size();
	    for(int i=0;i<doubles;i++){
	        char ch1 = splitted.get(i).charAt(0);
	        char ch2 = splitted.get(i).charAt(1);
	        int[] pos1 = search(table,ch1);
	        int[] pos2 = search(table,ch2);
	        if(pos1[0]==pos2[0]){
	            res+=table[pos1[0]][(pos1[1]+1)%5];
	            res+=table[pos2[0]][(pos2[1]+1)%5];
	            continue;
	        }
	        if(pos1[1]==pos2[1]){
	            res+=table[(pos1[0]+1)%5][pos1[1]];
	            res+=table[(pos2[0]+1)%5][pos2[1]];
	            continue;
	        }
	        else{
	            res+=table[pos1[0]][pos2[1]];
	            res+=table[pos2[0]][pos1[1]];
	            continue;
	        }
	    }
	    return res;
	}
	
	public static int[] search(char[][] table, char ch){
	    if(ch=='j')
	        ch='i';
	    for(int i=0;i<5;i++){
	        for(int j=0;j<5;j++)
	           if(table[i][j]==ch)
	                return new int[]{i,j};
	    }
	    return new int[]{0,0};
	}
	
	public static String decrypt(ArrayList<String> splitted, char[][] table){
	    String res="";
	    int doubles = splitted.size();
	    for(int i=0;i<doubles;i++){
	        char ch1 = splitted.get(i).charAt(0);
	        char ch2 = splitted.get(i).charAt(1);
	        int[] pos1 = search(table,ch1);
	        int[] pos2 = search(table,ch2);
	        if(pos1[0]==pos2[0]){
	            res+=table[pos1[0]][(pos1[1]+4)%5];
	            res+=table[pos2[0]][(pos2[1]+4)%5];
	            continue;
	        }
	        if(pos1[1]==pos2[1]){
	            res+=table[(pos1[0]+4)%5][pos1[1]];
	            res+=table[(pos2[0]+4)%5][pos2[1]];
	            continue;
	        }
	        else{
	            res+=table[pos1[0]][pos2[1]];
	            res+=table[pos2[0]][pos1[1]];
	            continue;
	        }
	    }
	    return res;
	}
}
