package feb25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2669 {
	// 4개의 직사각형 & 밑변은 모두 가로축에 평행함
	// 조합으로 비교하면 됨

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static class rect {
		Point ne, se, sw, nw;

		public rect(Point ne, Point se, Point sw, Point nw) {
			this.ne = ne;
			this.se = se;
			this.sw = sw;
			this.nw = nw;
		}
	}

	public static rect[] selected = new rect[2];
	public static rect[] rectarr = new rect[4];

	public static int[][] map = new int[101][101];
	public static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

//		rect[] rectarr = new rect[4];
//		int result = 0;

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			// 사각형의 왼쪽 아래 꼭짓점
			Point sw = new Point(x1, y1);

			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			// 사각형의 오른쪽 위 꼭짓점
			Point ne = new Point(x2, y2);
			Point se = new Point(x2, y1);
			Point nw = new Point(x1, y2);

			rectarr[i] = new rect(ne, se, sw, nw);
			
//			result += (x2 - x1) * (y2 - y1);
			
			for (int j = y1; j < y2; j++) {
				for (int j2 = x1; j2 < x2 ; j2++) {
					map[j][j2] = 1;
				}
			}
			
			
			
		}
		// 랙탱글 배열 설정 완료
//		System.out.println(result);
		
		
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <=100;  j++) {
				if(map[i][j] == 1) {
					result++;
				}
				
			}
			
		}
		
		for (int i = 0; i < 101; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
		
		
		System.out.println();
//		comb(0, 0);
		System.out.println(result);

	}

//	public static void comb(int cnt, int start) {
//
//		if (cnt == 2) {
//			solve();
//			return;
//		}
//
//		for (int i = start; i < 4; i++) {
//			selected[cnt] = rectarr[i];
//			comb(cnt + 1, i + 1);
//		}
//	}
//
//	public static void solve() {
//
//		// selected 배열에서 두번째로 선택된친구의 ne가 첫번째 선택된 친구 안에 있을때
//		if (selected[0].sw.x < selected[1].ne.x && selected[1].ne.x < selected[0].ne.x
//				&& selected[0].sw.y < selected[1].ne.y && selected[1].ne.y < selected[0].ne.y) {
//				result -= (selected[1].ne.x - selected[0].sw.x) * (selected[1].ne.y - selected[0].sw.y);
//		}
//		// selected 배열에서 두번째로 선택된친구의 se가 첫번째 선택된 친구 안에 있을때	
//		if (selected[0].sw.x < selected[1].se.x && selected[1].se.x < selected[0].ne.x
//				&& selected[0].sw.y < selected[1].se.y && selected[1].se.y < selected[0].ne.y) {
//				result -= (selected[1].se.x - selected[0].sw.x) * (selected[0].ne.y - selected[1].se.y);
//		}
//
//		// selected 배열에서 두번째로 선택된친구의 sw가 첫번째 선택된 친구 안에 있을때
//		if (selected[0].sw.x < selected[1].sw.x && selected[1].sw.x < selected[0].ne.x
//				&& selected[0].sw.y < selected[1].sw.y && selected[1].sw.y < selected[0].ne.y) {
//			
//				result -= (selected[0].ne.x - selected[1].sw.x) * (selected[0].ne.y - selected[1].sw.y);
//		}
//		
//		// selected 배열에서 두번째로 선택된친구의 nw가 첫번째 선택된 친구 안에 있을때
//		if (selected[0].sw.x < selected[1].nw.x && selected[1].nw.x < selected[0].ne.x
//				&& selected[0].sw.y < selected[1].nw.y && selected[1].nw.y < selected[0].ne.y) {
//			
//				result -= (selected[0].ne.x - selected[1].nw.x) * (selected[0].ne.y - selected[1].nw.y);
//		}
//	}

}
