import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// �Q�[���̊Ǘ�
public class GameManager{
	//�v���C���[
	private Player player1,player2;
	//��
	private Board board;

	public GameManager(Player player1,Player player2,Board board){
		this.player1 = player1;
		this.player2 = player2;
		this.board = board;
	}

	public Player getPlayer(Turn turn){
		if(player1.getTurn() == turn){
			return player1;
		}
		if(player2.getTurn() == turn){
			return player2;
		}
		return null;
	}

	//�Q�[�����J�n����
	public void start(){
		//������Ԃ�\��
		BoardPrinter.showConsole(board);

		//��Ԍ���
		player1.setTurn(Turn.CIRCLE_PLAYER);
		player2.setTurn(Turn.CROSS_PLAYER);

		//���s�������܂ŁA������
		while(!board.isGameEnd()){
			Player player = this.getPlayer(board.getTurn());
			Point point = player.calc().getResult();
			board.draw(point);
			BoardPrinter.showConsole(board);
		}
	}
}
