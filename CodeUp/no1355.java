// 삼각형 출력 3
package com.ssafy.codeup;

import java.util.Scanner;

public class no1355 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int k=0;k<n-i;k++) {
				System.out.print('*');
			}
			System.out.println();
		}

	}

}
