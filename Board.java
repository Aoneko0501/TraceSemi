import java.util.ArrayList;
import java.util.List;

public class Board{
	//盤の一片の大きさを定義する
	public static final int SIZE = 3;

	//各マスの状態を保持する2次元配列
	private State[][] board;
	//現在の手番
	private Turn turn;
	//勝者の手番
	private Turn winner;

	//コンストラクタ
	public Board(){
		// 3x3の盤面の準備
		this.board = new State[SIZE][SIZE];
		//盤面の初期化
		this.init();
	}

	//初期化処理を行う
	public void init(){
		//全てのマスを空にする
		for(int i=0;i<SIZE;i++){
			for(int j=0;j<SIZE;j++){
				this.board[i][j] = State.EMPTY;
			}
		}
		//先手はマルのプレイヤー
		this.turn = Turn.CIRCLE_PLAYER;
		//ゲーム開始時は勝者無し
		this.winner = null;
	}

	public void draw(Point point){
		//指定された座標が盤に存在しない場合は、何もしない
		if(!this.contains(point)){
			return;
		}
		//指定された座標が空でない場合は、何もしない
		if(!this.isEmpty(point)){
			return;
		}

		//ゲームが終了している場合は、何もしない
		if(this.isGameEnd()){
			return;
		}
		//盤の指定された座標の状態を変更する
		this.board[point.getX()][point.getY()] = this.turn.getState();

		//マルまたはバツがそろっているなら、現在のプレイヤーを勝者に設定してゲーム終了
		if(!this.getLine(point).isEmpty()){
			this.winner = this.turn;
			return;
		}
		//ターン交代
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

	//　指定された座標を示すそろった座標をリストにして返す
	public List<Point> getLine(Point point){
		List<Point> line = new ArrayList<>();
		line.addAll(this.checkHorizontal(point));
		line.addAll(this.checkVertical(point));
		line.addAll(this.checkDiagonal(point));
		return line;
	}

	//勝者を返す
	public Turn getWinner(){
		return this.winner;
	}

	//現在のターンを返す
	public Turn getTurn(){
		return this.turn;
	}

	//水平
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

	//垂直
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

		//右斜め
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
		//左斜め
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

	//指定された座標がこの盤に含まれているかどうか
	public boolean contains(Point point){
		if(point.getX() < 0 || SIZE <= point.getX()){
			return false;
		}
		if(point.getY() < 0 || SIZE <= point.getY()){
			return false;
		}
		return true;
	}
	//指定された座標が空かどうか
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
	//ゲームが終了かどうかを返す
	public boolean isGameEnd(){
		return this.getEmptys().isEmpty() || this.winner != null;
	}
}

