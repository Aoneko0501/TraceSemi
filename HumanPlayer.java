//抽象クラス
//オブジェクトが作れない

public abstract class HumanPlayer implements Player {

	//入力した手
	private Point result;
	//自分の手番
	private Turn turn;


	@Override
	public Player setTurn(Turn turn){
		this.turn = turn;
		return this;
	}

	@Override
	public Turn getTurn(){
		return this.turn;
	}

	@Override
	public Player calc(){
		return this.input();
	}

	@Override
	public Point getResult(){
		return this.result;
	}

	protected Player setResult(Point result){
		this.result = result;
		return this;
	}

	public abstract Player input();
}
