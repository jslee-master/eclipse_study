package day3;

import java.util.Scanner;

public class NumberReverse {

	public static void main(String[] args) {
		System.out.println("21억 이하의 양의 정수 입력");
		System.out.println("0이 입력되면 종료.");
		Scanner sc = new Scanner(System.in);

		int reverse = 0;
		int sum = 0;
		int i = 0;

		while(i<=9) {
			System.out.print(">");
			reverse = sc.nextInt();
			int result = reverse(reverse);
			int result2 = sum(reverse);
			if(reverse>2100000000) break;
			if(reverse<=0) break;
			System.out.println(result + " " + result2);
			i++;
//			System.out.println("최대 10개의 양의 정수가 입력될 수 있다.");
			} 
		System.out.println();
		System.out.println("프로그램 종료");
	}
		
		 private static int reverse(int x) {
			  int result = 0;
			   while(x > 0){
			          result = result*10 + x%10;
			          x /= 10;
			   }
			   return result;
		 }
		 
		 private static int sum(int n) {
			 int result2 = 0;
			 while (n > 0)
			 {
				 result2 += n % 10;
				 n /= 10;
			 }
			 return result2;
		 }
	
}
