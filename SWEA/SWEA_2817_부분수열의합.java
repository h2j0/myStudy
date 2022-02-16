package com.ssafy.webex;

import java.util.Scanner;

public class SWEA_2817_부분수열의합 {
	static int[] arr;
	static boolean[] sel;
	static int N;
	static int K;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트케이스 입력
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			sel = new boolean[N];
			arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			// cnt를 0으로 초기화하고
			cnt = 0;
			// powerset 함수를 거쳐서 cnt가 바뀐다
			powerset(0);
			System.out.println("#" + tc + " " + cnt);
		}
	}

	public static void powerset(int idx) {
		// 기본파트
		if (idx == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (sel[i]) {
					sum += arr[i];
				}
			}
			// sum이 K랑 같으면 cnt가 증가된다
			if (sum == K) {
				cnt++;
			}
		// 재귀파트
		} else {
			sel[idx] = true;
			powerset(idx + 1);
			sel[idx] = false;
			powerset(idx + 1);

		}

	}
}
