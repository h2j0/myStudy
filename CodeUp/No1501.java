// 2차원 배열 채우기 1
package day04_codeup_220120;

import java.util.Scanner;

public class No1501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];

		int x = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = x;
				System.out.print(x+" ");
				x++;
			}
			System.out.println();
		}
		
	}

}
