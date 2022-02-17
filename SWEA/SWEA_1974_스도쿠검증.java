import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1974_스도쿠검증 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// 스도쿠 입력
			int[][] board = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			// flag true로 초기화 
			boolean flag = true;

			// 행 검사
			r: for (int i = 0; i < 9; i++) {
				// 검사할 배열 생성
				int[] check = new int[10];
				// board의 값이 check의 인덱스
				// board값이 1부터 9까지 존재하는지 확인한다
				for (int j = 0; j < 9; j++) {
					check[board[i][j]]++;
				}
				// check함수의 값이 1이 아니라면 flag는 false가 된다
				for (int idx = 1; idx < 10; idx++) {
					if (check[idx] == 0) {
						flag = false;
						break r;
					}
				}
			}

			// 열 검사
			// flag가 true일 때만 동작한다
			if (flag) {

				c: for (int i = 0; i < 9; i++) {
					int[] check = new int[10];

					for (int j = 0; j < 9; j++) {
						check[board[j][i]]++;
					}
					// check함수의 값이 1이 아니라면 flag는 false가 된다
					for (int idx = 1; idx < 10; idx++) {
						if (check[idx] == 0) {
							flag = false;
							break c;
						}
					}
				}

			}
			// 작은 칸 검사 
			if (flag) {
				// 작은칸의 시작부분의 행, 열이 0부터 3씩 증가한다 
				x: for (int r = 0; r < 9; r += 3) {
					for (int c = 0; c < 9; c += 3) {
						int[] check = new int[10];
						
						// 작은 칸 체크
						for (int a = 0; a < 3; a++) {
							for (int b = 0; b < 3; b++) {
								check[board[r + a][c + b]]++;
							}
						}

						for (int idx = 1; idx < 10; idx++) {
							if (check[idx] == 0) {
								flag = false;
								break x;
							}
						}
					}
				}
			}
			// flag가 true면 1, false면 0 출력
			int res = flag ? 1 : 0;
			System.out.println("#" + tc + " " + res);
		}
	}
}