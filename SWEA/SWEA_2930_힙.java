package com.ssafy.webex;
//삽입
// 사이즈를 키우고 힙의 해당 사이즈 인덱스에 삽입 (마지막 자리에 들어간다)
// (규칙에 맞게 이동)
// -> 나의 부모가 나보다 작을때까지 swap
// -> 나의 부모가 나보다 크거나 루트에 도달하면 break

// 삭제
// 루트 위치 무조건 삭제
// 만약 사이즈가 0인데 삭제 -> ans = -1 break;
// 마지막 애를 루트로 옮겨
// (규칙에 맞게 이동)
// -> 나의 자식이 나보다 크면 더 큰 자식이랑 swap

import java.util.Scanner;

public class SWEA_2930_힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			int ans = 0;
			int[] heap = new int[1000000];
			int size = 0;

			// 연산 수
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				// 삽입
				if (x == 1) {
					heap[++size] = sc.nextInt();
					// 나의 부모가 나보다 작으면 swap
					int pos = size;
					while (pos > 1 && heap[pos] > heap[pos / 2]) {
						int temp = heap[pos];
						heap[pos] = heap[pos / 2];
						heap[pos / 2] = temp;
						pos = pos / 2;
					}

				} // 삭제
				else if (x == 2) {
					if (size == 0) {
						sb.append(-1).append(" ");
					} else {
						sb.append(heap[1]).append(" ");
						heap[1] = heap[size];
						size--;
						int pos = 1;
						int left = pos * 2;
						int right = pos * 2 + 1;
						while (right <= size && (heap[pos] < heap[left] || heap[pos] < heap[right])) {
							if (heap[left] > heap[right]) {
								int temp = heap[pos];
								heap[pos] = heap[left];
								heap[left] = temp;
								pos = left;

							} else if (heap[left] < heap[right]) {
								int temp = heap[pos];
								heap[pos] = heap[right];
								heap[right] = temp;
								pos = right;
							}
							left = pos * 2;
							right = pos * 2 + 1;
						}

					}

				}

			}
			System.out.println("#" + tc + " " + sb);
		}

	}
}
