// 이상한 출석 번호 부르기 2 - 뒤집기
package day04_codeup_220120;

import java.util.Scanner;

public class No1094 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 들어오는 수 만큼 배열 방 만들기
		int[] arr = new int[n];
		
		// 입력되는 수 배열로 저장
		for (int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		// 마지막 인덱스 = 배열.length()-1
		// (1) 거꾸로 arr[n-1] ~ arr[0] 출력
		for(int i=n-1;i>=0;i--) {
			System.out.print(arr[i]+" ");
		}
		
		// webex
//		// (2) 위와 반대로 반복되는 변수가 증가하는 코드
//		for(int i=0;i<n;i++) {
//			System.out.print(arr[n-1-i]+" ");
//			// n-i-1은 추천하지 않음, 직관적이지 못하다
//		}

	}

}
