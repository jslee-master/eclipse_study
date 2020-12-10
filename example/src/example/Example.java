package example;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

// Ex 0 클래스 생성 - 첫글자는 대문자
//class Apple{
//	void apple1(){
//		System.out.println(10);
//	}
//}

//class Apple{
//	Apple(){
//	}
//	void f1() {
//		System.out.println(1);
//	}
//	static void f2() { // static 처음부터 메모리가 존재함
//		System.out.println(2);
//	} // 내부 클래스에서 static 사용하려면 에러남
//}

//class Zoo{
//	Zoo(){
//	}
//	Zoo(int a){
//	}
//	Zoo(int a, String s){
//	}
////	Zoo(Dog dog){
////		System.out.println(1);
////	}
////	Zoo(Cat cat){
////		System.out.println(2);
////	}
////	Zoo(Snake sanke){
////		System.out.println(3);
////	}
//
//	//전형적으로 사용되는 업캐스팅 모습
//	Animal animal;
//	Zoo(Animal animal){
//		this.animal = animal;
//	}
//	void cry() {
//		animal.cry();
//	}
//}
//class Animal{
//	void cry() {
//
//	}
//}
//class Dog extends Animal{
//	Dog(){
//	}
//	void cry() {
//		System.out.println("멍멍");
//	}
//}
//
//class Cat extends Animal{
//	Cat(){
//	}
//	void cry() {
//		System.out.println("야옹");
//	}
//}
//
//class Snake extends Animal{
//	Snake(){
//	}
//	void cry() {
//		System.out.println("없음");
//	}
//}

public class Example {

	public static void main(String[] args) {

//		Apple a = new Apple(); // 객체 선언
//		a.apple1(); // 사용
//
//		(new Apple()).apple1(); // 익명 객체
		
//		------
//		day1();
//		------
//		day2();
//		------
//		day3();
//		------
//		day4();
//		------
//		day5();
//		------
//		day6();
//		------
//		day7();
//		------
//		day8();
//		------
//		day9();
//		------
//		day10();
//		------
//		day11();
//		------
//		day12();
//		------
//		day13();
//		------
//		day14();
//		------
//		day15();
//		------
//		day16();
//		------
		day17();
//		------
		
//		System.out.println(1);

		// Ex 79

		//문제만 적고 직접 해보기		

		//키 입력 받는 구문 2번 사용
		//내가 입력한 숫자의 단이 출력되게 println 사용
				
		//키보드 숫자 하나 입력 받아서 입력받은 숫자까지의 합을 구하는 프로그램

		//ifelse문장은 반드시 삼항연산이 되는지 확인하자
		//3의 4승 구하는 프로그램 작성
		//6*5*4*3*2*1 6!(팩토리) 구하는 프로그램 작성
		//랜덤으로 숫자 뽑는 프로그램

		//피보나치수열 프로그램 1 2 3 5 8 13 21 34 55 89
		//랜덤으로 나온 숫자의 일의 자리와 십의 자리를 더하기
		//3가지 조건 만족시키기 1.중복되는 숫자가 나오면 안 됨 66 2.반드시 5개 출력 3.배열을 사용하지 않음
		
		//integer 최대값
		//int num에 랜덤한 최대값 받은후 각 자리수 합산 프로그램
		//final
		// o x 출력 프로그램으로 o x가 연속해서 가장 많이 나온 횟수 출력
		//this
		
		//내부 클래스
		//생성자
		//필드
		//메소드
		
		//숫자 문자 치환
		//슈가코드
		//문자 숫자 치환
		//정규표현식 - 책 필독
		//16진수
		//부동 소수점 연산
		//Math 클래스의 static 함수 실습
		
		//format
		//String 함수 학습 - 상속
		//마지막 문장이 else if로 끝나도 else로 마무리하는 습관
		//중첩 제어문
		//전형적인 while 형식
		//우박수 문제

		//우박수 문제 삼항 연산
		// 이중 for문 / 다중 for문 / 중첩 for문 - 중요한 알고리즘
		// i j k l m n 변수명 과거의 파스칼 문법 습관
		//이중 for 문에서 밖에 있는 for 문은 항상 세로에 대한 정보 / 안에 있는 for 문은 가로와 관련된 반복 횟수
		// 0~9 랜덤 숫자 4개 보이고 끝에 더해진 값 출력하기 5 7 6 3 = 21
		// 65의 아스키 문자 A
		//타입 캐스팅 - 타입을 강제로 변경
		//랜덤하게 알파뱃(A~Z) 가로 네 칸 세로 세 칸 출력

		// 컬렉션 프레임워크
		//동일한 물품이 담긴 상자를 컨테이너 <>
		//컨테이너 안에는 객체 타입만 사용 가능 / 클래스명
		//li 자료를 관리할 주체

		//Create = add
		//Reading = get
		//동일 결과 출력
		//다른 add 사용 방법
		//Delete = remove
		//Update = set
		//다른 출력 방법 foreach - i 변수를 사용하지 않고 데이터만 가져올 때 사용함
		//링크드리스트 실전 사용 방법
		
		//sin
		//선택 정렬 프로그램 - 오름차순
		//인서트정렬,버블정렬,힙정렬 등의 정렬도 이중 포문 사용
		//순차정렬 결과를 역순정렬로 변경하는 프로그램

		//출력 결과가 사각형의 형태일때는 무조건 이중포문 사용해야함
		//[0 1][1 2][2 3][3 4][4 5]
		//[0 1][1 2][2 3][3 4]
		//[0 1][1 2][2 3]
		//[0 1][1 2]
		//[0 1]

		// 버블 정렬 프로그램

		// Ex 55
		// 08 09 10 11
		// 04 05 06 07
		// 00 01 02 03

		// Ex 56
		// 11 10 09 08
		// 07 06 05 04
		// 03 02 01 00
		// k = 11 변수를 사용해서 k-1하는 프로그램 제외
		
		// Ex 57
		//키보드로 홀수 입력을 받아서 별표로 다이아몬드 모양 출력되는 프로그램
		
		// Ex 58
		// 세개의 변수가 가지고 있는 중간값을 출력하는 프로그램
		// 0 ~ 100 까지 랜덤한 숫자를 a,b,c에 각각 받는다
		// for문으로 검증

		//함수 사용 방법 네 가지
		// 가변인수 ...

		// Ex 61
		// 2시 43분 27초 - 몇 초 인지 출력하기
		// result 결과를 시 분 초로 다시 변환
		
		// Ex 62
		// 랜덤 숫자 5개를 아래와 같이 보이게 출력하는 프로그램
		// 01 >> 04
		// 22 >> 24
		// 36 >> 36
		// 값이 4의 배수면 출력 4의 배수가 아니면 가장 가까운 4의 배수 출력

		// this 사용 방법 두 가지
		// 1. 변수 명이 중복될 때 멤버 필드를 지정함 / 필드명 변수명 구분
		// 멤버 필드 밑에서 우 클릭 - Source 항목 안에 Generate Constructor using Fields 선택 - 필요 변수 선택 - Generate 버튼 선택
		// 멤버 필드 밑에서 우 클릭 - Source 항목 안에 Generate Getters and Setters 선택 - 필요 변수 선택 - Generate 버튼 선택
		// 2. 함수 체인링
		//this 활용 - 너에게 나를 보낸다
		// 동적 정적
		
		//상속
		//자식 -> 부모 -> 자식
		//super 키워드는 생성자의 첫 줄에 반드시 있어야 함
		//super는 코딩하지 않으면 super() 디폴트 생성자가 생성됨
		// 자식의 함수 떄문에 부모의 함수가 보이지 않는다 -> 오버라이딩

		// 상속 관계에서는 대입 연산자의 타입이 다를수 있음 - 부모 = 자식 의 경우 - 업캐스팅 / 문법 = 메모리
		//업캐스팅
		//업캐스팅 사용 이유1 - for문 사용하기 위해서
		// 다형성

		//추상

		// 일차원 배열
		// 이차원 배열
		// 이차원 배열 ar을 90 180 270 회전시켜서 출력하는 문제
		//다형성
		//예외 처리

		//아파트 호실 출력 프로그램 문제
		//401호 402호 403호
		//301호 302호 303호
		//201호 202호 203호
		//101호 102호 103호

		// Ex 74
		//*****
		//*ooo*
		//*ooo*
		//*****
		
		//함수 사용 방법
		//객체 선언
		//업캐스팅
		//익명 클래스
		//익명 객체

		//interface
		//다중 상속 기본형

		// 람다 - 함수를 만드는 축약된 형태로 사용하는 문법
		// 사용 목적 - 함수에 코드를 인수 전달
		// 스레드

	}

