import java.lang.NumberFormatException;

public class NumberFormatExceptionSample{
	public static void main(String[] args){
		String str = "tukeru";
		try{
			int n = Integer.valueOf(str);
		}catch(NumberFormatException nfe){

			System.err.println(str + " is not a number.");
			nfe.printStackTrace();
		}
	}
}
