// 1098 설탕과자 뽑기
// 보드를 벗어나면 막대를 놓을 수 없게 코드 짜보기
// ** 막대가 겹치면??? + 추후 생각해보기
package day04_codeup_220120;

import java.util.Scanner;

public class No1098 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 보드 생성
		int w = sc.nextInt();
		int h = sc.nextInt();
		int[][] board = new int[w][h];

		// 가로방향 d=0, 세로방향 d=1일 때
		int[] dx = { 0, 1 };
		int[] dy = { 1, 0 };

		// n개의 막대에 대한 정보 받기
		int n = sc.nextInt();

		// n번의 l d x y 입력 받기
		for (int i = 0; i < n; i++) {
			int l = sc.nextInt();
			int d = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			// 입력은 1부터 들어오니까 배열로 넣을 땐 0부터
			// 헷갈릴까봐 new변수 nx, ny 선언
			int nx = x - 1;
			int ny = y - 1;

			// 값을 벗어나지 않으면 1로 넣기
			// 시작이 0보다 크고 막대의 끝 값이 w,h보다 작아야 함
			int xmax = nx + (dx[d] * (l - 1)); // 가로 방향 막대끝
			int ymax = ny + (dy[d] * (l - 1)); // 세로 방향 막대끝
			
			if (nx >= 0 && xmax <= w && ny >= 0 && ymax <= h) {
				// 시작 x,y좌표 자리는 1로 채우고
				board[nx][ny] = 1;

				// d 방향에 따라 움직이면서 l-1번 1로 채우기
				for (int j = 1; j < l; j++) {
					nx = nx + dx[d];
					ny = ny + dy[d];
					board[nx][ny] = 1;
				}
			}
		}
		// 출력
		for (int[] a : board) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}
}
