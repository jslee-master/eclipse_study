package example;

//abstract class Apple{
//	abstract void func1();
//}
////extends(확장)
//class Orange extends Apple{
//	void func1() {
//		System.out.println(1);
//	}
//}

// 일반 함수를 사용하지 않을 시 abstract class는 interface로 변경 가능
//interface Apple{
//	// interface에서는 abstract 생략 가능
//	void func1();
//}

//interface Apple{
//	void func1();
//}
//
////interface 상속 시 implements(구현) 사용
//class Orange implements Apple{
//	//상속된 함수 앞에 반드시 public 작성해야 함
//	@Override
//	public void func1() {
//		System.out.println(1);
//	}
//}

//다중 상속 기본형
//class A{
//}
//
//interface B{
//}
//
//interface C{
//}
//
//class D extends A implements B, C{
//}

//람다 함수
interface Apple{
	void f1();
}

interface Banana{
	void f1(int n);
}

interface Orange{
	void f1(String s, int n);
}

interface kiwi{
	int f1();
}

interface Mango{
	int f1(int a);
}

interface Grape{
	int f1(int a, int b);
}

interface Apple01{
	void f1();
}

class Apple02{
	void f1(Apple01 app) {
		app.f1();
	}
}

interface Apple03{
	void f1();
}

class Apple04{

	Apple03 app;
	
	Apple04(){
		
	}
	
	Apple04(Apple03 app){
		this.app = app;
	}
	
	void f1() {
		app.f1();
	}

}

public class example5 {

	public static void main(String[] args) {

		//함수 사용 방법
//		//객체 선언
//		Orange t1 = new Orange();
//		t1.func1();
//		
//		//업캐스팅
//		Apple t2 = new Orange();
//		t2.func1();
//		
//		//익명 클래스
//		Apple t3 = new Apple() {
//			@Override
//			void func1() {
//				System.out.println(2);
//			}
//		};
//		t3.func1();
//		
//		//익명 객체
//		new Apple() {
//			@Override
//			void func1() {
//				System.out.println(3);
//			}
//		}.func1();
		
//		Orange t1 = new Orange();
//		t1.func1();
//		
//		Apple t2 = new Orange();
//		t2.func1();
//		
//		Apple t3 = new Apple() {
//			@Override
//			public void func1() {
//				System.out.println(2);
//			}
//		};
//		t3.func1();
//		
//		new Apple() {
//			@Override
//			public void func1() {
//				System.out.println(3);
//			}
//		}.func1();
		
		//람다식
		Apple t1 = new Apple() {
			@Override
			public void f1() {
				
			}
		};
		
		//Lambda -> 작성 법 : 1.new Apple 날리고 2.()-> 3.함수껍데기 벗기고 syso
		//주의))abstract X , interface 일때만 사용!! 가능 용어에 따라 => 꼴도 가능하다
		Apple t2 = () -> {
			System.out.println("Lambda");
		};
		t2.f1();
		
		// 함수안의 실행 문장이 한 문장일 때는 {} 생략 가능
		// 다른 언어에서는 => 살찐 애로우 로도 사용됨
		Apple t3 = () -> System.out.println("Lambda");
		t3.f1();

		Banana t4 = new Banana() {
			@Override
			public void f1(int n) {
				System.out.println(n * n);
			}
		};
		t4.f1(10);

		//변수명은 달라도 상관없다 t4에 n을 num으로 사용해봄
		Banana t5 = (int num) -> System.out.println(num*num);
		t5.f1(5);

		// 인수 전달이 한 개일 경우 (괄호) 생략 가능
		Banana t6 = nnn -> System.out.println(nnn*10);
		t6.f1(10);

		//BUT ()를 생략한이유가 인수전달이 하나여서 가능하다는것만 주의 한다 
		Banana t7 = nnn -> System.out.println(nnn * 10);		
		t7.f1(5);

		//인자 값 두 개 받는 예제
		Orange t8 = (String s, int n) -> System.out.println(s+" "+n);
		t8.f1("호랑이", 50);

		//리턴 값이 있는 예제
		kiwi t9 = () -> {
			System.out.println();
			return 100;
		};
		System.out.println(t9.f1());

		// 한 문장 일 때 {} 생략 시 return도 생략
		kiwi t10 = () -> 100;
		System.out.println(t10.f1());

		//인수 한 개 전달 리턴 값이 있는 예제
		Mango t11 = (n) -> 100*n;
		System.out.println(t11.f1(11));

		//인수 두 개 전달 리턴 값이 있는 예제
		Grape t12 = (c, d) -> 100+c+d;
		System.out.println(t12.f1(10, 20));

		//함수에 코드 전달
		Apple02 t13 = new Apple02();
		t13.f1(() ->{
			System.out.println(1);
			System.out.println(2);
			System.out.println(3);
		});
		
		t13.f1(() -> System.out.println(4));

		//실사용 예
		Runnable t14 = new Runnable() {
			@Override
			public void run() {
				
			}
		};

		Runnable t15 = () -> System.out.println(1);
		t15.run();
		
		Apple04 t16 = new Apple04(() -> System.out.println(1));
		t16.f1();

		Apple04 t17 = new Apple04(() -> {
			System.out.println(1);
			System.out.println(2);
			System.out.println(3);
		});
		t17.f1();
		
		//스레드
		Thread t18 = new Thread() {
			public void run() {
				System.out.println("여기는 스레드");
			};
		};
		t18.start();

		Thread t19 = new Thread(()->System.out.println("저기는 스레드"));
		t19.start();

	}

}
