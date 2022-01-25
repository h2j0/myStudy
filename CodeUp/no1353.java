// 삼각형 출력 1

package com.ssafy.codeup;

import java.util.Scanner;

public class no1353 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i=1;i<=n;i++) {
			for (int j=1;j<=i;j++) {
				System.out.print("*");}
			System.out.print('\n');
		}
				
	}
}
