package com.ssafy.webex;
import java.util.Scanner;

public class SWEA_1989_초심자의회문검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트케이스 입력
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String text = sc.next();

			// 입력받은 텍스트의 길이
			int l = text.length();
			int res = 1;

			// 테스트길이의 절반만큼 반복
			for (int i = 0; i < l / 2; i++) {
				// 앞 글자와 뒷글자가 다르다면 res=0이 되고 반복문 빠져나온다
				if (!(text.charAt(i) == text.charAt(l - 1 - i))) {
					res = 0;
					break;
				}
			}
			System.out.println("#" + tc + " " + res);
		}

	}
}
