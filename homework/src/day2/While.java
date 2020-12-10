package day2;

import java.util.Scanner;

public class While {

	public static void main(String[] args) {

/*		//WhilePrintFrom1To10Example
		System.out.print("1���� 10 ������ ���ڸ� �Է����ּ���: ");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();

		System.out.println(i + "���� 10���� ���");
		
		while (i<=10) {
			System.out.println(i);
			i++;
		}
*/

/*		//WhileSumForm1To100Example
		System.out.print("1���� 100 ������ ���ڸ� �Է����ּ���: ");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();

		int sum = 0; 

		System.out.print(i);
		
		while(i<=100) {
			sum += i;
			i++;
		}
		
		System.out.println("~" + (i-1) + " �� : " + sum);
*/
		
		//WhileKeyControlExample
			boolean run = true;		
			int speed = 0;
			int keyCode = 0;
			
			while(run) {
				if(keyCode!=13 && keyCode!=10) {
					System.out.println("-----------------------------");
					System.out.println("1.���� | 2.���� | 3.����");
					System.out.println("-----------------------------");
					System.out.print("����: ");
				}
				Scanner sc = new Scanner(System.in);
				int i = sc.nextInt();
								
				if (i == 1) { //1
					speed++;
					System.out.println("���� �ӵ�=" + speed);
				} else if (i == 2) { //2
					speed--;
					System.out.println("���� �ӵ�=" + speed);
				} else if (i == 3) { //3
					run = false;
				}
			}	
			
			System.out.println("���α׷� ����");

	}

}
