import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225_암호생성기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/input1225.txt"));
		Scanner sc = new Scanner(System.in);

		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			sc.nextInt();// 테케 입력 버림
			// 큐 생성
			Queue<Integer> code = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				code.add(sc.nextInt());
			}
//			System.out.println(code);
			int num = 1;
			int minus = 0;
			// 뒤에 넣어주는 숫자가 0보다 작으면 반복문빠져나옴
			while (num > 0) {
				++minus;	// 빼주는 값을 증가시켜주는데 6이 되면 1이 된다
				if (minus == 6) {
					minus = 1;
				}
				num = code.remove() - minus; // 맨 앞 숫자에서 minus값 빼준다

				if (num < 0) {	// num이 음수이면 0으로 바꿔준다
					num = 0;
				}
				code.add(num); // 큐 뒤에 넣어준다
			}
			
			//출력
			System.out.print("#" + tc);
			for (int j = 0; j < 8; j++) {
				System.out.print(" " + code.remove());
			}
			System.out.println();
		}
	}
}
