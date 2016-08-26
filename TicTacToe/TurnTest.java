// Turnのテストクラス
public  class TurnTest{
	public static void main(String[] args)
	{
		Turn circle = Turn.CIRCLE_PLAYER;
		Turn cross = Turn.CROSS_PLAYER;
		System.out.println("circle = "+circle);
		System.out.println("cross = "+cross);
		System.out.println("circle.getState() = "+circle.getState());
		System.out.println("cross.getState() = "+cross.getState());
	}
}