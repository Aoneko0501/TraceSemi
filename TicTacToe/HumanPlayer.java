//���ۃN���X
//�I�u�W�F�N�g�����Ȃ�

public abstract class HumanPlayer implements Player {

	//���͂�����
	private Point result;
	//�����̎��
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
