// 1097 바둑알 십자 뒤집기
package day04_codeup_220120;

import java.util.Scanner;

public class No1097 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[19][19];

		// 1. 초기 바둑판 입력받기
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				int stone = sc.nextInt();
				board[i][j] = stone;
			}
		}
		// 2. n번 x,y 좌표 입력 받기
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			// x행의 모든 열 값 바꾸기
			for (int j = 0; j < 19; j++) {
				if (board[x - 1][j] == 0) {
					board[x - 1][j] = 1;
				} else
					board[x - 1][j] = 0;
			}
			// y열의 모든 행 값 바꾸기
			for (int k = 0; k < 19; k++) {
				if (board[k][y - 1] == 0) {
					board[k][y - 1] = 1;
				} else
					board[k][y - 1] = 0;
			}

		}
		// 이중배열 이중 for문으로 출력하기
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
//		// 이중배열 for each문
//		for (int[] a : board) {
//			for (int b : a) {
//				System.out.print(b + " ");
//			}
//			System.out.println();
//		}

//		// webex
//		// 1을 0으로 & 0을 1로
//		int a = 1;
//		// 1. if else
//		if (a == 1)
//			a = 0;
//		else
//			a = 1;
//
//		// 2. 삼항연산자
//		a = a == 1 ? 0 : 1;
//		a = a != 1 ? 1 : 0;
//
//		// 3. a=1-a
//		// 직접 값을 대입해 볼 것
//		a = 1 - a;
//
//		// 4. 비트연산자 XOR ^
//		a = a ^ 1;
//		a ^= 1;

	}

}
