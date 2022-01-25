// 최대값 구하기
package com.ssafy.codeup;

import java.util.Scanner;

public class no1271 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int max = 0;
		for (int i=0;i<a;i++) {
			
			int x = sc.nextInt();
			if (max<x)
				max = x;			
		}
		System.out.println(max);
		
		//배열 풀이
//		int[] arr = new int[n];
//		for (int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
//
//		int max = arr[0];
//		int temp = 0;
//		for (int i = 1; i < n; i++) {
//			if (max < arr[i]) {
//				temp = max;
//				max = arr[i];
//				arr[i] = temp;
//			}
//		}
//		System.out.println(max);

	}

}
