
public class Car {
	String title; // 이름
	
	Tire mytire = new Tire();
	private Door door1 = new Door();
	
//	public Car() { //기본 생성자
//		this.title = "멋진카";
//		System.out.println("Car 기본생성자: " + this.title);
//	}

	public Car() {
//		this("");
	}
	
	public Car(String title) {
		this.title = title;
		System.out.println("선언 생성자: " + this.title);
	}

	public String info() {
		return "타이어 4, 도어 4개";
	}

	// method overloading.
	public String info(String msg) {
		return "타이어 4, 도어 4개: " + msg;
	}

}

class Tire {
	
}

class Door {
	
}
