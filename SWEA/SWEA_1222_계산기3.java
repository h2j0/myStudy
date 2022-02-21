package com.ssafy.webex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1222_계산기3 {
	static int len; // 문자열 길이 입력
	static Stack<Character> tmp; // 중위식 -> 후위식 만들 때 스택
	static Stack<Integer> calcStack; // 후위식 계산할 때 스택
	static ArrayList<Character> postfix; // 후위식

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10; // 테스트케이스 수

		for (int tc = 1; tc <= T; tc++) { // 테스트케이스만큼 반복
			// 테스트케이스 증가할 때 마다 초기화
			len = sc.nextInt();
			tmp = new Stack<>();
			postfix = new ArrayList<>();
			calcStack = new Stack<>();

			sc.nextLine();
			// 중위식을 쪼개서 char배열로 만든다
			char[] infix = sc.nextLine().toCharArray();
			// Infix -> Postfix
			inToPost(infix);
			int result = calculate(postfix);
			System.out.println("#" + tc + " " + result);
		}
	}

// 1. 중위식 -> 후위식 만들기
//	 1-1 피연산자 : 바로 후위식 배열에 넣기
//	 1-2 연산자 : (1) 스택이 비어있다면 바로 넣기
// 			  	  (2) 스택이 비어있지 않다면 
//					  스택의 top을 확인해 나보다 우선순위 작을 때까지 스택에서 값을 빼내고 나를 넣는다 (동급도 뺀다)
//				  (3) 괄호의 우선순위 : 밖에서는 제일 높고 스택 안에서는 제일 낮다
//					  ( -> 무조건 스택으로 넣는다
//					  ) -> 스택에 안넣고 스택 안에 ( 이 나올 때까지 스택에서 꺼낸다
	public static void inToPost(char[] infix) {
		int i = 0;
		while (i < len) {
			switch (infix[i]) {
			// 연산자일 때
			case '(': // 열림은 무조건 넣는다
				tmp.push(infix[i]);
				break;
			case ')': // 닫힘은 스택에 넣지 않고 열림 나올 때까지 스택 pop
				while (tmp.peek() != '(') {
					postfix.add(tmp.pop());
				}
				tmp.pop(); // 열림 날린다
				break;
			case '*':
				if (tmp.isEmpty()) // (1) 스택이 비어있다면 바로 넣기
					tmp.push(infix[i]);
				else { // (2) 스택이 비어있지 않다면
					if (tmp.peek() == '*') { // tmp의 top이 + 거나 * 라면
						postfix.add(tmp.pop()); // 후위식에 넣어준다
						tmp.push(infix[i]); // 자기 자신 넣어준다
					}
				}
				break;
			case '+':
				if (tmp.isEmpty()) // (1) 스택이 비어있다면 바로 넣기
					tmp.push(infix[i]);
				else { // (2) 스택이 비어있지 않다면
					while (tmp.peek() == '+' || tmp.peek() == '*') { // tmp의 top이 + 라면
						postfix.add(tmp.pop()); // 후위식에 넣어준다
					}
					tmp.push(infix[i]); // 자기 자신 넣어준다
				}
				break;
			// 피연산자일 때(0~9) : 후위식에 넣어준다
			default:
				postfix.add(infix[i]);
				break;
			}
			++i;
		}

	}

// 2. 후위식 계산하기
//	 2-1 피연산자 : 스택에 넣기
//	 2-2 연산자 : 필요한 피연산자 뽑아서 계산 후 다시 스택에 넣기 (순서 주의!)
	public static int calculate(ArrayList<Character> post) {
		int i = 0;

		while (i < post.size()) {
			int a = 0;
			int b = 0;
			switch (post.get(i)) {
			// 연산자일 때 피연산자를 뽑아서 순서에 유의해서 계산해주고 그 값을 스택에 넣는다
			case '+':
				a = calcStack.pop();
				b = calcStack.pop();
				calcStack.push(b + a);
				break;
			case '*':
				a = calcStack.pop();
				b = calcStack.pop();
				calcStack.push(b * a);
				break;
			// 피연산자일 때 스택에 넣어주는데 postfix는 char형이니까 '0' 빼주면서 int로 넣어준다
			default:
				calcStack.push(post.get(i) - '0');
				break;
			}
			++i;
		}

		return calcStack.peek();
//		if (post.get(i-2) == '*') {
//			return (calcStack.pop() * calcStack.pop());
//		} else
//			return (calcStack.pop() + calcStack.pop());
	}

}
