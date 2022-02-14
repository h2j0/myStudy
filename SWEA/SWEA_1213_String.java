import java.util.Scanner;

public class SWEA_1213_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트케이스
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			int t = sc.nextInt(); // 테스트케이스 입력
			char[] find = sc.next().toCharArray(); // 찾으려는 문자열
			int flen = find.length;
			char[] text = sc.next().toCharArray(); // 검색하는 문자열
			int tlen = text.length;

			int cnt = 0;	// 카운트 0으로 초기화 for 문을 돌면서 true일 때 +1
			boolean flag;	
			for (int i = 0; i < tlen - flen + 1; i++) { 
				flag = true;
				for (int j = 0; j < flen; j++) {	
					if (text[i + j] != find[j]) { 	// 찾으려는 문자열과 검색 문자열이 다르면
						flag = false;				// false
					}
				}
				cnt += flag ? 1 : 0;	// flag가 true일 때 cnt + flag
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