	private static void day17() {
		// Ex 79
		System.out.println(1);
		
	}//day17

	private static void day16() {

		// Ex 75
		//example5 파일 확인
		//함수 사용 방법
		//객체 선언
		//업캐스팅
		//익명 클래스
		//익명 객체
		
		// Ex 76
		//example5 파일 확인
		//interface
		//다중 상속 기본형

		// Ex 77
		//example5 파일 확인
		// 람다 - 함수를 만드는 축약된 형태로 사용하는 문법
		// 사용 목적 - 함수에 코드를 인수 전달

		// Ex 78
		//example5 파일 확인
		// 스레드

	}//day16

	private static void day15() {
		// Ex 73
		//아파트 호실 출력 프로그램 문제
		//401호 402호 403호
		//301호 302호 303호
		//201호 202호 203호
		//101호 102호 103호
		//배열 사용 안함
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print((4-i)+"0"+(j+1)+"호 ");
			}System.out.println();
		}System.out.println();

		// Ex 74
		//*****
		//*ooo*
		//*ooo*
		//*****
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
//				if(j==0|j==4|i==0|i==3) {
//					System.out.print("* ");
//				}else {
//					System.out.print("o ");
//				}
				System.out.print((j==0||j==4||i==0||i==3)?"* ":"o ");
			}System.out.println();
		}

	}//day15

	private static void day14() {

		// Ex 68
		// 일차원 배열 사용
//		int[] ar = new int[7]; // 변수 선언시 데이터가 들어갈 공간을 생성하는 것이라 메모리 할당과 같은 개념
//		ar[0] = 10;
//		ar[6] = 20;
////		ar[7] = 30; //Index 7 out of bounds for length 7
////		ar[-1] = 40; //Index -1 out of bounds for length 7
//		ar[3*2-1] = 50; // 인덱스 값으로 산술 연산을 사용 가능
//		
//		for (int i : ar) {
//			System.out.print(i+" ");
//		}System.out.println();
//		
//		int num = 3;
//		ar[num] = 40; // 변수를 넣어서 배열 인덱스 값 사용 가능
//		
//		ar[num*2-1] = 100;
//		
//		for (int i : ar) {
//			System.out.print(i+" ");
//		}System.out.println();
//		
//		ar[0] = 3;
//		ar[6] = ar[ar[0]*2-1];
//
//		for (int i : ar) {
//			System.out.print(i+" ");
//		}System.out.println();
//		System.out.println();

		// Ex 69
		// 이차원 배열
//		int[][] br = new int[3][5]; // 5는 가로 길이, 3은 세로 길이에 해당된다.
//
//		br[0][0] = 10;
//		br[0][4] = 20; // 0번의 끝번
//		br[2][4] = 30; // 끝번
//		
//		// i j 인덱스
//		for (int i = 0; i < br.length; i++) {
//			for (int j = 0; j < br[i].length; j++) {
//				System.out.printf("[%d %d]", i, j);
//			}System.out.println();
//		}System.out.println();
//		
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 5; j++) {
//				System.out.print(br[i][j]+" ");
//			}System.out.println();
//		}System.out.println();
//
//		// 결과 출력
//		for (int i = 0; i < br.length; i++) {
//			for (int j = 0; j < br[i].length; j++) {
//				System.out.printf("%3d", br[i][j]);
//			}System.out.println();
//		}System.out.println();
//
//		System.out.println(br.length); // 세로 반복 횟수
//		System.out.println(br[0].length);
//		System.out.println(br[1].length);
		
		// Ex 70
		// 이차원 배열 ar 회전시켜서 출력하는 문제
//		int[][] ar = new int[3][4];
//		
//		for (int i = 0; i < ar.length; i++) {
//			for (int j = 0; j < ar[i].length; j++) {
//				System.out.printf("%2d", ar[i][j]);
//			}System.out.println();
//		}		
//		
//		for (int i = 0; i < ar.length; i++) {
//			for (int j = 0; j < ar[i].length; j++) {
//				Random rnd = new Random();
//				int r = rnd.nextInt(100);
//				ar[i][j] = r;
//			}
//		}System.out.println();		
//
//		for (int i = 0; i < ar.length; i++) {
//			for (int j = 0; j < ar[i].length; j++) {
//				System.out.printf("%02d ", ar[i][j]);
//			}System.out.println();
//		}System.out.println();
//		
//		int[][] br = new int[4][3]; //ar 90도 회전
//
//		for (int i = 0; i < br.length; i++) {
//			for (int j = 0; j < br[i].length; j++) {
//				br[i][j] = ar[2-j][i];
//				System.out.printf("%02d ", br[i][j]);
//			}System.out.println();
//		}System.out.println();
//		
//		int[][] cr = new int[3][4]; //ar 180도 회전
//
//		for (int i = 0; i < cr.length; i++) {
//			for (int j = 0; j < cr[i].length; j++) {
//				cr[i][j] = ar[2-i][3-j];
//				System.out.printf("%02d ", cr[i][j]);
//			}System.out.println();
//		}System.out.println();
//		
//		int[][] dr = new int[4][3]; //ar 270도 회전
//
//		for (int i = 0; i < dr.length; i++) {
//			for (int j = 0; j < dr[i].length; j++) {
//				dr[i][j] = ar[j][3-i];
//				System.out.printf("%02d ", dr[i][j]);
//			}System.out.println();
//		}System.out.println();
		
		// Ex 71
		//example4 파일 확인
		//다형성

		// Ex 72
		//example4 파일 확인
		//예외 처리
		
	}//day14

	private static void day13() {
		
		// Ex 67 
		//example2 example3 파일 확인
		//추상
		
	}//day13

	private static void day12() {

		// Ex 63
//		class Apple{
//			Apple(){
//				System.out.println("생성자 콜");
//				System.out.println(this);
//			}
//		}
//		
//		Apple a = new Apple();
//		System.out.println(a);
//
//		Apple b = new Apple();
//		System.out.println(b);
//		
//		Apple c = new Apple();
//		System.out.println(c);

		// this 사용 방법 두 가지
		// 1. 변수 명이 중복될 때 멤버 필드를 지정함 / 필드명 변수명 구분
//		class Apple{
//			int a, b;
//			
//			Apple(int a, int b){
//				this.a = a;
//				this.b = b;
//			}
//		}
//		
//		Apple a = new Apple(30, 40);
//		System.out.println(a.a + " " + a.b);
		
//		class Apple{
//			int money;
//			String name;
//			// 멤버 필드 밑에서 우 클릭 - Source 항목 안에 Generate Constructor using Fields 선택 - 필요 변수 선택 - Generate 버튼 선택
//			Apple(int money, String name) {
//				this.money = money;
//				this.name = name;
//			}
//		}
		
		// getter setter
		//class Apple2{
//			private
//			String name = "홍길동";
//			int money = 1000;
//			public Apple2() {
//				super();
//			}
//			public Apple2(String name, int money) {
//				super();
//				this.name = name;
//				this.money = money;
//			}
//			public String getName() {
//				return name;
//			}
//			public void setName(String name) {
//				this.name = name;
//			}
//			public int getMoney() {
//				return money;
//			}
//			public void setMoney(int money) {
//				this.money = money;
//			}
		//}
		
//		Apple2 apple = new Apple2(null, 0);
//		
//		apple.setName("이순신");
//		System.out.println(apple.getName());
//		apple.setMoney(100);
//		System.out.println(apple.getMoney());

		// 2. example1 파일 확인 / 함수 체인링
//		class Apple{
//			private
//			String name = "홍길동";
//			int money = 1000;
//		}
//		
//		Apple apple = new Apple();
//		
//		System.out.println(apple.name);
//		System.out.println(apple.money);
		
//		class Apple{
//			Apple(){
//			}
//			String func1() {
//				return null;
//			}
//			Integer func2() {
//				return 0;
//			}
//			Apple func3() {
//				return null;
//			}
//			Apple func4() {
//				return this;
//			}
//			void func5() {
//				System.out.println("호출");
//			}
//		}
//
//		Apple apple = new Apple();
//		
//		apple.func5();
//		apple.func4().func5();
//		apple.func4().func4().func5();

		// Ex 64
		//this 활용 - 너에게 나를 보낸다
//		class Apple{
//			Apple(){
//			}
//			void f1() {
//				System.out.println(1);
//				Orange orange = new Orange();
//				orange.f2(this);
//			}
//			void f3() {
//				System.out.println(3);
//			}
//		}
//
//		class Orange{
//			Orange(){
//			}
//			void f2(Apple aa) {
//				System.out.println(2);
//				aa.f3();
//			}
//		}
//		
//		Apple apple = new Apple();
//		apple.f1();
		
		// Ex 65
		// 동적 정적
//		class Apple{
//			int num = 10;
//
//			Apple(){
//			}
//			
//			void func() {
//				System.out.println(num);
//				System.out.println(this.num);
//			}
//		}
//		
//		Apple apple = new Apple();
//		apple.func();
		
		// Ex 66
		//상속 example2 파일 확인
//		class Apple11{
//			Apple11(){
//				System.out.println("나는부모");
//			}
//		}
//
//		class Banana extends Apple11{
//			Banana(){
//				System.out.println("나는자식");
//			}
//		}
//
//		class A{
//			A(int n){
//				System.out.println(n);
//			}
//		}
//		class B extends A{
//			B(){
//				super(10);
//				System.out.println("자식생성자");
//			}
//		}
//		
//		Apple11 a1 = new Apple11();
//		Banana b1 = new Banana();
//		//결과는 부모 생성자가 먼저 호출이 되고 자식 생성자가 호출이 되기는 개뿔.. / 자식 -> 부모 -> 자식
//		//super 키워드는 생성자의 첫 줄에 반드시 있어야 함
//		//super는 코딩하지 않으면 super() 디폴트 생성자가 생성됨
//		B b = new B();
		
//		class Apple31{
//			Apple31(){
//			}
//			void f1() {
//				System.out.println("부모1");
//			}
//			void f3() {
//				System.out.println("부모3콜");
//			}
//			void f5() {
//				// 자식의 함수 떄문에 부모의 함수가 보이지 않는다 -> 오버라이딩
//				f3();
//			}
//			void f6() {
//				this.f3();
//			}
//		}
//
//		class Orange31 extends Apple31{
//			Orange31(){
//			}
//			void f2() {
//				System.out.println("자식2");
//			}
//			void f3() {
//				System.out.println("자식3콜");
//			}
//			void f4() {
//				super.f3();
//			}
//		}
//		
//		Orange31 o1 = new Orange31();
//		o1.f2();
//		o1.f3();
//		o1.f4();
//		o1.f5();
//		o1.f6();
		
//		class Apple{
//			Apple(){
//			}
//			void f1() {
//				System.out.println("1번콜");
//			}
//			void f3() {
//				System.out.println("3번부모");
//			}
//		}
//		class Orange extends Apple{
//			Orange(){
//			}
//			void f2() {
//				System.out.println("2번콜");
//			}
//			void f3() {
//				System.out.println("3번자식");
//			}
//		}
//		
//		// 상속 관계에서는 대입 연산자의 타입이 다를수 있음 - 부모 = 자식 의 경우
//		// 부모 = 부모 (o)
//		// 자식 = 자식 (o)
//		// 자식 = 부모 (x)
//		// 부모 = 자식 (o) - 업캐스팅
//		// 문법 = 메모리
//		Apple t1 = new Apple();
//		Orange t2 = new Orange();
////		Orange t3 = new Apple();
//		Apple t4 = new Orange();
//		t4.f1();
////		t4.f2();
//		t4.f3();
//		t2.f1();
//		t2.f3();
//		t2.f2();

//		class Animal{
//			Animal(){
//			}
//			void cry() {
//				System.out.println("울지못함");
//			}
//		}
//		class Dog extends Animal{
//			Dog(){
//			}
//			void cry() {
//				System.out.println("멍멍");
//			}
//		}
//		class Cat extends Animal{
//			Cat(){
//			}
//			void cry() {
//				System.out.println("야옹");
//			}
//		}
//		class Snake extends Animal{
//			Snake(){
//			}
//		}
//		
//		//업캐스팅
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

	}//day12

	private static void day11() {

		// Ex 59
		//함수 사용 방법 네 가지
		class Aa{
			int a;
			
			Aa(){
			}
			
			void func01() {
				System.out.println("1번 콜");
				System.out.println(2);
				System.out.println(3);
			};
			
			void func02(int num) {
				System.out.println(num);
				a = num * num ;
				System.out.println(a);
			}
			
			int func03() {
				System.out.println("3번 콜");
				return 100;
			}
			
			int func04(int num) {
				System.out.println("4번 콜" + num);
				return 777 + num;
			}
			
			void func05(int a, int b, int c) {
				System.out.println(a+b+c);
			}
			
			void func06() {
				System.out.println(1);
				return;
//				System.out.println(2);
			}
			
			void func07(int a, String b) {
				System.out.println(a+" "+b);
			}

			//자바는 인수 초기화 안됨
//			void func08(int a, int b, int c=10, int d=20) {
//				System.out.println(a+" "+b+" "+c+" "+d);
//			}
			
			// Ex 60
			// 가변인수 ...
			void func09(String ... a) {
				System.out.println("------");
				for (String data : a) {
					System.out.println(data);
				}
			}
			
			void func10(int a, int b, int ... c) {
				System.out.println(a +" "+ b);
				for (int i : c) {
					System.out.println(i);
				}
			}
		}
		
		Aa a = new Aa();
		
		a.func01();
		a.func02(30);
		a.func03();
		
		int aaa;
		aaa = a.func03();
		System.out.println(aaa);
		System.out.println(a.func03());
		System.out.println(a.func03()*7);
		
		a.func04(654);
		aaa = a.func04(100);
		System.out.println(aaa);
		System.out.println(a.func04(654));
		a.func05(1, 2, 3);

		a.func06();
		a.func07(10, "호랑이");
		
//		a.func08(1, 2);
//		a.func08(1, 2, 3);
//		a.func08(1, 2, 3, 4);
		
		a.func09("호랑이");
		a.func09("호랑이", "고양이");
		a.func09("호랑이", "고양이", "강아지");
		
		a.func10(10, 20);
		a.func10(10, 20, 30, 40);

		System.out.println();
		
		// Ex 61
		// 2시 43분 27초 - 몇 초 인지 출력하기
		int h = 2, n = 43, s = 27;
		int aa = h * 3600;
		int bb = n * 60;
		int result = 0;
		
		result = aa + bb + s;
		
		System.out.println(result+"초");
		
		// result 결과를 시 분 초로 다시 변환
		
		aa = result / 3600;
		bb = (result%3600) / 60;
		s = result % 60;
		System.out.println(aa+"시 "+bb+"분 "+s+"초");

		System.out.println();
		
		// Ex 62
		// 랜덤 숫자 5개를 아래와 같이 보이게 출력하는 프로그램
		// 값이 4의 배수면 출력 4의 배수가 아니면 가장 가까운 4의 배수 출력
		// 사용예 그림판 bmp 파일 저장
		// 01 >> 04
		// 09 >> 12
		// 17 >> 20
		// 21 >> 24
		// 81 >> 84

		// 22 >> 24
		// 27 >> 28
		// 34 >> 36
		
		// 07 >> 08
		// 11 >> 12
		// 43 >> 44

		// 36 >> 36
		// 40 >> 40
		// 100 >> 100
		Random rnd = new Random();
		for (int i = 0; i < 5; i++) {
			int num = rnd.nextInt(100);
			int b = ((num / 4) + 1) * 4;
//			if(num % 4 == 0) {
//				System.out.printf("%02d >> %02d\n",num,num);
//			}else {
//				System.out.printf("%02d >> %02d\n",num,b);
//			}
			System.out.printf(num%4==0 ? "%02d >> %02d\n" : "%02d >> %02d\n",num,num,num,b);
		}

	}//day11

	private static void day10() {
		
		// Ex 57
		//키보드로 입력을 받아서 별 출력되는 문제
		//i,j 값을 그려서 규칙을 찾는 것이 팁
//		System.out.println("숫자를 입력하세요: ");
//		int num = (new Scanner(System.in)).nextInt();
//		System.out.println(num);

		//*
		//**
		//***
		//****
//		for (int i = 0; i < num; i++) {
//				for (int j = 0; j < num; j++) {
//					if (i>=j) {
//						System.out.print("*");
//					}
//				}System.out.println();
//		}
		
		//***
		//**
		//*
//		for (int i = 0; i < num; i++) {
//			for (int j = 0; j < num; j++) {
//				if (i<=j) {
//					System.out.print("*");
//				}
//			}System.out.println();
//		}

		// 홀수만 입력하는 것으로 가정
		// 
		//  *
		// ***
		//*****
		// ***
		//  *
//		int hnum = num/2;
//		for (int i = -hnum; i <= hnum; i++) {
//			for (int j = -hnum; j <= hnum; j++) {
//				int i2 = Math.abs(i);
//				int j2 = Math.abs(j);
//				System.out.print(i2+j2<=hnum?"*":" ");
//			}System.out.println();
//		}System.out.println();
		
		//Ex 57 풀이
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				int ii = -2 + i;
//				int jj = -2 + j;
//				ii = Math.abs(ii);
//				jj = Math.abs(jj);
//				System.out.printf("[%+d %+d]",ii, jj);
//			}System.out.println();
//		}System.out.println();
		
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				int ii = -2 + i;
//				int jj = -2 + j;
//				ii = Math.abs(ii);
//				jj = Math.abs(jj);
//				if (ii + jj <= 2) {
//					System.out.print("* ");
//				}else {
//					System.out.print("  ");
//				}
//			}System.out.println();
//		}System.out.println();
		
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				int ii = Math.abs(-2 + i);
//				int jj = Math.abs(-2 + j);
//				if (ii + jj <= 2) {
//					System.out.print("* ");
//				}else {
//					System.out.print("  ");
//				}
//			}System.out.println();
//		}System.out.println();
		
//		for (int i = -2; i <= 2; i++) {
//			for (int j = -2; j <= 2; j++) {
//				int ii = Math.abs(i);
//				int jj = Math.abs(j);
//				if (ii + jj <= 2) {
//					System.out.print("* ");
//				}else {
//					System.out.print("  ");
//				}
//			}System.out.println();
//		}System.out.println();
		
		
//		int num = 9;
//		int hn = num/2;
//		for (int i = -hn; i <= hn; i++) {
//			for (int j = -hn; j <= hn; j++) {
//				int ii = Math.abs(i);
//				int jj = Math.abs(j);
//				if (ii + jj <= hn) {
//					System.out.print("* ");
//				}else {
//					System.out.print("  ");
//				}
//			}System.out.println();
//		}System.out.println();
 
		
		int num = 9;
		int hn = num/2;
		for (int i = -hn; i <= hn; i++) {
			for (int j = -hn; j <= hn; j++) {
				int ii = Math.abs(i);
				int jj = Math.abs(j);
				System.out.print(ii + jj <= hn? "* " : "  ");
			}System.out.println();
		}System.out.println();

		// Ex 58
		// a, b, c 가 가지는 조합의 수
//		int a = 10, b = 20, c = 30;
//		int a = 10, b = 30, c = 20;
//		int a = 20, b = 10, c = 30;
//		int a = 20, b = 30, c = 10;
//		int a = 30, b = 10, c = 20;
//		int a = 30, b = 20, c = 10;
		// 결과 20이 출력됨
//		int m = 0;
//		
//		if(a>b) {
//			m = a>c?Math.max(b, c):a;
//		}else {
//			m = a<c?Math.min(b, c):a;
//		}
//		System.out.println(m);

		// 0 ~ 100 까지 랜덤한 숫자를 a,b,c에 각각 받는다
		// 세개의 변수가 가지고 있는 중간값을 출력하는 프로그램
		// for문 100번으로 검증

		// Ex 58 풀이
		// 1차 버전
//		Random rnd = new Random();
//		for (int i = 0; i < 20; i++)
//		{
//			int a = rnd.nextInt(100);
//			int b = rnd.nextInt(100);
//			int c = rnd.nextInt(100);
//			int m;
//			
//			if (a > b) { // a는 최대 아니면 중간 : 왜냐하면 a가 최소가 아니니까.
//				if (a > c) { // a는 최대
//					m = Math.max(b, c);
//				}
//				else { // 중간
//					m = a;
//				}
//			}
//			else {// (a<b) a는 최소 아니면 중간
//				if (a < c) { // a는 최소
//					m = Math.min(b, c);
//				}
//				else {
//					m = a;
//				}
//			}
//			System.out.printf("%2d %2d %2d : %2d\n", a, b, c, m);
//		}
		
		
 		// 2차 버전
//		Random rnd = new Random();
//		for (int i = 0; i < 20; i++)
//		{
//			int a = rnd.nextInt(100);
//			int b = rnd.nextInt(100);
//			int c = rnd.nextInt(100);
//			int m;
//			
//			if (a > b) {
//				m = (a > c) ? Math.max(b, c) : a;
//			}
//			else {
//				m = (a < c) ? Math.min(b, c) : a;
//			}
//			System.out.printf("%2d %2d %2d : %2d\n", a, b, c, m);
//		}
		
		// 3차 버전
		Random rnd = new Random();
		for (int i = 0; i < 20; i++)
		{
			int a = rnd.nextInt(100);
			int b = rnd.nextInt(100);
			int c = rnd.nextInt(100);
			int m;
			
			m= (a > b)
					? (a > c) ? Math.max(b, c) : a
					: (a < c) ? Math.min(b, c) : a;
			
			System.out.printf("%2d %2d %2d : %2d\n", a, b, c, m);
		}
		
	}//day10

	private static void day9() {
		// Ex 50
		// sin
		// 사용 실예
		for (int i = 0; i <= 36; i++) {
			System.out.println(Math.sin(Math.PI*(i*10)/180.0));
		}System.out.println();

		System.out.println("------");
		// Ex 51
		// 선택 정렬 프로그램 - 오름차순
		//인서트정렬,버블정렬,힙정렬 등의 정렬도 이중 포문 사용
//		int ar[] = {10,20,30};
		int ar[] = {5,4,8,7,1,2,6,9};
		
		for (int i = 0; i < ar.length-1; i++) {
			for (int j = i + 1; j < ar.length; j++) {
//				System.out.print(i+" "+j+" "); // 디버깅용
//				System.out.println("i="+ar[i]+" "+"j="+ar[j]);

				if(ar[i] > ar[j]) { //바꿔야된다면
					int temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
					System.out.println("i="+ar[i]+" "+"j="+ar[j]);
				}System.out.println("------");
			}
//			for (int k = 0; k < 6; k++) {
//				System.out.println(ar[k]+" ");
//			}
//			System.out.println();
		}System.out.println();
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i]+" ");
		}System.out.println();

		// Ex 52
		//순차정렬 결과를 역순정렬로 변경하는 프로그램
		//백업용
		for (int i = 0; i < ar.length/2; i++) {
			System.out.println(i+" "+(ar.length-1-i));
		}
		for (int i = 0; i < ar.length/2; i++) {
			int temp = ar[i];
			ar[i] = ar[ar.length-1-i];
			ar[ar.length-1-i] = temp;
		}
		for (int i : ar) {
			System.out.print(i + " ");
		}System.out.println();
		
		// Ex 53
		//출력 결과가 사각형의 형태일때는 무조건 이중포문 사용해야함
		//[0 1][1 2][2 3][3 4][4 5]
		//[0 1][1 2][2 3][3 4]
		//[0 1][1 2][2 3]
		//[0 1][1 2]
		//[0 1]
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5-i; j++) {
				System.out.printf("[%d %d]",j,j+1);
			}System.out.println();
		}System.out.println();
		
		// Ex 54
		// 버블 정렬 프로그램
		int arr[] = {5,4,3,1,2,6,-6,-15};
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if (arr[j]>arr[j+1]) {
					int t = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = t;
				}
			}
			for (int i1 : arr) {
				System.out.print(i1+" ");
			}System.out.println();
		}System.out.println();

		// Ex 55
		// 08 09 10 11
		// 04 05 06 07
		// 00 01 02 03
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
//				System.out.print(i+" "+j+"=");
				System.out.printf("%02d ",(2-i)*4+j);
			}
			System.out.println();
		}System.out.println();
		
		// Ex 56
		// 11 10 09 08
		// 07 06 05 04
		// 03 02 01 00
		// k = 11 변수를 사용해서 k-1하는 프로그램 제외
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
//				System.out.printf("%02d ", (3-i)*4-j-1);
				System.out.printf("%02d ", (2-i)*4-j+3);
			}System.out.println();
		}

	}//day9

	private static void day8() {
		// Ex 42
		//우박수 문제 삼항 연산
		int num = 23;
		while(true) {
			num = num % 2 == 0 ? num / 2 : num * 3 + 1;
			if( num == 1 ) {
				System.out.println(num);
				break;
			}
			System.out.println(num);
		}
		System.out.println("호랑이");

		// Ex 43
		// 이중 for문 / 다중 for문 / 중첩 for문 - 중요한 알고리즘
		for (int i = 0; i < 3; i++) {
			// i j k l m n 변수명 과거의 파스칼 문법 습관
			for (int j = 0; j < 4; j++) {
				System.out.println(i+" "+j);
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print("["+i+" "+j+"]");
			} 
			System.out.println();
		}System.out.println();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print("["+i+" "+j+"]");
			} System.out.println();
		}System.out.println();
		
		// Ex 44
		int k = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				k++;
				System.out.printf("%02d ", k);
			} System.out.println();
		}System.out.println();
		//줄여서 사용하는 방법 다시 듣기
		//이중 for 문에서 밖에 있는 for 문은 항상 세로에 대한 정보 / 안에 있는 for 문은 가로와 관련된 반복 횟수
		for (int i = 0, k1 = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++, k1++) {
				System.out.printf("%02d ", k1);
			} System.out.println();
		}System.out.println();
		
		// Ex 45
		// 0~9 랜덤 숫자 4개 보이고 끝에 더해진 값 출력하기
		// 5 7 6 3 = 21
		Random rnd = new Random();
		for (int i = 0; i < 3; i++) {
			int a = 0;
			for (int j = 0; j < 4; j++) {
				int r = rnd.nextInt(10);
				System.out.printf("%d ",r);
				a += r;
			}
			System.out.println("= " + a);
		}System.out.println();
		
		// Ex 46
		// 65의 아스키 문자 A
		System.out.println(65);
		//타입 캐스팅 - 타입을 강제로 변경
		System.out.println((char)65);
		System.out.println((int)'A');
		
		for (int i = 0; i < 26; i++) {
//			System.out.print((char)(65+i)+" ");
			System.out.print((char)('A'+i)+" ");
		}System.out.println();
		System.out.println();
		
		// Ex 47
		//랜덤하게 알파뱃(A~Z) 가로 네 칸 세로 세 칸 출력
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				int r = rnd.nextInt(26);
				System.out.print((char)('A'+r)+" ");
			}System.out.println();
		}System.out.println();

		// Ex 48
		// 컬렉션 프레임워크
		//동일한 물품이 담긴 상자를 컨테이너 <>
		//컨테이너 안에는 객체 타입만 사용 가능 / 클래스명
		LinkedList<Integer> li = new LinkedList<Integer>(); //li 자료를 관리할 주체
		System.out.println(li.size());

		//Create = add
		li.add(10);
		li.add(20);
		System.out.println(li.size());
		
		for (int i = 0; i < 10; i++) {
			li.add(i);
		}
		System.out.println(li.size());
		System.out.println();
		
		//Reading = get
		for (int i = 0; i < li.size(); i++) {
			Integer data = li.get(i);
			System.out.print(data+" ");
		}System.out.println();
		//동일 결과 출력
		for (int i = 0; i < li.size(); i++) {
			System.out.print(li.get(i)+" ");
		}System.out.println();
		
		//다른 add 사용 방법
		li.add(0, 77);
		li.add(3, 88);
		for (int i = 0; i < li.size(); i++) {
			System.out.print(li.get(i)+" ");
		}System.out.println();

		//Delete = remove
		li.remove(7);
		for (int i = 0; i < li.size(); i++) {
			System.out.print(li.get(i)+" ");
		}System.out.println();
		
		//Update = set
		li.set(3, 99);
		for (int i = 0; i < li.size(); i++) {
			System.out.print(li.get(i)+" ");
		}System.out.println();
		
		//다른 출력 방법 foreach - i 변수를 사용하지 않고 데이터만 가져올 때 사용함
		for (Integer data : li) {
			System.out.print(data + " ");
		}System.out.println();
		System.out.println();

		// Ex 49
		//링크드리스트 실전 사용 방법
		class Apple{
			int x, y;

			Apple(){
			}
			Apple(int a, int b){
				x = a;
				y = b;
			}

			void show() {
				System.out.println(x + " " + y);
			}
		}

		Apple a1 = new Apple();
