// 두 주사위의 합

package com.ssafy.codeup;

import java.util.Scanner;

public class no1380 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		if (n <= 6) {
			for (int i = 1; i < n; i++) {
				System.out.println(i + " " + (n - i));
			}
		} else {
			for (int j = n - 6; j <= 6; j++) {
				System.out.println(j + " " + (n - j));
			}
		}
	}
}
