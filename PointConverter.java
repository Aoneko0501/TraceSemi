public class PointConverter{

	//座標文字列を座標に変換して、返す
	
	public static Point convertPoint(String coord){
		char ch0 = coord.charAt(0);
		char ch1 = coord.charAt(1);

		int x = (int)(ch1 - '1');
		int y = (int)(ch0 - 'a');

		return new Point(x,y);
	}
}
