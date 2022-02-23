import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_1230_암호문3 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/input1230.txt"));
		Scanner sc = new Scanner(System.in);

		int T = 10; // 테스트케이스
		for (int tc = 1; tc <= T; tc++) {
			int oriLen = sc.nextInt();// 원본 암호문의 길이
			LinkedList<String> origin = new LinkedList<>();
			for (int i = 0; i < oriLen; i++) {
				origin.add(sc.next());
			} // 원본 암호문 입력
			int commNum = sc.nextInt(); // 명령어 개수

			// 명령어 개수만큼 암호문 수정이 일어난다 발생
			for (int i = 0; i < commNum; i++) {
				switch (sc.next()) {
				case "I": 
					int insPos = sc.nextInt(); // 추가할 position
					int insNum = sc.nextInt(); // 추가할 개수
					// 해당 포지션부터 입력되는 명령문이 추가된다
					for (int j = insPos; j < insPos + insNum; j++) {
						origin.add(j, sc.next());
					}
					break;
				case "D": 
					int delPos = sc.nextInt(); // 제거할 position
					int delNum = sc.nextInt(); // 제거할 개수
					for (int j = delPos; j < delPos + delNum; j++) {
						origin.remove(j);
					}
					break;
				case "A": 
					int addNum=sc.nextInt(); // 추가할 개수
					// 입력되는 명령문이 뒤에 추가된다
					for (int j = 0; j < addNum; j++) {
						origin.add(sc.next());
					}
					break;
				}
			}

			// 앞에 10개만 출력
			System.out.print("#" + tc);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + origin.get(i));
			}
			System.out.println();

		}
	}
}
