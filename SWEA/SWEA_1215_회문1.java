import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1215_회문1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt(); // 검색할 단어 길이
			char[][] board = new char[8][8];
			for (int i = 0; i < 8; i++) {
				board[i] = sc.next().toCharArray();
			}

			// 한 행/열마다 검색가능 횟수
			int move = 8 - n + 1;

			boolean flag;
			int cnt = 0;

			// 행 검사
			for (int i = 0; i < 8; i++) { // 행 개수
				for (int j = 0; j < move; j++) { // 검색 단어의 첫 글자의 검색 가능 길이는 move
					flag = true;
					for (int k = 0; k < n / 2; k++) { // 절반만 회문인지 비교한다
						if (board[i][j + k] != board[i][j + n - 1 - k]) {
							// [j+k] : j값에서 k만큼 증가
							// [j+n-1-k] : j+n-1에서 k만큼 감소
							flag = false;
							break;
						}

					}
					// flag=false를 거치지 않을 때만 cnt가 증가된다
					cnt += flag ? 1 : 0;
				}
			}
			// 열 검사 - 행이랑 같은 과정을 거친다
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < move; j++) {
					flag = true;
					for (int k = 0; k < n / 2; k++) {
						if (board[k + j][i] != board[j + n - 1 - k][i]) {
							flag = false;
							break;
						}
					}
					cnt += flag ? 1 : 0;
				}
			}

			System.out.println("#" + tc + " " + cnt);
		}
	}
}
