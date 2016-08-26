import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
//コンソールで入力するためのプレイヤークラス

public class ConsoleInputPlayer extends HumanPlayer{

	//手を入力する
	public Player input(){
		try{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String str = br.readLine();

			this.setResult(PointConverter.convertPoint(str));
			//this.result = PointConverter.convertPoint(str);

		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		return this;
	}
}

