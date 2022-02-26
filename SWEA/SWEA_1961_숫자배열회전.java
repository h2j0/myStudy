import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_1961_숫자배열회전 {
	static int[][] origin;
	static int n;
	static int[][] arr1;
	static int[][] arr2;
	
	static int[][] arr3;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/input1961.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테케
		for (int tc = 1; tc <= T; tc++) {

			n = sc.nextInt(); // 배열 사이즈 입력
			origin = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					origin[i][j] = sc.nextInt();
				}
			} // 입력 완

			// 출력을 위해서 회전한 배열들을 3차원 배열에 한 번에 담아준다
			int[][][] result = new int[3][n][n];
			arr1 = new int[n][n];
			arr2 = new int[n][n];
			arr3 = new int[n][n];
			turn(origin, arr1); // 원본을 90도 회전 -> arr1
			turn(arr1, arr2); // arr1을 90도 회전 -> arr2
			turn(arr2, arr3); // arr2를 90도 회전 -> arr3
			// 삼중배열에 하나씩 추가
			result[0] = arr1;
			result[1] = arr2;
			result[2] = arr3;

			// 출력
			// 첫 째줄이 0,0,0 - 0,0,1 - 0,0,2 띄고 1,0,0 - 1,0,1 - 1,0,2 띄고 2,0,0 - 2,0,1 - 2,0,2 
			// 이런식으로 출력돼서 인덱스를 이렇게,,
			System.out.println("#" + tc);
			for (int j = 0; j < n; j++) {
				for (int i = 0; i < 3; i++) {
					for (int k = 0; k < n; k++) {
						System.out.print(result[i][j][k]);
					}
					System.out.print(" ");
				}
				System.out.println();
			}

		}

	}

	// 90도 회전하는 함수
	public static void turn(int[][] origin, int[][] arr) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = origin[n - 1 - j][i];
			}
		}
	}
}
