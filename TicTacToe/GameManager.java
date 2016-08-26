import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ゲームの管理
public class GameManager{
	//プレイヤー
	private Player player1,player2;
	//盤
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

	//ゲームを開始する
	public void start(){
		//初期状態を表示
		BoardPrinter.showConsole(board);

		//手番決め
		player1.setTurn(Turn.CIRCLE_PLAYER);
		player2.setTurn(Turn.CROSS_PLAYER);

		//勝敗が続くまで、続ける
		while(!board.isGameEnd()){
			Player player = this.getPlayer(board.getTurn());
			Point point = player.calc().getResult();
			board.draw(point);
			BoardPrinter.showConsole(board);
		}
	}
}
