public class PointConverter{

	//���W����������W�ɕϊ����āA�Ԃ�
	
	public static Point convertPoint(String coord){
		char ch0 = coord.charAt(0);
		char ch1 = coord.charAt(1);

		int x = (int)(ch1 - '1');
		int y = (int)(ch0 - 'a');

		return new Point(x,y);
	}
}
