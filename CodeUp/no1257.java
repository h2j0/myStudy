// 두 수 사이의 홀수 출력하기
package com.ssafy.codeup;

import java.util.Scanner;

public class no1257 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		if (a % 2 == 0) {
			for (int i = a+1; i <= b; i += 2) {
				System.out.print(i+" ");
			}
		}else {
			for (int i = a; i <= b; i += 2) {
				System.out.print(i+" ");
			}
		}

	}
}
