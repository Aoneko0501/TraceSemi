import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringSample{
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
		String str = br.readLine();
		System.out.println("str = "+str);
		System.out.println("str.trim="+ str.trim());
		}catch(IOException ie){
			ie.printStackTrace();
		}
	}
}
