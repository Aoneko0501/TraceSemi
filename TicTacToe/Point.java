//座標クラス
public class Point{
	//x座標
	private int x;
	//y座標
	private int y;
	//xとyを指定して座標を作る
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}

	//x座標を返します
	public int getX(){
		return this.x;
	}

	//y座標を返します
	public int getY(){
		return this.y;
	}

	//(x, y)の形式でオブジェクトを表現する
	@Override
	public String toString(){
		return "(" + this.x + "," + this.y + ")";
	}
}

