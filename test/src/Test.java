import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws Exception  {

/*		//예제 연습
		int a = 100; // 입력
		int b = 0; // 출력
		
		// 조건식
		if ( a > 100 ) {
			b = -1;
		} else {
			b = 1;
		}
		
		System.out.println( "출력: " + b);
		
		// 삼항 연산자
		System.out.println( "출력: " + ( a > 100 ? -1 : 1) );
		
		b = ( a > 100 ? -1 : 1);
		System.out.println( "출력: " + b);
*/

/*		//연습문제
		System.out.println("과목을 선택하세요");
		System.out.println("(1.자바 2.C 3.C++ 4.파이썬)");
		System.out.print("과목번호: ");
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if(num==1) {
			System.out.println("R101호 입니다.");
		} else if(num==2) {	
			System.out.println("R202호 입니다.");
		} else if(num==3) {
			System.out.println("R303호 입니다.");
		} else if(num==4) {
			System.out.println("R404호 입니다.");
		}  else {
			System.out.println("상담원에게 문의하세요.");
		}		
		switch(num) {
			case 1:
				System.out.println("R101호 입니다.");
				break;
			case 2:
				System.out.println("R202호 입니다.");
				break;
			case (3):
			{
				System.out.println("R303호 입니다.");
				break;
			}
			case (4):
				System.out.println("R404호 입니다.");
				break;
			default:
				System.out.println("상담원에게 문의하세요.");
				break;
		}
*/
	
/*		//117페이지 예제
		int num = (int)(Math.random()*6) + 1;
		
		switch(num) {

		// if( num == 1 || num == 2 || num == 3)
			case 1:
				System.out.println("1번이 나왔습니다.");
			case 2:
				System.out.println("2번이 나왔습니다.");
			case 3:
				System.out.println("3번이 나왔습니다.");
				break;

		// if(num == 4) else if(num == 5) else if(num == 6)
			case 4:
				System.out.println("4번이 나왔습니다.");
				break;
			case 5:
				System.out.println("5번이 나왔습니다.");
				break;
			default:
				System.out.println("6번이 나왔습니다.");
				break;
		}
*/	

/*		System.out.println("월을 입력하세요");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		switch(num) {
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.print("30일");
				break;
			case 2:
				System.out.print("28일");
				break;
			default:
				System.out.print("31일");
				break;
		}

		System.out.println(" 입니다.");
*/
		
/*		//윤년 계산 연습문제
		System.out.print("연도 입력: ");
		
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();

		if (Year(year)) {
			System.out.print("출력: " + year + "년은 윤년!");
		} else {
			System.out.println("출력: " + year + "년은 평년!");
		}
	}
	private static boolean Year (int year) {
		if ((year % 4 == 0 && year % 100 !=0) || year % 400 ==0) {
			return true;
	} else {
		return false;
	}
*/
//		int sum = 0;
//		for (int i = 1; i<7; i++) {
//		for (int i = 1; i<=100; i++) {

/*		//for sum에 1부터 20까지 2씩 더하기
 		for (int i = 1; i<20; i++) {
			sum=sum+i;
			i=i*i;
			System.out.println(i);
		}
		System.out.println(sum);
*/		
		
/*		//for sum에 1부터 100까지 더하기, 단 sum이 85인 경유 빠져 나오기 : break
		for (int i = 1; i<=100; i++) {
			if(sum == 85) {
				break;
			}
			sum=i+sum;
		}
		System.out.println(sum);
*/
		
/*		int k = 0;
		for(k = 1; k <= 100; k++) {
			sum = k + sum;
		}
		System.out.println("횟수: " + k + "번 만에 sum = " + sum);
*/

/*		//구구단 연습 문제
		System.out.println("단을 입력해주세요");
		System.out.print("단: ");
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		
		for (; m<=9; m++) {
			if (m==0) break;
			for (int n=1; n<=9; n++) {
				System.out.println(m + " * " + n + " = " + (m*n));
			}
		}
		System.out.print("종료");
*/

/*		//화살표 키값 입력 받는 연습 문제 -> 못함
		boolean run = true;		
		int speed = 0;
		int keyCode = 0;
		
		while(run) {
			if(keyCode!=13 && keyCode!=10) {
				System.out.println("-----------------------------");
				System.out.println("1.증속 | 2.감속 | 3.중지");
				System.out.println("-----------------------------");
				System.out.print("선택: ");
			}
			
			keyCode = System.in.read();
			
			if (keyCode == 49) {
				speed++;
				System.out.println("현재 속도=" + speed);
			} else if (keyCode == 50) {
				speed--;
				System.out.println("현재 속도=" + speed);
			} else if (keyCode == 51) {
				run = false;
			}
		}	
		
		System.out.println("프로그램 종료");
*/

/*		//130p 예제 실습
		System.out.println("메시지를 입력하세요");
		System.out.println("프로그램을 종료하려면 q를 입력하세요.");
		
		Scanner scanner = new Scanner(System.in);
		String inputString;
		
		do {
			System.out.print(">");
			inputString = scanner.nextLine();
			System.out.println(inputString);
		} while( ! inputString.equals("q") );
		
		System.out.println();
		System.out.println("프로그램 종료");
*/
		
/*		//HighLow 게임		
		int rand = (int)(Math.random()*100) + 1;
		System.out.print("0 ~ 100 숫자를 입력해 주세요 : ");
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			
			if (rand>num) {
				System.out.print("더 큰 숫자를 입력해 주세요 : ");
			}
			else if (rand<num) {
				System.out.print("더 작은 숫자를 입력해 주세요 : ");
			}
			else {
				System.out.println("정답!");
			}
		}
*/
		
		// 배열 초기화
		int[] scores = {100, 99, 80, 90, 50};
		int sum = 0;
		
//		for(int i = 0; i < 5; i++) {
//			sum += scores[i];
//		}
//		System.out.println("Avg: " + sum/5);
		
//		for(int i = 0; i < scores.length; i++) {
//			sum += scores[i];
//		}
//		System.out.println("Avg: " + sum/ scores.length);
		
		// 문자열 배열
		String[] messages = {
				"HI",
				"NO",
				"Hello"
		};
		
		for(int i = 0; i < messages.length; i++) {
			System.out.println(messages[i]);
		}

		// 배열 초기: new
		int[] adder = new int[5];
		for(int i = 0; i < scores.length; i++) {
			adder[i] = scores[i] + 2;
		}
		
		//참조형 주소
		System.out.println(scores);
		System.out.println(messages);
		System.out.println(adder);
		
		
	}
	
}
