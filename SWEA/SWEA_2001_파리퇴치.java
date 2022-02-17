import java.util.Scanner;

public class SWEA_2001_파리퇴치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트케이스 입력
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			// 배열 생성 후 입력받음
			int[][] board = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					board[i][j] = sc.nextInt();
				}
			}
			// 파리채 
			// 파리채가 이동 가능한 횟수는 N-M+1
			int max =0;
			// 4주우 포문 헷갈리면 2중 포문 함수로 빼라? 
			for(int i=0;i<N-M+1;i++) {
				for(int j=0;j<N-M+1;j++) {
					// 파리채(MxM)의 한 칸당 잡을 수 있는 파리 수를 더해준다
					int sum =0;
					for(int a = 0;a<M;a++) {
						for(int b= 0;b<M;b++) {
							sum+=board[i+a][j+b];
						}
					}
                    // sum중에 max값을 구한다
					max = Math.max(sum, max);
				}
			}
            // 출력
			System.out.printf("#%d %d",tc,max);
			System.out.println();
		}
	}
}
