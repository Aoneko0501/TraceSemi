import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
//�R���\�[���œ��͂��邽�߂̃v���C���[�N���X

public class ConsoleInputPlayer extends HumanPlayer{

	//�����͂���
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

