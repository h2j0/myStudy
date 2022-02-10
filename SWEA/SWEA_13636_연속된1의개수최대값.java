import java.util.Arrays;
import java.util.Scanner;

public class SWEA_13636_연속된1의개수최대값 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 연속되는 숫자 뜯어서 배열로 만들기
			// 그런데 char값으로 저장된다
			int len = sc.nextInt();
			char[] charArr = sc.next().toCharArray();

			// char값을 int 숫자로 바꿔주기위해서 '0'을 빼준다
			// ex) '1'-'0' = 1
			int[] intArr = new int[len];
			for (int i = 0; i < len; i++) {
				intArr[i] = charArr[i] - '0';
			}

			int ans = 0;
			int maxAns = 0;
			// idx가 0번부터 마지막에서 2번째까지 증가
			for (int idx = 0; idx < len - 1; idx++) {
				// 자신의 값과 다음 값의 곱이 1이면 ans는 증가
				if (intArr[idx] * intArr[idx + 1] == 1) {
					ans++;
				} else
					ans = 0;

				// max값 구하기
				if (ans > maxAns) {
					maxAns = ans;
				}
			}
			// maxAns+1인 이유 : 자기 자신도 1인데 위에서 더해지지 않고 여기서 더함
			System.out.println("#" + tc + " " + (maxAns + 1));
		}

	}
}
