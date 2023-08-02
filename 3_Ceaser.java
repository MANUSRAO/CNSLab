public class Main
{   
    public static StringBuffer encrypt(String text, int shift){
        StringBuffer result = new StringBuffer();
        if(shift<0){
            shift += 26;
        }
        for(int i=0;i<text.length();i++){
            if(Character.isUpperCase(text.charAt(i))){
                result.append((char)(((int)text.charAt(i)+shift-65)%26+65));
            }
            else{
                result.append((char)(((int)text.charAt(i)+shift-97)%26+97));
            }
        }        
        return result;
    }
	public static void main(String[] args) {
		System.out.println(encrypt("ABCD",-3));
	}
}
