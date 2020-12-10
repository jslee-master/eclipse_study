package example;

// getter setter
//class Apple2{
//	private
//	String name = "홍길동";
//	int money = 1000;
//	public Apple2() {
//		super();
//	}
//	public Apple2(String name, int money) {
//		super();
//		this.name = name;
//		this.money = money;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getMoney() {
//		return money;
//	}
//	public void setMoney(int money) {
//		this.money = money;
//	}
//}

// 함수 체인링
//class Apple{
//	Apple(){
//	}
//	String func1() {
//		return null;
//	}
//	Integer func2() {
//		return 0;
//	}
//	Apple func3() {
//		return null;
//	}
//	Apple func4() {
//		return this;
//	}
//	void func5() {
//		System.out.println("호출");
//	}
//}

//this 활용 - 너에게 나를 보낸다
//class Apple{
//	Apple(){
//	}
//	void f1() {
//		System.out.println(1);
//		Orange orange = new Orange();
//		orange.f2(this);
//	}
//	void f3() {
//		System.out.println(3);
//	}
//}
//
//class Orange{
//	Orange(){
//		
//	}
//	void f2(Apple aa) {
//		System.out.println(2);
//		aa.f3();
//	}
//	
//}

public class example1 {

	public static void main(String[] args) {
		
//		Apple2 apple = new Apple2(null, 0);
//		
//		apple.setName("이순신");
//		System.out.println(apple.getName());
//		apple.setMoney(100);
//		System.out.println(apple.getMoney());
		
//		Apple apple = new Apple();
//		
//		apple.func5();
//		apple.func4().func5();
//		apple.func4().func4().func5();

//		Apple apple = new Apple();
//		
//		apple.f1();
		
	}

}
