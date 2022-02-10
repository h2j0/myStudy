import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2063_중간값찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 입력받는 수 배열 생성
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 배열 오름차순
		for (int i = 0; i < N - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < N; j++) {
				if (arr[j] < arr[minIdx])
					minIdx = j;
			}
			int tmp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = tmp;
		}
		
		System.out.println(arr[N/2]);

		// 배열 오름차순 정렬
//			Arrays.sort(arr);
//			System.out.println(Arrays.toString(arr));

	}
}