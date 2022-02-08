import java.util.Scanner;

public class BOJ1233 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int[] numArr = new int[a + b + c + 1];
		// 배열 인덱스 번호가 세 주사위의 합
		// 배열의 값이 빈도 나온 횟수
		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= b; j++) {
				for (int k = 1; k <= c; k++) {
					numArr[i + j + k]++;
				}
			}
		}
		
		int max = 0;
		for (int i : numArr) {
			max = Math.max(max, i);
		}

//		System.out.println(max);
		
		for(int i=0;i<numArr.length;i++) {
			if(numArr[i]==max) {
				System.out.println(i);
				break;
				
			}
		}
		
	}

}
