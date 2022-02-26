import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_1873_상호의배틀필드 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/input1873.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테케
		for (int tc = 1; tc <= T; tc++) {
			int h = sc.nextInt(); // 높이 : 맵 행의 개수
			int w = sc.nextInt(); // 너비 : 맵 열의 개수
			char[][] map = new char[h][w];
			char[] tmp; // 입력받는 맵 정보 한 줄씩 잠깐 담아놓을래
			char nowPos = 0; // 맵 입력받으면서 ^ v < > 찾으면 여기에 저장해 (전차 현재 위치)
			int r = 0; // 현재 위치 행
			int c = 0; // 현재 위치 열

			// 지도 정보 입력
			for (int i = 0; i < h; i++) {
				tmp = sc.next().toCharArray();
				for (int j = 0; j < w; j++) {
					char mapdata = tmp[j];
					// 입력 받으면서 현재위치 바로 확인
					if (mapdata == '^' || mapdata == 'v' || mapdata == '<' || mapdata == '>') {
						nowPos = mapdata;
						r = i;
						c = j;
					}
					map[i] = tmp;
				}
			} // 지도 생성 완

			// 상하좌우 방향을 설정해보자
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };

			// 위에서 현재위치와 방향
			int ndr = 0; // 바라보고 있는 다음 행
			int ndc = 0; // 바라보고 있는 다음 열
			switch (nowPos) {
			case '^':
				ndr = dr[0];
				ndc = dc[0];
				break;
			case 'v':
				ndr = dr[1];
				ndc = dc[1];
				break;
			case '<':
				ndr = dr[2];
				ndc = dc[2];
				break;
			case '>':
				ndr = dr[3];
				ndc = dc[3];
				break;
			}

			int n = sc.nextInt(); // 컨트롤 횟수
			char[] control = sc.next().toCharArray();// 컨트롤 char 배열로

			// n번 반복해
			for (int i = 0; i < n; i++) {
				int nr = r; // 탐색하는 위치 행
				int nc = c; // 탐색하는 위치 열
				switch (control[i]) {
				case 'S':
					while (true) { // 포탄이 지도 안에 있을 때까지
						nr += ndr;	// 쳐다보는 방향으로 탐색해
						nc += ndc;

						if (nr < 0 || nc < 0 || nr > h - 1 || nc > w - 1) { // 범위 벗어나면 나가
							break;
						} else if (map[nr][nc] == '*') { // * 을 만나면
							map[nr][nc] = '.'; // . 으로 바꾸고 나가
							break;
						} else if (map[nr][nc] == '#') // # 만나면 바로 나가
							break;
					}
					break;
				case 'U': // . 평지일 때만 갈 수있다
					ndr = dr[0];	// 쳐다보는 방향 바꿔
					ndc = dc[0];
					map[r][c] = '^'; 
					nr += ndr;		// 쳐다보는 방향으로 탐색해봐
					nc += ndc;	
					// 제한 범위 내이고 움직이려는 칸이 평지이면
					if (nr >= 0 && nc >= 0 && nr <= h - 1 && nc <= w - 1 && map[nr][nc] == '.') {
						map[r][c] = '.';
						map[nr][nc] = '^';
						r = nr;	// 그 칸을 현재 위치로 설정해
						c = nc;
					}
					break;
				case 'D':
					ndr = dr[1];
					ndc = dc[1];
					nr += ndr;
					nc += ndc;
					map[r][c] = 'v';
					if (nr >= 0 && nc >= 0 && nr <= h - 1 && nc <= w - 1 && map[nr][nc] == '.') {
						map[r][c] = '.';
						map[nr][nc] = 'v';
						r = nr;
						c = nc;
					}
					break;
				case 'L':
					ndr = dr[2];
					ndc = dc[2];
					nr += ndr;
					nc += ndc;
					map[r][c] = '<';
					if (nr >= 0 && nc >= 0 && nr <= h - 1 && nc <= w - 1 && map[nr][nc] == '.') {
						map[r][c] = '.';
						map[nr][nc] = '<';
						r = nr;
						c = nc;
					}
					break;
				case 'R':
					ndr = dr[3];
					ndc = dc[3];
					nr += ndr;
					nc += ndc;
					map[r][c] = '>';
					if (nr >= 0 && nc >= 0 && nr <= h - 1 && nc <= w - 1 && map[nr][nc] == '.') {
						map[r][c] = '.';
						map[nr][nc] = '>';
						r = nr;
						c = nc;
					}
					break;
				}
			}
			// 출력
			System.out.print("#" + tc+" ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}
	}
}