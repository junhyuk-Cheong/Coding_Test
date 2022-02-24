package feb22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10158 {

	public static int W; // 가로의 길이 // 2차원배열에서 col
	public static int H; // 세로의 길이 // 2차원배열에서 row
	public static int time;

	// 모서리 건드리면 그대로 돌아옴
	// 단 벽을
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		time = Integer.parseInt(br.readLine());
//		time = time % (2*W);
		// 입력완료

		/*
		 * 규칙 발견 오른쪽 벽에 부딪히면 x쪽으로 이동하는 방향만 바꾸어 주고 y는 그대로놓기 위쪽 벽에 부딪히면 x쪽으로 이동하는 방향은 냅두고
		 * y만 바꾸어주기 아래쪽 벽에 부딪히면 x쪽으로 이동하는 방향 냅두고 y쪽만 바꾸어주기 왼쪽 벽에 부딪히면 x쪽만 바꾸고 y 그대로 놓기
		 * 왼쪽 벽인지 오른쪽 벽인지 판단 잘해야함
		 */

		// 오른쪽벽에 부딪히면 0 위쪽이면 1 아래쪽이면 2 왼쪽이면 3

//		solve(p, q, 1, 1, 0);
		solve2(p, q, 1, 1, 0);
//		solve3(p, q, 1, 1, 0);
		
		int x = (p+time)%(2*W);
		int y = (q+time)%(2*H);
		
		x = W - Math.abs(W-x);
		y = H - Math.abs(H-y);
		
		System.out.println(x+" "+y);
	}
	
	public static void solve2(int r, int c, int dx, int dy, int cnt) {

		int nr = r;
		int nc = c;
		while (cnt != time) {
			nr = nr + dx;
			nc = nc + dy;

			// 먼저 모서리인지 물어보기
			if ((nr == W && nc == H) || (nr == 0 && nc == 0) || (nr == W && nc == 0) || (nr == 0 && nc == H)) { // 모서리에
				dx = -dx;
				dy = -dy;
			} else {
				if (nr == W) { // 오른쪽 벽에 부딪힘
					dx = -dx;
				} else if (nc == H) { // 위쪽 벽에 부딪힘
					dy = -dy;
				} else if (nc == 0) { // 아래쪽 벽에 부딪힘
					dy = -dy;
				} else if (nr == 0) { // 왼쪽 벽에 부딪힘
					dx = -dx;
				}
			}
			cnt++;
		}
		System.out.println(nr + " " + nc);
	}

	public static void solve(int r, int c, int dx, int dy, int cnt) {

		// 기저조건
		if (cnt == time) {
			System.out.println(r + " " + c);
			return;
		}

		int nr = r + dx;
		int nc = c + dy;

		// 먼저 모서리인지 물어보기
		if ((nr == W && nc == H) || (nr == 0 && nc == 0) || (nr == W && nc == 0) || (nr == 0 && nc == H)) { // 모서리에 부딪힘
//			System.out.println("모서리달성");
			dx = -dx;
			dy = -dy;
		} else {
			if (nr == W) { // 오른쪽 벽에 부딪힘
				dx = -dx;
			} else if (nc == H) { // 위쪽 벽에 부딪힘
				dy = -dy;
			} else if (nc == 0) { // 아래쪽 벽에 부딪힘
				dy = -dy;
			} else if (nr == 0) { // 왼쪽 벽에 부딪힘
				dx = -dx;
			}
		}

		solve(nr, nc, dx, dy, cnt + 1);

	}

}
