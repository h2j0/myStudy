// 윤년 판별

package com.ssafy.codeup;

import java.util.Scanner;

public class no1166 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("연도 입력: ");

			int year = sc.nextInt();

			if (year == -1)
				break;

			if (year % 400 == 0)
				System.out.println("yes");

			else if (year % 100 != 0 && year % 4 == 0)
				System.out.println("yes");

			else
				System.out.println("no");

		}
	}
}
