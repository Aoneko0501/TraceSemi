//���W�N���X
public class Point{
	//x���W
	private int x;
	//y���W
	private int y;
	//x��y���w�肵�č��W�����
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}

	//x���W��Ԃ��܂�
	public int getX(){
		return this.x;
	}

	//y���W��Ԃ��܂�
	public int getY(){
		return this.y;
	}

	//(x, y)�̌`���ŃI�u�W�F�N�g��\������
	@Override
	public String toString(){
		return "(" + this.x + "," + this.y + ")";
	}
}

