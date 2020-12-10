package example;

//class Apple11{
//	Apple11(){
//		System.out.println("나는부모");
//	}
//}
//
//class Banana extends Apple11{
//	Banana(){
//		System.out.println("나는자식");
//	}
//}
//
//class A{
//	A(int n){
//		System.out.println(n);
//	}
//}
//class B extends A{
//	B(){
//		super(10);
//		System.out.println("자식생성자");
//	}
//}

//class Apple31{
//	Apple31(){
//	}
//	void f1() {
//		System.out.println("부모1");
//	}
//	void f3() {
//		System.out.println("부모3콜");
//	}
//	void f5() {
//		// 자식의 함수 떄문에 부모의 함수가 보이지 않는다 -> 오버라이딩
//		f3();
//	}
//	void f6() {
//		this.f3();
//	}
//}
//
//class Orange31 extends Apple31{
//	Orange31(){
//	}
//	void f2() {
//		System.out.println("자식2");
//	}
//	void f3() {
//		System.out.println("자식3콜");
//	}
//	void f4() {
//		super.f3();
//	}
//}

//class Apple{
//	Apple(){
//	}
//	void f1() {
//		System.out.println("1번콜");
//	}
//	void f3() {
//		System.out.println("3번부모");
//	}
//}
//class Orange extends Apple{
//	Orange(){
//	}
//	void f2() {
//		System.out.println("2번콜");
//	}
//	void f3() {
//		System.out.println("3번자식");
//	}
//}

//class Animal{
//	Animal(){
//		
//	}
//	
//	void cry() {
//		System.out.println("울지못함");
//	}
//}
//class Dog extends Animal{
//	Dog(){
//		
//	}
//	
//	void cry() {
//		System.out.println("멍멍");
//	}
//}
//class Cat extends Animal{
//	Cat(){
//		
//	}
//	
//	void cry() {
//		System.out.println("야옹");
//	}
//}
//
//class Snake extends Animal{
//	Snake(){
//		
//	}
//}

//다형성
class Zoo{
	Zoo(){
	}
	Zoo(int a){
	}
	Zoo(int a, String s){
	}
//	Zoo(Dog dog){
//		System.out.println(1);
//	}
//	Zoo(Cat cat){
//		System.out.println(2);
//	}
//	Zoo(Snake sanke){
//		System.out.println(3);
//	}

	//전형적으로 사용되는 업캐스팅 모습
	Animal animal;
	Zoo(Animal animal){
		this.animal = animal;
	}
	void cry() {
		animal.cry();
	}
}
class Animal{
	void cry() {
		
	}
}
class Dog extends Animal{
	Dog(){
	}
	void cry() {
		System.out.println("멍멍");
	}
}

class Cat extends Animal{
	Cat(){
	}
	void cry() {
		System.out.println("야옹");
	}
}

class Snake extends Animal{
	Snake(){
	}
	void cry() {
		System.out.println("없음");
	}
}

public class example2 {

	public static void main(String[] args) {

//		Apple11 a1 = new Apple11();
		
//		Banana b1 = new Banana();
		//결과는 부모 생성자가 먼저 호출이 되고 자식 생성자가 호출이 되기는 개뿔.. / 자식 -> 부모 -> 자식
		//super 키워드는 생성자의 첫 줄에 반드시 있어야 함
		//super는 코딩하지 않으면 super() 디폴트 생성자가 생성됨
//		B b = new B();
		
//		Orange31 o1 = new Orange31();
//		o1.f2();
//		o1.f3();
//		o1.f4();
//		o1.f5();
//		o1.f6();

		// 상속 관계에서는 대입 연산자의 타입이 다를수 있음 - 부모 = 자식 의 경우
		// 부모 = 부모 (o)
		// 자식 = 자식 (o)
		// 자식 = 부모 (x)
		// 부모 = 자식 (o) - 업캐스팅
		// 문법 = 메모리
//		Apple t1 = new Apple();
//		Orange t2 = new Orange();
////		Orange t3 = new Apple();
//		Apple t4 = new Orange();
//		t4.f1();
////		t4.t2();
//		t4.f3();
//		t2.f1();
//		t2.f3();
//		t2.f2();
		
		//업캐스팅
//		Animal a1 = new Dog();
//		a1.cry();
//		Animal a2 = new Cat();
//		a2.cry();
//		Animal a3 = new Snake();
//		a3.cry();
//		
//		Dog a4 = new Dog();
//		a4.cry();
//		Cat a5 = new Cat();
//		a5.cry();
//		Snake a6 = new Snake();
//		a6.cry();
//		
//		String s1 = "호랑이";
//		String s2 = new String("코끼리");
//		String[] s3 = {"호랑이1", "호랑이2", "호랑이3"};
//		String[] s4 = {new String("코끼리1"), new String("코끼리2"), new String("코끼리3")};
//		System.out.println(s4[0]);
//
//		Animal[] a7 = {new Dog(), new Cat(), new Snake(), new Dog(), new Cat()};
//		a7[0].cry();
//		a7[1].cry();
//		a7[2].cry();
//		
//		System.out.println();
//		//업캐스팅 사용 이유1 - for문 사용하기 위해서
//		for (int i = 0; i < a7.length; i++) {
//			a7[i].cry();
//		}
		
		Dog d1 = new Dog();
		Zoo z1 = new Zoo(d1);
		Zoo z2 = new Zoo(new Dog());
		Zoo z3 = new Zoo(new Cat());
		Zoo z4 = new Zoo(new Snake());
	
		z2.cry();
		z3.cry();
		z4.cry();

		//11월 2일 학습
		String[] str = new String[3];
		str[0] = "호랑이";
		str[1] = new String("코끼리");
		str[2] = "독수리";
		
		class Apple{
			Apple(){
			}
			void f1() {
				System.out.println(1);
			}
		}
		
		Apple a1 = new Apple();
		Apple[] a2 = new Apple[3];
		
//		a2[0].f1();
		
		int a, b, c;
		int[] ar = new int[3];	// 문법적으로 메모리 요구량은 똑같음
		// 변수명의 의미가 없을시 변수명 세개 선언이나 배열 3개나 같음
		//변수 3개만 선언되었음/ 객체 세개가 선언된것이 아니라 사용못함
		a = 10;
		ar[0] = 10;
		b = 20;
		ar[1] = 20;
		c = 30;
		ar[2] = 30;
		
		String s1, s2, s3;
		String[] br = new String[3];
		
		br[0] = new String("호랑이");
		
//		System.out.println(s1);

	}

}
