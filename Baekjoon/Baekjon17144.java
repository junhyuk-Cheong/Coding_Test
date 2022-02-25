package feb25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjon17144 {
	// 공기청정기는 항상 1번 열에 설치되어있고 크기는 두행만큼을 차지한다.
	// 공기청정기가 설치되어 있지 않은 칸에는 미세먼지가 있고 미세먼지의 양은 Ar,c이다.

	static int R, C, T; // row, col, t 초
	static int[][] map;
	static boolean[][] visitable;
	static int x1, y1, x2, y2;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상, 하, 좌, 우 순

	static int[][] copymap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		copymap = new int[R][C];
		visitable = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] != 0 && map[i][j] != -1)
					visitable[i][j] = true;

				if (map[i][j] == -1) {
					x2 = i;
					y2 = j;
				}
			}
		}
		// 입력완료
		x1 = x2 - 1;
		y1 = y2;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				copymap[i][j] = map[i][j];
			}
		}
		// 카피맵에 복사
		////////////////////////////////////////////////////////////

		for (int t = 0; t < T; t++) {
			solve();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = copymap[i][j];
				}
			}
			aircleaner();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					copymap[i][j] = map[i][j];
				}
			}
		}

		////////////////////////////////////////////////////////////

		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1)
					continue;
				result += map[i][j];
			}
		}
		System.out.println(result);

	}

	// 미세먼지가 확산이 된다.
	// 주의할점이 이미 확산된 부분도 확산 시키려고 하지 말것.
	static void solve() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0 || map[i][j] == -1)
					continue;

				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nr = i + deltas[k][0];
					int nc = j + deltas[k][1];

					if (nr == x1 && nc == y1)
						continue;
					if (nr == x2 && nc == y2)
						continue;

					if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
						copymap[nr][nc] += map[i][j] / 5;
						cnt++;
					}
				}
				copymap[i][j] -= cnt * (map[i][j] / 5);
			}
		}
//		map[x1][y1] = -1;
//		map[x2][y2] = -1;
		copymap[x1][y1] = -1;
		copymap[x2][y2] = -1;
	} // <!--solve-->

	static void aircleaner() {

		// 윗쪽 반시계 회전
		// 1. 먼저 공기청정기로 들어오는 거부터 처리한다.
		// 열은 고정되어 있고 행만 움직인다.
		for (int i = 1; i < R; i++) {
			if ((x1 - i - 1) < 0)
				break;
			map[x1 - i][y1] = map[x1 - i - 1][y1];
		}

		// 2. 윗쪽 변을 처리한다. 행 고정 열만 움직임
		for (int j = 0; j < C; j++) {
			if ((j + 1) >= C)
				break;
			map[0][0 + j] = map[0][0 + j + 1];
		}

		// 3. 오른쪽 변을 처리한다. 열 고정 행만 움직임
		for (int i = 0; i < R; i++) {
			if ((1 + i) > x1)
				break;
			map[0 + i][C - 1] = map[0 + 1 + i][C - 1];
		}

		// 4. 아래쪽 변을 처리한다. 행 고정 열만 움직임
		for (int j = 0; j < C; j++) {
			if (C - 1 - (j + 1) <= 0)
				break;
			map[x1][C - 1 - j] = map[x1][C - 1 - (j + 1)];
		}
		map[x1][y1 + 1] = 0;

		// 아래쪽 반시계 회전
		// 1. 왼쪽 벽을 처리한다. 열 고정 행 움직임
		for (int i = 1; i < R; i++) {
			if ((x2 + i + 1) > R - 1)
				break;
			map[x2 + i][0] = map[x2 + i + 1][0];
		}

		// 2. 아래쪽 벽을 처리한다. 행 고정 열만 움직임
		for (int j = 0; j < C; j++) {
			if ((0 + j + 1) > C - 1)
				break;
			map[R - 1][0 + j] = map[R - 1][0 + j + 1];
		}

		// 3. 오른쪽 벽을 처리한다. 열 고정 행만 움직임
		for (int i = 0; i < R; i++) {
			if ((R - 1 - (i + 1)) < x2)
				break;
			map[R - 1 - i][C - 1] = map[R - 1 - (i + 1)][C - 1];
		}

		// 4. 위쪽 벽을 처리한다. 행 고정 열만 움직임
		for (int j = 0; j < C; j++) {

			if ((C - 1 - (j + 1)) <= 0)
				break;
			map[x2][C - 1 - j] = map[x2][C - 1 - (j + 1)];
		}
		map[x2][y2 + 1] = 0;
		/// !!!!!!!!!!!! 무조건 공기청정기에서 나오는 바람도 0처리 해야함
	}

}
