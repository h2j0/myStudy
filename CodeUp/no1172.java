// 세 수 정렬하기
package com.ssafy.codeup;

import java.util.Scanner;

public class no1172 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();

		if (num1 <= num2 && num1 <= num3) {
			if (num2 <= num3)
				System.out.printf("%d %d %d",num1,num2,num3);
			else if (num2 >= num3)
				System.out.printf("%d %d %d",num1,num3,num2);
		}
		else if (num2 <= num1 && num2 <= num3) {
			if (num1 <= num3)
				System.out.printf("%d %d %d",num2,num1,num3);
			else if (num1 >= num3)
				System.out.printf("%d %d %d",num2,num3,num1);
		}
		else if (num3 <= num2 && num3 <= num1) {
			if (num1 <= num2)
				System.out.printf("%d %d %d",num3,num1,num2);
			else if (num1 >= num2)
				System.out.printf("%d %d %d",num3,num2,num1);
		}
	}
}