//		a1.show();
//		
//		a1.x = 100;
//		a1.y = 200;
//		a1.show();

		Apple a2 = new Apple(77, 88);
//		a2.show();

		LinkedList<Apple> oli = new LinkedList<Apple>(); // object li

		oli.add(a1);
		oli.add(a2);
		
		System.out.println(oli.size());
		
		//C
		for (int i = 0; i < 5; i++) {
			Apple ta = new Apple();
			ta.x = i * 10;
			ta.y = i * 20;
			oli.add(ta);
		}
		System.out.println(oli.size());
		
		for (int i = 0; i < 5; i++) {
			Apple ta = new Apple(i*30, i*40);
			oli.add(ta);
		}
		System.out.println(oli.size());
		
		for (int i = 0; i < 5; i++) {
			oli.add(new Apple(i*50, i*60));
		}
		System.out.println(oli.size());
		System.out.println();
		
		//R
		for (int i = 0; i < oli.size(); i++) {
			System.out.println(oli.get(i).x+" "+oli.get(i).y);
		}System.out.println();
		for (int i = 0; i < oli.size(); i++) {
			System.out.print("-");
			oli.get(i).show();
		}System.out.println();
		for (Apple data : oli) {
			System.out.print("--");
			data.show();
		}System.out.println();
		
		//D
		oli.remove(3);
		for (Apple apple : oli) {
			apple.show();
		}
		System.out.println("------");
		
		//U
		oli.set(2, new Apple(888, 999));
		for (Apple apple : oli) {
			apple.show();
		}

	}//day8

	private static void day7() {

		// Ex 36
		// 짝을 짓는 방법 / format / sql 쿼리문 입력에 사용했었음 
		String s1 = String.format("무궁화꽃이%d피었습니다%s.", 10, "많이");
		System.out.println(s1);

		// Ex 37
		//String 함수 학습
		//Extend -> 상속
		//implements -> 인터페이스 상속

		// Ex 38
		//마지막 문장이 else if로 끝나도 else로 마무리하는 습관 
		//키보드숫자입력 받아서 100-90 A 90-80 B .. D 나머지 F
		System.out.println("점수를 입력하세요: ");
		int input = (new Scanner( System.in )).nextInt();

		if(input >= 90) {
			System.out.println("A");
		}else if(input >= 80) {
			System.out.println("B");
		}else if(input >= 70) {
			System.out.println("C");
		}else if(input >= 60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
		
		// Ex 39
		// 중첩 제어문
		Random rnd = new Random();
		int r = rnd.nextInt(100);

		int a = 0, b = 0;
		
		System.out.println(r);
		
		a = r / 10;
		b = r % 10;

		if (a%2==0) {
			if (b%2==0) {
				System.out.println("우동");
			}else {
				System.out.println("짜장");
			}
		}else {
			if (b%2==0) {
				System.out.println("냉면");
			}else {
				System.out.println("탕수육");
			}
		}

		// Ex 40
		//while
		int a1 = 0;
		while(a1<10) {
			a1 += 1;
			System.out.println(a1);
		}
		System.out.println("호랑이");
		
		int a2 = 0;
		while(a2<=10) {
			a2 += 1; // 자바에서는 a++
			if(a2==3) {
				continue;
			}
			if(a2==6) {
				break;
			}
			System.out.println(a2);
		}
		System.out.println("호랑이");
		//전형적인 while 형식
		int a3 = 0;
		while(true) {
			a++;
			if(a==5) {
				System.out.println("프로그램중단");
				break;
				//System.out.println("호랑이"); //Unreachable code-도달할수없는 에러
			}
			System.out.println("루핑");
		}
		System.out.println("종료");
		
		System.out.println("---");
		// Ex 41
		//우박수 문제
		int num = 23;
		
		while(true) {
			if(num%2==0) {
				num=num/2;
			}else {
				num=num*3+1;
			}
			if(num==1) {
				System.out.println(num);
				break;
			}
			System.out.println(num);
		}
		System.out.println("호랑이");

	}//day7

	private static void day6() {

		// Ex 30
		// 숫자를 문자열로 치환 -> 고급 프로그래밍? 통신에서 사용됨
		int num = 100;
		String s = Integer.toString(num);
		System.out.println(s);
		System.out.println(s+100);
		// 단순형 팁 - 슈가 코드 / Syntactic Sugar
		String s1 = num+"";
		
		// Ex 31
		// 문자열을 숫자로 치환
		String t = "777";
		int a = Integer.parseInt(t);
		System.out.println(a+888);
		
		// Ex 32
		// 슈가 코드 예 - 정규표현식 / 이것이 자바다 책 517 페이지 확인 / 이메일 전화번호 학습

		// Ex 33
		// 16진수
		int a1 = 10;
		int b = 0x10;
		System.out.println(a+" "+b);
		
		int c = 0010;
		int d = 0376;
//		int e = 0386; // d의 값을 8진수로 인식해서 e에 8진수의 최대값인 7을 초과한 값이 있어서 에러남
		System.out.println(d);
		
		// Ex 34
		// 부동 소수점 연산이 프로그래머가 생각하는 결과값과 미세하게 다를수 있음
		// 부동 소수점 연산은 절대로 등가를 사용하지 않음
		float sum = 0.0f;
		for (int i = 0; i < 100; i++) {
			sum += 0.1f;
		}
		System.out.println(sum);
		if(sum==10.0f) {
			System.out.println("호랑이");
		}else {
			System.out.println("a");
		}

		// Ex 35
		// Math 클래스의 max함수는 둘중에 큰수를 결과로 리턴함
		System.out.println(Math.max(10, 20));
		
		// static 함수 실습
//		Apple a2 = new Apple();
//		a2.f1();
//		// 처음부터 만들어져 있어서 단점으로 많이 만들면 메모리?
//		a2.f2();
		
		System.out.println(Math.max(10, 20)); // 최대값
		System.out.println(Math.min(10, 20)); // 최소값
		System.out.println(Math.abs(-7)); // 절대값
		System.out.println(Math.pow(2, 8)); // 2의 8승
		System.out.println(Math.sqrt(8)); // 루트값

		double s2 = Math.sqrt(8);
		System.out.println(s2*s2);

	}//day6

	private static void day5() {
		
		// Ex 26
		// 클래스
		// 생성자 설명
		class Tiger {
			//기본문법 세가지
			//1.생성자 함수
			//생성자 특징 - 제약조건 6가지
			// 1. 생성자 이름은 반드시 클래스 이름과 동일하다.
			Tiger() { //함수 앞에 타입의 함수 리턴 값의 타입
				System.out.println(1);
			//	return 10; // 생성자 함수는 리턴 값을 가질수 없어서 에러
			}
			// 2. 함수 오버로딩 가능하다.
			//Tiger(){// 동일한 모양이라 에러
			//}
			Tiger(int a){// 인수 전달을 하여 오버로딩
				System.out.println(2);
			}
			Tiger(int a, int b){// Tiger(int a, b) {} 각각 변수의 타입이 없어서 에러
				System.out.println(3);
			}
			Tiger(int a, String b, Tiger c){//인수의 전달 개수가 다르면 오버로딩 가능
				System.out.println(4);
			}
			Tiger(float a){//인수의 개수가 동일해도 타입이 다르면 오버로딩 가능
				System.out.println(5);
			}
			Tiger(short a){
				System.out.println(6);
			}
			// 3. 프로그래머가 임의로 호출할 수 없다.
			// 4. 객체가 생성될 떄 자동 호출된다.

			//2.멤버변수 또는 필드
			//3.멤버함수 또는 "메소드"
		}

		Tiger t1 = new Tiger(); // 객체 생성 기본 문법 / 함수 호출 시 무조건 () 필요
		//t1.Tiger(); // 임의로 호출할 수 없어서 에러
		Tiger t2 = new Tiger((int)10);
		Tiger t3 = new Tiger(10, 20);
		Tiger t4 = new Tiger(10,"호랑이",null);
		Tiger t5 = new Tiger(3.14f);
		Tiger t6 = new Tiger((short)100); // 타입 캐스팅

		System.out.println(7);
		Tiger t7 = new Tiger();
		System.out.println(8);

//		int x = 10, y = 20;
//		Tiger t8 = new Tiger(x, y);
//		String s1 = new String("코끼리");
//
//		System.out.println();
//		Tiger t9 = new Tiger(x*y,s1,t7);
//		System.out.println();
//		Tiger t10 = new Tiger(x*y,s1,new Tiger()); // 함수 인자에 대입 연산으로 넣어주고 있다.

		class Lion{
			int Lion(){
				System.out.println(11);
				return 100;
			}
			Lion(){
				System.out.println(12);
			}
			Lion(int a){
				System.out.println(13);
			}
			Lion(int a, short b){
				System.out.println(14);
			}
			Lion(double a){
				System.out.println(15);
			}
			Lion(Lion a, Lion b, Lion c){
				System.out.println(16);
			}
			Lion(Lion a){
				System.out.println(17);
			}
		}
		System.out.println("---");
		Lion l1 = new Lion();
		l1.Lion();
		System.out.println(l1.Lion());
		Lion l2 = new Lion(10);
		System.out.println();
		Lion l3 = new Lion(10+10,(short)10);
		Lion l4 = new Lion(3.14);
		System.out.println();
		Lion l5 = new Lion(new Lion(),new Lion(10),l1);
		System.out.println();
		System.out.println(18);
		Lion l6 = new Lion(l1);

		// Ex 27
		// 필드 설명
		class Tiger1{
			//2.멤버변수 또는 필드
			int a; //변수 선언후 초기값 없음
			String b;
			int c = 20;
			String d = "호랑이";
			String e = new String("코끼리");

			Tiger1(){// 인수 전달이 없는 생성자를 "디폴트 생성자"로 명시함
				a = 100;
				b = "독수리";
				c = 200;
				d = "앵무새";
				e = "날파리";
			}//생성자는 필드(변수값)초기화 목적으로만 사용
		}

		Tiger1 t11 = new Tiger1();//t1 객체
		System.out.println(t11.a);//초기값이 없어서 0 출력됨
		System.out.println(t11.b);//초기값이 없어서 null 출력됨
		System.out.println(t11.c);
		System.out.println(t11.d);
		System.out.println(t11.e);

		// Ex 27
		// 필드 선언후 변수값 초기화 예제
		class Tiger2{

			int x = 100, y = 100;

			Tiger2(){

			}

			Tiger2(int a, int b){
				x = a; // x=필드 / a=생성자에서 전달 받은 인수 
				y = b;
			}

			Tiger2(int a){
				x = y = a;
				//				x = a;
				//				y = a;
			}

		}

		Tiger2 t12 = new Tiger2();
		Tiger2 t13 = new Tiger2();
		Tiger2 t14 = new Tiger2(200, 300);
		Tiger2 t15 = new Tiger2(500, 600);
		Tiger2 t16 = new Tiger2(700);

		System.out.println(t12.x + " " + t12.y);
		System.out.println(t13.x + " " + t13.y);
		System.out.println(t14.x + " " + t14.y);
		System.out.println(t15.x + " " + t15.y);
		System.out.println(t16.x + " " + t16.y);


		// Ex 28
		// 클래스 안에 디폴트 생성자를 찾지 못하는 에러
		// 클레스 안에 생성자가 없으면 디폴트 생성자를 눈에 보이지 않지만 시스템이 자동 생성하다가 생성자가 생기면 디폴트 생성자를 만들지 않음 
		class Apple{
			Apple(int a){
			}
		}
//		Apple a1 = new Apple();
		Apple a2 = new Apple(10);

		// Ex 29
		// 함수 유형 설명
		class Apple1{
			Apple1(){
			}
			//3.멤버함수 또는 "메소드"
			// void func01() -> 용어: 함수 원형 / 함수 프로토타입
			void func01() { // 함수 호출시 전달 인자 없는 유형
				System.out.println(1);
			}
			void func02(int a) { // 함수 호출시 반드시 인수 전달
				System.out.println(a);
			}
			int func03() { // 호출 시 리턴
				return 200;
			}
			int func4(int a) { // 인수 전달 호출 리턴
				return a*7;
			}
			
		}

		Apple1 a1 = new Apple1();
		a1.func01(); 
		a1.func02(100);

		// 리턴 함수 사용 방법
		int num = a1.func03(); //1
		System.out.println(num);
		
		int count; //2
		count = a1.func03();
		System.out.println(count);
		
		System.out.println(a1.func03()); //3

		System.out.println(a1.func03()*100); //활용1
		
		System.out.println(a1.func03()*a1.func03()); //활용2
		
//		System.out.println(a1.func01()); // 함수에 리턴이 있을때만 사용 가능한 에러

		int x = a1.func4(7);
		System.out.println(x);
		
		int y;
		y = a1.func4(8);
		System.out.println(y);
		
		System.out.println(a1.func4(8));


		// Ex 30
		class Apple2{
			Apple2(){

			}
			//함수 유형 기본형 네가지
			void func01() {
				System.out.println(1);
			}
			void func02(int a) {
				System.out.println(2);
			}
			int func03() {
				return 10;
			}
			int func04(int a) {
				return 20;
			}
			//함수 사용 방법
			void func05(int a, int b) {
				System.out.println(5);
			}
			void func06(int a, int b, int c) {
				System.out.println(a*b+c);
			}
			void func07(int count, String s) {
				for (int i = 0; i < count; i++) {
					System.out.println(i+" "+s);
				}
			}
			void func08() { // 함수 안에서 멤버 함수 호출 가능
				System.out.println(8);
				func01();
				func09();
			}
			void func09() {
				System.out.println(9);
//				func08(); //func08에서 func09호출 중 func09에서 func08 호출시 무한 루핑으로 시스템 다운 가능
			}
			void func10() {
				System.out.println(88);
			}
			void func10(int a) {
				System.out.println(99);
			}
			void func10(int a, int b) { // 함수 오버로딩
				System.out.println(a+b);
			}
			// 리턴 함수
			int func11(int a, int b) {
				int c = a*a+b*b;
				return c; // 
			}
			//
			void func12(int num) {
				if(num>0) {
					if(num%2==0) {
						System.out.println("짝수입니다.");
					}else {
						System.out.println("홀수입니다.");
					}
				}else {
					System.out.println("양수가 아닙니다.");
				}
			}
			// if else 사용하는 경우 1. if 줄 수와 else 줄수가 같음 2. 판단하는 것이 연관성이 있음
			//제어문 안에 제어문을 안넣는 것이 좋음
			//코드 디자인
			void func13(int num) {
				if(num<0) {
					System.out.println("음수는 입력안됨");
					return; // void에서 return; 사용시 break 같은 기능 // return 단독 사용 가능
				}
				if(num%2==0) {
					System.out.println("짝수입니다.");
				}else {
					System.out.println("홀수입니다.");
				}
			}
			void func14(int num) {
				if(num%2==0) {
					System.out.println("짝수입니다.");
					return;
				}else {
					System.out.println("홀수입니다.");
				}
				System.out.println("호랑이");
			}
			// 코드 가독성 때문에 else 사용하지 않은 경우
			void func15(int num) {
				if(num!=1234) {
					System.out.println("패스워드가 맞지 않습니다.");
					return;
				}
				System.out.println("접속을 시도합니다.");
			}
			//리턴 값이 있는 경우 제어문 안에서 반드시 리턴을 넣어줘야함
			int func16(int num) {
				if(num%2==0) {
					return num*2;
				}else {
					return num/2;
				}
			}
		}
		//
		Apple2 a3 = new Apple2();

		a3.func05(10, 20);
		a3.func06(10, 20, 30);
		a3.func07(14, "코끼리");
		a3.func08();
		a3.func10();
		a3.func10(1);
		a3.func10(10, 20);
		System.out.println();

		//사용법
		int num1 = a3.func11(1, 2);
		System.out.println(num1);

		int num2;
		num2 = a3.func11(1, 2);
		System.out.println(num2);

		System.out.println(a3.func11(1, 2));
		
		//
		a3.func14(3);
		a3.func15(1234);
		System.out.println(a3.func16(6));

	}//day5

	private static void day4() {
		// Ex 20
		System.out.println(Integer.MAX_VALUE);//integer 최대값은 MAX_VALUE에 마우스 커서두고 f3 원형 찾기
		System.out.println(Short.MAX_VALUE);//short 최대값
		System.out.println(Double.MAX_VALUE);//double 최대값
		//f3 입력시 Class File Editor화면 출력시 Attach Source 버튼 선택 -> 익스터널 로케이션 선택 -> 익스터널 파일 버튼 선택 ->경로 찾아서 src 압축파일 연결

		Random rnd = new Random();
		for (int i = 0; i < 10; i++) {
			int r = rnd.nextInt(Integer.MAX_VALUE);
			System.out.println(i+" "+r);
		}

		// Ex 21
		//int num = r(i.m.v)
		//1234 -> 10
		//3426117->?
		Random rnd1 = new Random();
		int num = rnd1.nextInt(Integer.MAX_VALUE);
		int sum = 0;

		System.out.print(num+" -> ");

		while(true) {

			int a = num % 10;
			num = num / 10;
			sum += a;

			//			System.out.print(num);
			//			System.out.println(" "+a);

			if(num==0) {
				break;
			}
		}

		System.out.println(sum);

		// Ex 22
		//final 선언
		//1.멤버 변수(필드) 앞에 -> 상수화 시킴
		//2.클래스 이름앞 class 앞에 -> 상속을 받을수 없음 extends, 부모 클래스가 되지 않음
		//		final class Tiger{
		//		}
		//		class Lion extends Tiger{
		//		}
		//3.멤버 함수(메소드) 앞에 -> 해당함수를 오버라이딩 할수없음
		//		class Tiger{
		//			final void f1() { //함수 생성시 소문자만 사용
		//			}
		//		}
		//		class Lion extends Tiger{
		//			void f1() {
		//			}
		//		}

		// Ex 23
		// o x 출력 프로그램
		Random rnd2 = new Random();
		for (int i = 0; i < 10; i++) {
			int num1 = rnd2.nextInt(2);
			//			System.out.print(num);
			if(num1==0) {
				System.out.print("o ");
			}else{
				System.out.print("x ");
			}
		}
		// Ex 24
		// o x o o o x x o o x
		// o가 나온 횟수
		// o:6
		// x:4
		Random rnd3 = new Random();
		int a=0, b=0;
		for (int i = 0; i < 10; i++) {
			int num2 = rnd3.nextInt(2);

			//			System.out.print(num);
			if(num2==0) {
				a++;
				System.out.print("o ");
			}else{
				b++;
				System.out.print("x ");
			}
		}System.out.println();
		System.out.printf("o:%d%n",a);
		System.out.printf("x:%d%n",b);

		//2번 o 가 연속해서 가장 많이 나온 횟수
		// o:3
		// x:2
		Random rnd4 = new Random();
		int a1=0, b1=0, c=0, d=0, e=0, f=0;

		for (int i = 0; i < 10; i++) {
			int num3 = rnd4.nextInt(2);
			if(num3==0) {
				a1++;
				System.out.print("o ");
			}else{
				b1++;
				System.out.print("x ");
			}

			if(num3==0) {
				c++;
				if(d<c) {
					d = c;
				}
			}else {
				c = 0;
			}


			if(num3==1) {
				e++;
				if(f<e) {
					f = e;
				}
			}else {
				e = 0;
			}
		}
		System.out.println();
		System.out.printf("o:%d%n",a);
		System.out.println("o연속: "+d);
		System.out.printf("x:%d%n",b);
		System.out.println("x연속: "+f);

		// Ex 25
		//내부 클래스
		class Apple {
			
			void f1() { //함수 생성
				System.out.println("호랑이");
			}
			void f2() {
				System.out.println(this);//생성된 객체
			}
			int f3() {
				return 100;
			}
			String f4() {
				return "호랑이";
			}
			Apple f5() {
				return this;
			}
			void pretty() {
				System.out.println("프리티");
			}
		}

		Apple a2 = new Apple();//new 단축키 사용
		Apple a3 = new Apple();
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a3.hashCode());
		System.out.println(Integer.toHexString(a3.hashCode()));
		a2.f1();
		a3.f2();
		a2.f2();
		a3.f1();

		Apple a4 = new Apple();
		a4.f2();
		a4.f5().f1();
		a4.f5().f5().f1();//체인링
		a4.f5().pretty();		

	}//day4

	private static void day3() {

		// Ex 15
		for (int i = 0; i < 10; i++) {
			System.out.print(i + " ");
		} System.out.println(); //한줄로 출력

		for (int i = 0; i < 10; i++) {
			//			System.out.printf("%d",i);
			System.out.printf("%03d",i);
		}System.out.println();

		System.out.println("호랑이");

		// Ex 16
		//피보나치수열 프로그램
		int a = 0, b = 1, sum;
		for (int i = 0; i < 10; i++) {
			sum = a + b;
			a = b;
			b = sum;
			System.out.print(sum + " ");
		}System.out.println();

		// Ex 17
		//0부터 100 사이의 숫자(랜덤숫자)
		//나온 숫자를 더하기
		Random rnd = new Random();
		int a1, b1, sum1;

		for (int i = 0; i < 5; i++) {
			int r = rnd.nextInt(100);

			a1 = r / 10;
			b1 = r % 10;

			sum1 = a1 + b1;

			System.out.printf("%02d"+" >> 결과 " + "%02d\n",r,sum1);
		}System.out.println();

		Random rnd1 = new Random();
		int a2, b2, sum3 = 0, sum4 = 0;

		for (int i = 0; i < 5; i++) {
			int r = rnd.nextInt(100);

			a = r / 10;
			b = r % 10;

			sum3 = sum3 + a;
			sum4 = sum4 + b;

			System.out.printf("%02d%n",r);
		}System.out.println();

		System.out.println(sum3 + " " + sum4);

		// Ex 18
		// 100-999
		for (int i = 0; i < 5; i++) {
			Random rnd2 = new Random();
			int r = rnd2.nextInt(900)+100;
			System.out.println(r);
		}

		// Ex 19
		// 3가지 조건 만족시키기
		// 1.중복되는 숫자가 나오면 안됨 668
		// 2.반드시 5개 출력됨
		// 3.배열을 사용하지 않는다.
		Random rn = new Random();

		//		for (int i = 0; i < 10; i++) {
		//		int r = rn.nextInt(1000);
		//		
		//		int a = r / 100;
		//		int b = r % 100 / 10;
		//		int c = r % 100 % 10;
		//
		//		if(a==b||b==c||a==c) {
		//			i--;
		//			continue;
		//		}
		//		System.out.println(r);
		//	}

		int count = 0; //count = ct로도 작성됨

		while (true) {
			int r = rn.nextInt(1000);
			System.out.println(r);
			int a3 = r / 100;
			int t = r % 100;

			int b3 = t / 10;
			int c = t % 10;

			if(a3==b3||b3==c||a3==c) {
				continue;
			}
			System.out.println(r + " " + a3 + " " + b3 + " " + c);
			if(++count==5) {
				break;
			}
			//			System.out.println(r + " " + a + " " + b + " " + c);
		}

	}//day3

	private static void day2() {
		// Ex 8
		//키보드 숫자 하나 입력 받아서 입력받은 숫자까지의 합을 구하는 프로그램 
		System.out.println("숫자를 입력해주세요: ");
		int num = (new Scanner( System.in )).nextInt();
		System.out.println(num);
		int sum = 0;

		for (int i = 1; i <= num; i++) {
			sum += i; //선호
		}
		System.out.println(sum);

		// Ex 9
		int a = 3;
		int b = a++; //대입증가
		System.out.println(a+" "+b);

		int c = 3;
		int d = ++c; //증가대입
		System.out.println(c+" "+d);

		// Ex 10
		//i가 짝수 일떄 호랑이 출력 홀수일떄 코끼리 출력
		for ( int i = 1; i <= 20; i++ ) {
			if ( i % 2 == 0 ) {
				System.out.println("호랑이");
			} else {
				System.out.println("코끼리");
			}
		}

		// Ex 10-1
		//ifelse문장은 반드시 삼항연산이 되는지 확인하자
		for ( int i = 1; i <= 20; i++ ) {
			System.out.println((i%2==0)?"호랑이":"독수리");
		}
		//		
		//		//
		//		int a=0;
		//		if(true) {
		//			a++;
		//		}else {
		//			a--;
		//		}
		//		int b=(true)?a++:a--;
		//		System.out.println(b);

		a=(true)?a++:a--;
		System.out.println(a);

		//삼항연사자
		int a1=10;
		if(3>2){
			a1=a1+1;
		}else{
			a1=a1-1;
		}

		a1=(3>2)?a1+1:a1-1;

		// Ex 11
		//3의 4승 구하는 프로그램 작성
		int sum1 = 1;
		for (int i = 0; i < 6; i++) {
			sum1 = sum1*3;
		}
		System.out.println(sum1);

		// Ex 12
		//6*5*4*3*2*1 6!(팩토리) 구하는 프로그램 작성
		int sum2 = 1;
		for (int i = 1; i <= 6; i++) {
			sum2 = sum2*i;
		}
		System.out.println(sum2);
		int sum3 = 1;
		for (int i = 0; i < 6; i++) {
			sum3 = sum3*(i+1);
		}

		// Ex 13
		//교환 프로그램/스왑
		int a2 = 10, b2 = 20;
		int temp;

		System.out.println(a2+" "+b2);

		temp = a2;
		a2=b2;
		b2=temp;

		System.out.println(a2+" "+b2);

		// Ex 14
		//랜덤으로 숫자 뽑는 프로그램
		Random rnd = new Random();
		int r = rnd.nextInt(100); //100은 랜덤하게 나오는 숫자의 유효범위 0~99
		System.out.println(r);

		System.out.println(rnd.nextInt(100));

		System.out.println("----------");
		for (int i = 0; i < 10; i++) {
			r=rnd.nextInt(100);
			System.out.println(r);
		}
		System.out.println("----------"); //세퍼레이트/구분자
		for (int i = 0; i < 10; i++) {
			System.out.println(r=rnd.nextInt(100));
		}

	}//day2

	private static void day1() {
		// Ex 1 "syso"+ctrl+space 출력문 자동완성
		// Ex 2 ctrl+f11 실행
		// Ex 3 8타입
		//		byte - 1byte
		//		short - 2byte - 음수/양수 가능
		//		char - 2byte - 음수를 받을 수 없다
		//		int - 4byte
		//		long - 8byte
		//		float - 4byte - 부동소수점 사용
		//		double - 8byte - 부동소수점 사용
		//		boolean - 1byte

		//줄이동 alt + 방향키
		//줄복사 ctrl + alt + 방향키

		// 3번
		//		int 와 Integer의 차이: int는 자바의 표준타입이고 integer는 class이다.
		//			a는 대입을 주거나 받을 수 있지만 b는 클래스라서 함수를 쓸 수 있다. Int를 Integer로 사용할떄 class 를 잘 이용한다라고 한다.
		//			int => Integer : Boxing Integer => int = unboxing
		int a = 10;
		Integer b = 20;


		// Ex 4 for+ctrl+space+enter
		//for 사용법 3가지
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		for (int i = -5; i <= 5; i++) {
			System.out.println(i);
		} //5*2+1  11번 반복

		// Ex 5 반복제어문 선택 기준 - 반복 횟수를 알떄 for 모를떄 while
		//구구단 5단 출력
		for (int i = 0; i <10; i++) {
			System.out.println("5 * " + i + " = " + i*5);
		}
		for (int i = 0; i <10; i++) {
			System.out.printf("5 * %d = %d\n",i,i*5);
		}

		// Ex 6 합산 프로그램
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			System.out.println("sum"+sum + " i"+i);
			sum = sum + i;
			System.out.println(sum);
		}

		int sum1 = 0;
		for (int i = 1; i <= 10; i++) {
			System.out.println("sum"+sum1 + " i"+i);
			sum1 = sum1 + i;
		}
		System.out.println(sum1);
		//왜 합산이 될까

		// Ex 7 줄정렬ctrl+i
		// 키 입력 받는 구문 2번 사용
		//1번
		Scanner scanner = new Scanner( System.in );
		System.out.println(1);
		System.out.println("숫자를 입력해주세요: ");
		int num = scanner.nextInt(); //입력전 대기상태 용어-블로킹
		System.out.println(2);
		System.out.println(num);

		//2번
		int num2 = (new Scanner( System.in )).nextInt();
		System.out.println(num2);		

		//3번
		System.out.println((new Scanner( System.in )).nextInt());

		//내가 입력한 숫자의 단이 출력되게 println 사용
		System.out.println("구구단의 단수 입력해주세요: ");
		int num3 = (new Scanner( System.in )).nextInt();
		System.out.println(num3 + "단");

		for (int i = 0; i < 10; i++) {
			System.out.println(num + " * " + i + " = " + num*i);
		}

	}//day1

}


