package com.ssafy.webex;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218_괄호짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			// 스택 생성
			Stack<Character> stack = new Stack<>();
			// 입력되는 괄호들을 하나씩 char 배열에 넣는다
			char[] array = sc.next().toCharArray();

			int i = 0;
			while (i < n) {
				// 스택이 비어있다면 push한다
				if (stack.isEmpty()) {
					stack.push(array[i]);
				}
				// 스택이 비어있지 않다면
				else {
					// if 스택의 top이랑 다음에 들어오려는 괄호가 매칭되면 pop
					// else 매칭되지 않는다면 push
					if (stack.peek() == '(' && array[i] == ')') {
						stack.pop();

					} else if (stack.peek() == '[' && array[i] == ']') {
						stack.pop();

					} else if (stack.peek() == '{' && array[i] == '}') {
						stack.pop();

					} else if (stack.peek() == '<' && array[i] == '>') {
						stack.pop();

					} else {
						stack.push(array[i]);
					}
				}
				i++;
			}
			// 반복문이 끝나고 stack의 사이즈가 0이라면 1을 출력
			int res = stack.size() == 0 ? 1 : 0;
			System.out.println("#" + tc + " " + res);

		}

	}

}
