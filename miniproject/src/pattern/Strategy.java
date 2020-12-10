package pattern;

abstract class Duck{
	FlyStrategy flyStrategy;
	
	abstract void display();
	
	void setFlyStrategy(FlyStrategy flyStrategy) {
		this.flyStrategy = flyStrategy;
	}
	
	void fly() {
		flyStrategy.fly();
	}
	
}

class MallarDuck extends Duck{
	@Override
	void display() {
		System.out.println("청둥오리");	
	}
}

class DecoyDuck extends Duck{
	void display() {
		System.out.println("장난감오리");
	}
}

interface FlyStrategy{
	void fly();
}

class Fly implements FlyStrategy{
	@Override
	public void fly() {
		System.out.println("오리날다");
	}
}

class FlyNo implements FlyStrategy{
	@Override
	public void fly() {
		System.out.println("날지못함");
	}
}

public class Strategy {

	public static void main(String[] args) {

		DecoyDuck dDuck = new DecoyDuck();
		dDuck.setFlyStrategy(new Fly());
		dDuck.fly();
		
		MallarDuck mDuck = new MallarDuck();
		mDuck.setFlyStrategy(new FlyNo());
		mDuck.fly();
		
		mDuck.setFlyStrategy(() -> System.out.println("오리날다"));
		mDuck.fly();
		
	}

}
