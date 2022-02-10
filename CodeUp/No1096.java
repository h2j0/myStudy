// 1096 바둑판에 흰돌 놓기
package day04_codeup_220120;

import java.util.Scanner;

public class No1096 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] board = new int[19][19];
		int n = sc.nextInt();

		// webex
		// 문제에서 x,y좌표 1~19까지
		// 입력으로 주는 인덱스가 1~19
		// 컴퓨터는 0~ 하는데??
		// 1.배열[19][19] 입력좌표 1씩깎아
		// 2.배열[20][20] -> 메모리낭비? 이정도는 버려도 된다 
		
		// n개의 int int 받기
		// 입력은 1부터 들어오기 때문에
		// 입력 1 1 -> 배열 0 0로 넣어줘야 해서 a-1, b-1
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			board[a - 1][b - 1] = 1;
		}
		
		// 1. 이중배열 for each
		for (int[] x : board) {
			for (int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
		//2. 이중배열 for문
		//3. 이중배열 array.tostring
	}

}
