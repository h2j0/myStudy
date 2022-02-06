import java.util.Scanner;

public class BOJ1100 {
	public static void main(String[] args) {
		char[][] board = new char[8][8];
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			board[i] = sc.next().toCharArray();
		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] == 'F') {
					if ((i % 2 == 0) && (j % 2 == 0)) {
						cnt++;
					} else if ((i % 2 == 1) && (j % 2 == 1)) {
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
