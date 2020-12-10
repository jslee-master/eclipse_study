package day2;

import java.util.Scanner;

public class If {

	public static void main(String[] args) {
		
/*		//IfElseIfElseExample
		System.out.print("������ �Է����ּ���: ");
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		
		if(score>=90) {
			System.out.println("������ 100~90 �Դϴ�.");
			System.out.println("����� A �Դϴ�.");
		} else if(score>=80) {	
			System.out.println("������ 80~89 �Դϴ�.");
			System.out.println("����� B �Դϴ�.");
		} else if(score>=70) {
			System.out.println("������ 70~79 �Դϴ�.");
			System.out.println("����� C �Դϴ�.");
		} else {
			System.out.println("������ 70 �̸� �Դϴ�.");
			System.out.println("����� D �Դϴ�.");
		}
*/
		
/*		//IfDiceExample
		int num = (int)(Math.random()*6) + 1;
		
		if(num==1) {
			System.out.println("1���� ���Խ��ϴ�.");
		} else if(num==2) {	
			System.out.println("2���� ���Խ��ϴ�.");
		} else if(num==3) {
			System.out.println("3���� ���Խ��ϴ�.");
		} else if(num==4) {
			System.out.println("4���� ���Խ��ϴ�.");
		} else if(num==5) {
			System.out.println("5���� ���Խ��ϴ�.");
		} else {
			System.out.println("6���� ���Խ��ϴ�.");
		}
*/
		
		//SwitchExample
		System.out.print("�ֻ����� ���� Ƚ���� �Է����ּ���: ");
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		int i;
		
		for(i=1; i<=sum; i++) {
		int num = (int)(Math.random()*6) + 1;
		
		switch(num) {
			case 1:
				System.out.println("1���� ���Խ��ϴ�.");
				break;
			case 2:
				System.out.println("2���� ���Խ��ϴ�.");
				break;
			case 3:
				System.out.println("3���� ���Խ��ϴ�.");
				break;
			case 4:
				System.out.println("4���� ���Խ��ϴ�.");
				break;
			case 5:
				System.out.println("5���� ���Խ��ϴ�.");
				break;
			default:
				System.out.println("6���� ���Խ��ϴ�.");
				break;
			}
		}

	}
	
}
