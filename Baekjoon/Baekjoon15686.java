package feb22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon15686_myversion {

	public static int N;	
	public static int M;
	public static int[][] map;
	
	public static Point[] homes;
	public static Point[] cshops;
	
	public static Point[] unselected;
	
	public static class Point{
		int x, y, len;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Point(int x, int y, int len) {
			this.x = x;
			this.y = y;
			this.len = len;
		}
		
	}
	
	public static int mmin = Integer.MAX_VALUE;
	
	public static int[][] deltas = { {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		
		int homescnt = 0;
		int cshopcnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {
					homescnt++;
				}
				else if(map[i][j] == 2) {
					cshopcnt++;
				}
			}
		}
		
		homes = new Point[homescnt];
		cshops = new Point[cshopcnt];
		
		int hcnt = 0;
		int ccnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					homes[hcnt++] = new Point(i, j);
				}
				else if(map[i][j] == 2){
					cshops[ccnt++] = new Point(i, j);
				}
			}
		}
		// 입력 완료 
		
//		for (int i = 0; i < homes.length; i++) {
//			System.out.println(homes[i].x + " " + homes[i].y);
//		}
//		
//		System.out.println();
//		for (int i = 0; i < cshops.length; i++) {
//			System.out.println(cshops[i].x + " " + cshops[i].y);
//		}
		
		
		
//		for (int i = 0; i < homes.length; i++) {
//			System.out.println(bfs(homes[i].x, homes[i].y, 0));
////			bfs(homes[i].x, homes[i].y, 0);
//		}
//		System.out.println(add());
		
		unselected = new Point[cshops.length-M];
		
		comb(0, 0);
		System.out.println(mmin);
	}
	
	public static void set() {
		
		for ( Point p : unselected) {
//			System.out.println(p.x + " " + p.y);
			map[p.x][p.y] = 0;
		}
		
	}
	
	public static void reset() {
		for ( Point p : unselected) {
			map[p.x][p.y] = 2;
		}
	}
	
	public static void comb(int cnt, int start) {
		
		if(cnt == (cshops.length-M)) {
			
			set();
			// 여기에 해결 
			
			mmin = Math.min(add(), mmin);
			
			///
			reset();
			return;
		}
		
		for (int i = start; i < cshops.length; i++) {
			
			unselected[cnt] = cshops[i];
			comb(cnt + 1, i + 1);
		}
	}
	
	public static int add() {
		int result = 0;
		for (int i = 0; i < homes.length; i++) {
			result += bfs(homes[i].x, homes[i].y, 0);
		}
		return result;
	}
	
	public static int bfs(int r, int c, int len) {
		
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		visited[r][c] = true;
		queue.offer(new Point(r, c, len));
		
		while(!queue.isEmpty()) {
			
			Point current = queue.poll();
			
			if(map[current.x][current.y] == 2) {
				
				// 길이를 반환해야함
				return current.len;
//				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = current.x + deltas[i][0];
				int nc = current.y + deltas[i][1];
				
				if(nr >= 0 && nc >=0 && nr < N && nc < N && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.offer(new Point(nr, nc, current.len+1));
				}
			}
			
		}
		
		return -1;
	}

}
