// 소수 판별
package com.ssafy.codeup;

import java.util.Scanner;

public class no1274 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		String p = "prime";

		int i = 2;

		while (num > i) {
			if (num % i == 0) {
				p = "not prime";
				break;
			}
			i++;
		}
		System.out.println(p);

	}

}
