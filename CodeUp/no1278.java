// 자릿수 계산

package com.ssafy.codeup;

import java.util.Scanner;

public class no1278 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int jari=1; 
		
		while(n/10!=0) {
			
			n /= 10;
			++jari;
			
		}
		
		System.out.println(jari);
		
	}
}
