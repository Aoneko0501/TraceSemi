public class PointConverter{

	//À•W•¶š—ñ‚ğÀ•W‚É•ÏŠ·‚µ‚ÄA•Ô‚·
	
	public static Point convertPoint(String coord){
		char ch0 = coord.charAt(0);
		char ch1 = coord.charAt(1);

		int x = (int)(ch1 - '1');
		int y = (int)(ch0 - 'a');

		return new Point(x,y);
	}
}
