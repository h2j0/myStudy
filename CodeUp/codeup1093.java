// 이상한 출석 번호 부르기 1 - 빈도수 세기
package day04_codeup_220120;

import java.util.Arrays;
import java.util.Scanner;

public class No1093 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 학생 번호는 1~23
		
		// 0번은 없으니까 0~24의 배열을 만들고 나중에 0번을 빼고 1~23 출력
		int[] std = new int[24];

		// 입력받은 num(출석번호) 학생의 번호가 인덱스인 부분에
		// 값을 1씩 추가
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			std[num]++;
		}

		// 0번 부터가 아닌 1번부터 출력
		for (int i = 1; i < std.length; i++) {
			System.out.print(std[i] + " ");
		}
		
		// webex
		// 1번은 23개 방의 배열
		// 입력값에 -1해준 배열 방 값의 카운트
		
		// 2번은 0~24 
		// 인덱스와 1:1 매칭이 되게 작성 추천
		// -> 배열 한 칸은 메모리 낭비 심하지 않음 
		// 나중에 헷갈릴 수 도 있으니까 일대일 매칭 추천~!
		
		
	}
}
