import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//1037 약수
public class BOJ1037 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		List<Integer> list = new ArrayList<>();
		int n = sc.nextInt();
		int[] arr = new int[n];
		int res;
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			arr[i] = a;
		}
		int max = arr[0];
		int min = arr[0];
		
		for (int i = 1; i < n; i++) {
			int x = arr[i];
			if (x > max) {
				max = x;
			}
		}

		for (int i = 1; i < n; i++) {
			int x = arr[i];
			if (x < min) {
				min = x;
			}
		}
		res = max * min;
		System.out.println(res);
	}

}
