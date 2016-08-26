//メインプログラム
//このクラスから読み込まれます
public class TicTacToe{
	public static void main(String[] args){

		ConsoleInputPlayer cip1 = new ConsoleInputPlayer();
		ConsoleInputPlayer cip2 = new ConsoleInputPlayer();
		Board board = new Board();
		GameManager gm = new GameManager(cip1,cip2,board);

		gm.start();
	}
}
