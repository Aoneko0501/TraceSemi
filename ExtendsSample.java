// 飛べる
interface Flyable {
	void fly();
}

//鳥
abstract class Bird implements Flyable{
	//この鳥の名前
	private String name;

	Bird(String name){
		this.name = name;
	}

	@Override
	public void fly(){
		System.out.println(name + "が飛んだ");
	}

	public void speak(){
		System.out.println(name);
	}
}

class Penguin extends Bird{

	public Penguin(){
		super("Penguin");
	}

	@Override
	public void fly(){
		throw new IllegalAccessError("Penguin is can't fly.");
	}
}

class Hawk extends Bird{

	public Hawk(){
		super("Hawk");
	}
}

public class ExtendsSample{
	public static void main(String[] args){
		//メインプログラム
		Bird bird = new Penguin();
		bird.speak();
		bird.fly();

	}
}
