// 이상한 출석 번호 부르기 3

package day04_codeup_220120;

import java.util.Scanner;

public class No1095 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		// (1) 배열에 저장하고 찾기
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		// 1. 0번 인덱스 수를 큰 수로 초기화
		int min = arr[0];
		for (int i = 1; i < n; i++) {
			min = Math.min(min, arr[i]);
		}

//		// 2. min을 큰 수로 초기화
//		int min = 987654321;
//		
//		// (2) 입력 받으면서 바로 비교하기
//		for (int i = 0; i < n; i++) {
//			int x = sc.nextInt();
//			if (x < min) {
//				min = x;
//			}
//		}

		System.out.println(min);

	}
}
