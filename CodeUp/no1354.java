// 삼각형 출력 2
package com.ssafy.codeup;

import java.util.Scanner;

public class no1354 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}
