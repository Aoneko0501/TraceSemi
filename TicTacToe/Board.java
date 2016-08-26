import java.util.ArrayList;
import java.util.List;

public class Board{
	//�Ղ̈�Ђ̑傫�����`����
	public static final int SIZE = 3;

	//�e�}�X�̏�Ԃ�ێ�����2�����z��
	private State[][] board;
	//���݂̎��
	private Turn turn;
	//���҂̎��
	private Turn winner;

	//�R���X�g���N�^
	public Board(){
		// 3x3�̔Ֆʂ̏���
		this.board = new State[SIZE][SIZE];
		//�Ֆʂ̏�����
		this.init();
	}

	//�������������s��
	public void init(){
		//�S�Ẵ}�X����ɂ���
		for(int i=0;i<SIZE;i++){
			for(int j=0;j<SIZE;j++){
				this.board[i][j] = State.EMPTY;
			}
		}
		//���̓}���̃v���C���[
		this.turn = Turn.CIRCLE_PLAYER;
		//�Q�[���J�n���͏��Җ���
		this.winner = null;
	}

	public void draw(Point point){
		//�w�肳�ꂽ���W���Ղɑ��݂��Ȃ��ꍇ�́A�������Ȃ�
		if(!this.contains(point)){
			return;
		}
		//�w�肳�ꂽ���W����łȂ��ꍇ�́A�������Ȃ�
		if(!this.isEmpty(point)){
			return;
		}

		//�Q�[�����I�����Ă���ꍇ�́A�������Ȃ�
		if(this.isGameEnd()){
			return;
		}
		//�Ղ̎w�肳�ꂽ���W�̏�Ԃ�ύX����
		this.board[point.getX()][point.getY()] = this.turn.getState();

		//�}���܂��̓o�c��������Ă���Ȃ�A���݂̃v���C���[�����҂ɐݒ肵�ăQ�[���I��
		if(!this.getLine(point).isEmpty()){
			this.winner = this.turn;
			return;
		}
		//�^�[�����
		this.changeTurn();
	}

	private void changeTurn(){
		if(this.turn == Turn.CIRCLE_PLAYER){
			this.turn = Turn.CROSS_PLAYER;
		}
		else if(this.turn == Turn.CROSS_PLAYER){
			this.turn = Turn.CIRCLE_PLAYER;
		}
	}

	//�@�w�肳�ꂽ���W����������������W�����X�g�ɂ��ĕԂ�
	public List<Point> getLine(Point point){
		List<Point> line = new ArrayList<>();
		line.addAll(this.checkHorizontal(point));
		line.addAll(this.checkVertical(point));
		line.addAll(this.checkDiagonal(point));
		return line;
	}

	//���҂�Ԃ�
	public Turn getWinner(){
		return this.winner;
	}

	//���݂̃^�[����Ԃ�
	public Turn getTurn(){
		return this.turn;
	}

	//����
	private List<Point> checkHorizontal(Point point){
		List<Point> line = new ArrayList<>(SIZE);
		for(int i = 0;i < SIZE; i++){
			Point checkPoint = new Point(point.getX(), i);
			if(this.getState(point) != this.getState(checkPoint)){
				line.clear();
				break;
			}else {
				line.add(checkPoint);
			}
		}
		return line;
	}

	//����
	private List<Point> checkVertical(Point point){
		List<Point> line = new ArrayList<>(SIZE);
		for(int i=0; i < SIZE; i++){
			Point checkPoint = new Point(i, point.getY());
			if(this.getState(point) != this.getState(checkPoint)){
				line.clear();
				break;
			}else{
				line.add(checkPoint);
			}
		}
		return line;
	}

	private List<Point> checkDiagonal(Point point){
		List<Point> line = new ArrayList<>();

		//�E�΂�
		if(point.getX() == point.getY()){
			for(int i=0;i < SIZE; i++){
				Point checkPoint = new Point(i,i);
				if(this.getState(point) != this.getState(checkPoint)){
					line.clear();
					break;
				}else{
					line.add(checkPoint);
				}
			}
		}
		//���΂�
		if(point.getX() == SIZE - 1 - point.getY()){
			for(int i=0;i<SIZE;i++){
				Point checkPoint = new Point(i, SIZE - 1 - i);
				if(this.getState(point) != this.getState(checkPoint)){
					line.clear();
					break;
				}else {
					line.add(checkPoint);
				}
			}
		}
		return line;
	}

	public State getState(Point point){
		return this.board[point.getX()][point.getY()];
	}

	//�w�肳�ꂽ���W�����̔ՂɊ܂܂�Ă��邩�ǂ���
	public boolean contains(Point point){
		if(point.getX() < 0 || SIZE <= point.getX()){
			return false;
		}
		if(point.getY() < 0 || SIZE <= point.getY()){
			return false;
		}
		return true;
	}
	//�w�肳�ꂽ���W���󂩂ǂ���
	public boolean isEmpty(Point point){
		return this.getState(point) == State.EMPTY;
	}

	public List<Point> getEmptys(){
		List<Point> emptys = new ArrayList<>();
		for(int i=0;i<SIZE;i++){
			for(int j=0;j<SIZE;j++){
				Point point = new Point(i,j);
				if(this.isEmpty(point)){
					emptys.add(point);
				}
			}
		}
		return emptys;
	}
	//�Q�[�����I�����ǂ�����Ԃ�
	public boolean isGameEnd(){
		return this.getEmptys().isEmpty() || this.winner != null;
	}
}

