// 1411 빠진카드

package day04_codeup_220120;

import java.util.Scanner;

public class No1411 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 카드 수 입력
		int n = sc.nextInt();

		// 배열은 0부터 시작하니까 카드max 방을 만들어주기 위해 int[n+1]
		int[] card = new int[n + 1];

		// 카드 입력 횟수는 카드수-1
		for (int i = 1; i < n; i++) {
			int num = sc.nextInt();
			card[num] = 1;
		}
		for(int i=1;i<=n;i++) {
			if (card[i]==0) {
				System.out.println(i);
			}			
		}
	}
}
