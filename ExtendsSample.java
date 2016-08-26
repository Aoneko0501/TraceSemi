// ��ׂ�
interface Flyable {
	void fly();
}

//��
abstract class Bird implements Flyable{
	//���̒��̖��O
	private String name;

	Bird(String name){
		this.name = name;
	}

	@Override
	public void fly(){
		System.out.println(name + "�����");
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
		//���C���v���O����
		Bird bird = new Penguin();
		bird.speak();
		bird.fly();

	}
}
