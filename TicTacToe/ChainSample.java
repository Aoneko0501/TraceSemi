class NoChain{
	private int a,b,c;

	public void setA(int a){
		this.a = a;
	}

	public void setB(int b){
		this.b = b;
	}

	public void setC(int c){
		this.c = c;
	}

	public void show(){
		System.out.println(a + "," + b + "," + c);
	}
}

class Chain{
	private int a,b,c;


	public Chain setA(int a){
		this.a = a;
		return this;
	}

	public Chain setB(int b){
		this.b = b;
		return this;
	}

	public Chain setC(int c){
		this.c = c;
		return this;
	}

	public Chain show(){
		System.out.println(a + "," + b + "," + c);
		return this;
	}
}

public class ChainSample{
	public static void main(String[] args){
		NoChain nc = new NoChain();
		nc.setA(3);
		nc.setB(1);
		nc.setC(5);
		nc.show();

		Chain ch = new Chain();
		ch.setA(1)
			.show()
			.setB(2)
			.show()
			.setC(3)
			.show();
	}
}

