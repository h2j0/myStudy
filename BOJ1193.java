import java.util.Scanner;

public class BOJ1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr1 = new int[n];
		int[] arr2 = new int[n];

		int a1 = 0;
		int b1 = 1;
		int x1 = 3;

		int oneCnt1 = 0;
		for (int i = 0; i < n; i++) {
			if (oneCnt1 == 1) {
				oneCnt1 = 0;
				a1 = 1;
			} else {
				a1 += b1;
				if (a1 == x1) {
					b1 *= -1;
					x1 += 2;
				} else if (a1 == 1) {
					b1 = 1;
					oneCnt1++;
				}
			}
			arr1[i] = a1;
		}
		
		int a2 = 0;
		int b2 = 1;
		int y = 2;
		
		int oneCnt2 = 1;
		for (int i = 0; i < n; i++) {
			if (oneCnt2 == 1) {
				oneCnt2 = 0;
				a2 = 1;
			} else {
				a2 += b2;
				if (a2 == y) {
					b2 *= -1;
					y += 2;
				} else if (a2 == 1) {
					b2 = 1;
					oneCnt2++;
				}
			}
			arr2[i] = a2;
		}
		System.out.printf("%d/%d",arr1[n-1],arr2[n-1]);

//		for (int i = 0; i < n; i++) {
//			System.out.println(arr2[i]);
//		}
	}

}
