

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_5365_의석이의세로로말해요 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/input5365.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int maxLen = 0;
		for (int tc = 1; tc <= T; tc++) {
			StringBuffer ans = new StringBuffer();
			char[][] board = new char[5][];
			for (int i = 0; i < 5; i++) {
				board[i] = sc.next().toCharArray();
				maxLen = Math.max(board[i].length, maxLen);
			} // 입력 끝

			for (int j = 0; j < maxLen; j++) {
				for (int i = 0; i < 5; i++) {
					try {
						ans.append(board[i][j]);
					} catch (Exception e) {

					}
				}
			}
			
			System.out.println("#" + tc + " " + ans);
			
		}

	}

}
