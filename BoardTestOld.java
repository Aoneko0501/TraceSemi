//�Ղ̃e�X�g�N���X
public class BoardTestOld{
	public static void main(String[] args){

		if(args.length != 3){
			System.out.println("Usage : java BoardTest [x] [y] [0or1]");
			System.exit(1);
		}

		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		int s = Integer.parseInt(args[2]);

		if(s != 0 && s != 1){
			System.exit(1);
		}

		Board board = new Board();
		Point p = new Point(x, y);
		State state = State.EMPTY;

		switch(s){
			case 0:
				state = State.CROSS;
				break;
			case 1:
				state = State.CIRCLE;
				break;
			default:
				break;
		}
		board.showConsole();
		//�Ղ�state����������
		board.draw(state, p);
		board.showConsole();
	}
}
