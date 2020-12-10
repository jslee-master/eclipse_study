package example;

//abstract class Apple{ // 추상 함수를 하나라도 가지고 있으면 클래스도 반드시 추상 클래스임
//	Apple(){}
//	
//	abstract void f1(); // 추상 함수, 추상 클래스 -> 추상은 미완성으로 해석
//
//	void f2() {
//		System.out.println(2);
//	}
//
//}
//
//class Banana extends Apple{
//	Banana() {}
//
//	// 추상 클래스 상속시 무조건 부모 함수를 오버라이딩 해야함
//	@Override // annotation / 컴파일 옵션 - 오타 방지용
//	void f1() {
//		
//	}
//	
//	void f3() {
//		System.out.println(3);
//	}
//
//}

// abstract 사용 방법
abstract class A{
	A(){}
	
	abstract void f1();

}

class B extends A{

	@Override
	void f1() {
		
	}
	

}

public class example3 {

	public static void main(String[] args) {

//		Banana b1 = new Banana();
//		b1.f1();
//		b1.f2();
//		b1.f3();
		// 추상함수를 가지고 있으면 절대 성립이 되지않는 문법
//		Apple a1 = new Apple();
		
		//사용 방법 1
		B t1 = new B();
		t1.f1();
		
		//사용 방법 2 - 업캐스팅
		A t2 = new B();
		t2.f1();
		
		//사용 방법 3 - 익명 클래스를 이용한 객체 생성 방법
		A t3 = new A() {@Override
			void f1() {
			System.out.println(3);
		}
		};

		t3.f1();
		
		//사용 방법 4 - 익명 객체 / 한번 사용하고 없어짐 / 자주 사용함
		new A() {
			@Override
			void f1() {
				System.out.println(3);
			}
		}.f1();

	}

}
