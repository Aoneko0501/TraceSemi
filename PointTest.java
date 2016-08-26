public class PointTest{
	public static void main(String[] args)
	{
		if(args.length != 2){
			//エラー出力
			System.out.println("Usage : java PointTest [x] [y]");
			//不正終了
			System.exit(1);
		}

		//parseInt : Sring -> Integerに変換
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		Point p = new Point(x,y);
		// x座標の表示
		System.out.println("x : "+ p.getX());
		// y座標の表示
		System.out.println("y : "+ p.getY());
		// pointの表示
		System.out.println("point : "+ p);
	}
}

