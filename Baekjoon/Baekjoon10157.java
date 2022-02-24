package feb22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon10157 {
	// 1. N * N 크기의 공간에 M마리 물고기 아기 상어1마리
	// 한칸에는 물고기 최대 1마리 존재
	// 아기 상어의 크기는 2, 아기 상어는 1초에 상하좌우로 인접한 한칸씩 이동가능
	// 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 못지나가는데 나머지 칸은 지나갈수 있음.
	// 아기상어는 자신의 크기보다 작은 물고기만먹을수 있어서 자신이랑 무게가 같은 물고기는 먹지는 못하지만 이동은 가능
	// 아기상어는 일단 물고기가 1마리면 그 물고기 먹으러 가는 최단경로로 이동
	// 아기상어는 일단 물고기가 여러마리이면 가장 가까운 물고기 먹으러감
	// 그 가장 가까운 물고기 마저 후보군이 여럿이라면 가장 위에 있는 물고기부터 또 가장 왼쪽에 있는 물고기부터 먹으러 감
	// 아기상어는 자신의 크기와 같은 수의 물고기를 먹을 때마다 크기가 1씩 증가한다.

	public static int[][] deltas = { { -1, 0 }, { 0, -1 }, { 0, 1 },  { 1, 0 }}; // 상, 좌, 우, 하순으로
	// 순서가 매우매우 중요함  --> 별로 안중요함
	public static int N;
	public static int[][] map;
	public static int stime; // 아기상어가 엄마상어한테 도움을 요청하지 않고 물고기를 잡아먹을수 있는 시간
	public static int weight = 2; // 아기상어의 현재 무게
	public static int cnt = 0; //  지금까지 여태껏 총 먹은 물고기의 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int r = 0, c = 0; // 아기상어의 위치
		N = Integer.parseInt(br.readLine()); // 공간의 크기
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					r = i;
					c = j;
					map[i][j] = 0;
				}
			}
		} // 입력완료

		
		Solve(r, c);
		System.out.println(stime);
	}// <!-- main -->

	
	public static void Solve(int r, int c) {

		Point next = bfs(r, c);
		cnt++;
		if(next == null) return;
		else {
			
			if(cnt == weight) {
				weight = weight + 1;
				cnt = 0;
			}
			map[next.x][next.y] = 0;
			stime += next.level;
			
			Solve(next.x, next.y);
		}
		
	}
	
	public static class Point implements Comparable<Point> {
		int x, y;
		int level;

		public Point(int x, int y, int level) {
			this.x = x;
			this.y = y;
			this.level = level;
		}

		@Override
		public int compareTo(Point o) {
			
			if(this.level == o.level) {
				
				return this.x == o.x ? this.y - o.y : this.x - o.x;
			}
			else {
				return this.level - o.level;
			}
		}
	}

	// 가장 최단경로 & 먹을수 있는 물고기의 좌표 값 반환해주기
	public static Point bfs(int r, int c) {
		boolean[][] visited = new boolean[N][N];
		Queue<Point> queue = new LinkedList<>();

		visited[r][c] = true;
		queue.offer(new Point(r, c, 0));
		
		ArrayList<Point> lists = new ArrayList<Point>();
		
		while(!queue.isEmpty()) {

			Point current = queue.poll();
			
			if(map[current.x][current.y] > 0 && map[current.x][current.y] < weight) {
				lists.add(current);
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = current.x + deltas[i][0];
				int nc = current.y + deltas[i][1];
				
				// 단 자신보다 무게가 많이나가는 물고기가 있는  지역은 못지나간다는것도 명심
				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && map[nr][nc] <= weight) {
					visited[nr][nc] = true;
					queue.offer(new Point(nr, nc, current.level + 1));
				}
			} // queue에 삽입 다 끝남
		} // <!--while -->
		
		if(lists.isEmpty()) return null;
		else {
			Collections.sort(lists);
			return lists.get(0);
		}
		
	}// <!-- bfs -- >

}
