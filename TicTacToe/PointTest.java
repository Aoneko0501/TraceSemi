public class PointTest{
	public static void main(String[] args)
	{
		if(args.length != 2){
			//�G���[�o��
			System.out.println("Usage : java PointTest [x] [y]");
			//�s���I��
			System.exit(1);
		}

		//parseInt : Sring -> Integer�ɕϊ�
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		Point p = new Point(x,y);
		// x���W�̕\��
		System.out.println("x : "+ p.getX());
		// y���W�̕\��
		System.out.println("y : "+ p.getY());
		// point�̕\��
		System.out.println("point : "+ p);
	}
}

