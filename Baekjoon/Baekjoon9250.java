package April.apr13;

import java.util.*;

import java.io.*;

public class Baekjoon9250 {

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Point[] cstore;
	static Point start;
	static Point end;
	static boolean[][] map;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(br.readLine()); // 편의점 개수
			M = N + 2;
			map = new boolean[M][M];
			cstore = new Point[M];

			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			cstore[0] = new Point(x, y);

			for (int i = 1; i < M - 1; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				cstore[i] = new Point(x, y);
			}
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			cstore[M - 1] = new Point(x, y);

			// 입력완료

			// 인접배열 만들기
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < M; j++) {
					if (i == j)
						continue;
					if (cal(cstore[i].x, cstore[i].y, cstore[j].x, cstore[j].y) <= 1000) {
						map[i][j] = true;
					}
				}
			}
			
			
//			System.out.println(bfs());
			sb.append(bfs() + "\n");
			
			// 인접배열 형성 완료

//			for (int i = 0; i < M; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}

		} // 각각의 테스트 케이스별
		System.out.println(sb.toString());
	}

	static int cal(int x1, int y1, int x2, int y2) {
		return (Math.abs(x1 - x2) + Math.abs(y1 - y2));
	}

	static String bfs() {

		boolean[] visited = new boolean[M];
		Queue<Integer> queue = new LinkedList<Integer>();

		visited[0] = true;
		queue.offer(0);

		while(!queue.isEmpty()) {
			
			int curr = queue.poll();

			if(curr == M-1) {
				return "happy";
			}
			
			for (int next = 0; next < M; next++) {
				if(!visited[next] && map[curr][next] ) { // true이면 
					visited[next] = true;
					queue.offer(next);
				}
			}
			
		}
		return "sad";
	}

}
