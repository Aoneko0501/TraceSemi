//盤のテストクラス
public class BoardTest{
	public static void main(String[] args){

		if(args.length != 3){
			System.err.println("Usage : java BoardTest [x] [y] [state]");
			System.exit(1);
		}

		Board board = new Board();
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		Point p = new Point(x, y);
		State state = State.EMPTY;

		switch(Integer.parseInt(args[2])){
			case 0:
				state = State.CROSS;
				break;
			case 1:
				state = State.CIRCLE;
				break;
			default:
				System.err.println("state : CIRCLE(1), CROSS(0)");
				System.exit(1);
		}
		board.showConsole();
		//盤にstateを書き込む
		board.draw(state, p);
		board.showConsole();
	}
}
