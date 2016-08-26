public class GameManagerTest{
	public static void main(String[] args){
		Board board = new Board();
		GameManager gm = new GameManager(board);

		gm.start();
	}
}

