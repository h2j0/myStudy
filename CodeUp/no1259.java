// 1부터 N까지 중 짝수의 합 구하기

package com.ssafy.codeup;

import java.util.Scanner;

public class no1259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int sum = 0;
		
		for(int i=2;i<=n;i+=2) {
			sum += i;
		}
		System.out.println(sum);
	}
}
