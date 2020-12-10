package example;

//class Baduk{
//	
//	AI ai;
//
//	Baduk(AI ai){
//		this.ai = ai;
//		System.out.println("바둑을 시작합니다.");
//	}
//
//	void play() {
//		ai.play();
//	}
//
//}
//
//abstract class AI{
//	AI(){}
//	abstract void play();
//}
//
//class Alpago extends AI{
//	Alpago(){
//	}
//	void play() {
//		System.out.println("인공지능은 알파고입니다.");
//	}
//}
//
//class Betago extends AI{
//	Betago(){
//	}
//	void play() {
//		System.out.println("인공지능은 베타고입니다.");
//	}
//}
//
//class Gamago extends AI{
//	Gamago(){
//	}
//	void play() {
//		System.out.println("인공지능은 감마고입니다.");
//	}
//}

public class example4 {

	public static void main(String[] args) throws Exception {

		// 업캐스팅 / 다형성
//		Baduk b1 = new Baduk(new Alpago());
//		b1.play();
//		Baduk b2 = new Baduk(new Betago());
//		b2.play();
//		Baduk b3 = new Baduk(new Gamago());
//		b3.play();

		// Ex 72
		//예외 처리
		int[] ar = new int[3];
		// ArrayIndexOutOfBoundsException
//		ar[5] = 10;
		// ArithmeticException
//		int a = 100/0;
		// NullPointerException
//		String s = null;
//		s.hashCode();
		//ClassCastException
//		class A{
//			
//		}
//		class B extends A{
//			void f() {
//				
//			}
//		}
//		A a = new A();
//		B b = (B)a; // 타입캐스팅

//		try {
//			int a = 100/0;
//		} catch (Exception e) {
//			System.out.println("익셉션 발생");
//			e.printStackTrace();
//		}
//		System.out.println("호랑이");
//		
//		try {
//			int b = 100/0;
//		} catch (Exception e) {
//		} finally {
//			System.out.println("여기는 파이너리");
//		}
		
//		for (int i = 0; i < 6; i++) {
//			// Unhandled exception type InterruptedException
//			System.out.println(i);
//			try {Thread.sleep(1000);} catch (Exception e) {} //1000밀리세컨드 = 1초
//		}
		
		class Apple{
			Apple() {
			}
			void f1() throws Exception { //throws Exception은 f1함수를 호출한 애가 익셉션을 책임지라는 문법 - 익셉션 떠넘기기
				System.out.println(1);
				throw new Exception();
			}
			void f2() {
				try {
					throw new Exception();
				} catch (Exception e) {
				}
			}
			void f3() throws Exception {
				throw new Exception();
			}
			
			void f4() {
				try {
					f3();
				} catch (Exception e) {
				}
			}
		}
		
		Apple a = new Apple();

		try {
			a.f1();
		} catch (Exception e) {
		}
		
		a.f2();
		a.f1();
		a.f4();

	}

}
