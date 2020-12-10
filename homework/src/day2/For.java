package day2;

import java.util.Scanner;

public class For {

	public static void main(String[] args) {

		//ForSumFrom1To100Example
		System.out.print("���ڸ� �Է����ּ���: ");
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
				
		System.out.print(sum);

		int i;
		for(i=sum; i<=100; i++) {
			sum += i;
		}
		
		System.out.println("~" + (i-1) + " �� : " + sum);

	}

}
