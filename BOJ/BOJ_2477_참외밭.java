import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2477_참외밭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mul = sc.nextInt();
		int[] arr = new int[10]; // 앞, 뒤 2칸의 여유를 주기 위해 10칸 만든다

		// 밭 정보 입력받음
		// 입력 받으면서 최대값이랑 그 인덱스 저장하기
		int max = 0;
		int maxIdx = 0;
		for (int i = 0; i < 6; i++) {
			sc.nextInt();
			arr[i + 2] = sc.nextInt();
			max = Math.max(max, arr[i + 2]);
			if (arr[i + 2] == max) {
				maxIdx = i + 2;
			}
		}
		// 인덱스 오류를 고려해 실제 배열의 앞 뒤 2칸에
		// 수가 반복되도록? 값을 넣어준다
		arr[0] = arr[6];
		arr[1] = arr[7];
		arr[8] = arr[2];
		arr[9] = arr[3];
		System.out.println(Arrays.toString(arr));
		int area = mul * (arr[maxIdx - 1] * arr[maxIdx - 2] + arr[maxIdx + 1] * arr[maxIdx + 2]);
		System.out.println(area);
	}
}
