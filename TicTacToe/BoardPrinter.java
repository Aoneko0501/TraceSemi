public class BoardPrinter {

	//コンソールにゲームの状態を表示
	public static void showConsole(Board board){

		//横軸の表示
		System.out.println("  a b c");
		for(int i=0;i<Board.SIZE;i++){
			//縦軸の表示
			System.out.print((i + 1 ) + " ");
			for(int j=0;j < Board.SIZE;j++){
				switch(board.getState(new Point(i,j))){
					case CIRCLE:
						System.out.print("o");
						break;
					case CROSS:
						System.out.print("x");
						break;
					case EMPTY:
						System.out.print(" ");
						break;
					default:
						break;
				}
				if(j < Board.SIZE - 1){
					System.out.print("|");
				}
			}
			System.out.println();
			if(i < Board.SIZE - 1){
				System.out.print("  ");
				for(int j=0;j < Board.SIZE;j++){
					System.out.print("-");
					if(j < Board.SIZE - 1){
						System.out.print("+");
					}
				}
				System.out.println();
			}
		}
		if(board.isGameEnd()){
			if(board.getWinner() != null){
				System.out.println(board.getWinner() + " WIN!");
			}else{
				System.out.println("DRAW");
			}
			return;
		}

		//現在のターンの表示
		System.out.print("Turn = ");
		switch(board.getTurn()){
			case CIRCLE_PLAYER:
				System.out.println("o");
				break;
			case CROSS_PLAYER:
				System.out.println("x");
				break;
			default:
				break;
		}
	}
}
