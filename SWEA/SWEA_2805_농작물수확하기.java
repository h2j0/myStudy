import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2805_농작물수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테케 입력
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// 농장 크기 입력
			int n = sc.nextInt();
			
			// 농장 만들기
			int[][] board = new int[n][n];
			char[][] tmp = new char[n][n];
			// int 배열로 만들어주기 위해서는 
			// 연속적으로 들어오는 숫자를 char 배열로 한 글자씩 입력받고
			for (int i = 0; i < n; i++) {
				tmp[i] = sc.next().toCharArray();
			}

			// 값을 int로 만들어준다
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					board[i][j] = tmp[i][j] - '0';
				}
			}

			// sum 0으로 초기화 
			int sum = 0;
			for (int i = 0; i < n; i++) {
				// 가운데행까지는 가운데열-i 부터 가운데열 +i까지 수확
				if (i <= n / 2) {
					for (int j = -i; j <= i; j++)
						sum += board[i][n / 2 + j];
				} else {
					// 가운데행 이후부터는 가운데열-(길이-1-i) 부터 가운데열+(길이-1-i)까지 수확
					for (int j = -(n - 1 - i); j <= (n - 1 - i); j++)
						sum += board[i][n / 2 + j];
				}

			}
			// 츨력
			System.out.println("#" + tc + " " + sum);
		}
	}
}
