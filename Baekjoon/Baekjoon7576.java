package feb25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7576 {

	// 보관 후 하루가 지나면 익은 토마토들의 인접한 곳에 익지 않은 토마토도 익게된다.
	// 인접한 곳은 상, 하, 좌, 우
	// 토마토가 저절로 익는 경우는 없음
	// 철수는 토마토들이 며칠이 지나면 익는지 알고 싶음
	
	static int M, N;	// M : 상자의 가로 칸의수(열) N : 상자의 세로 칸의수(행)
	static int[][] map;
	static int[][] deltas = { {-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우
	
	static Queue<Point> queue = new LinkedList<>();
	
	static int rtime = 0;
	
	public static class Point{
		int x, y, t;

		public Point(int x, int y, int t) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
//		ArrayList<Point> points = new ArrayList<>();
		
		// 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 의미한다. 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
//					points.add(new Point(i, j));
					queue.offer(new Point(i, j, 0));
				}
			}
		}
		// 입력 완료 
		
		while(!queue.isEmpty()) {
			Point current = queue.poll();
			
			rtime = Math.max(current.t, rtime);
			
			for (int k = 0; k < 4; k++) {
				int nr = current.x + deltas[k][0];
				int nc = current.y + deltas[k][1];
				
				if(nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 0) {
					map[nr][nc] = 1;
					queue.offer(new Point(nr, nc, current.t + 1));
				}
			}
		}
		
		if(check()) {
			System.out.println(rtime);
		}
		else {
			System.out.println(-1);
		}
		// 만일  queue가  empty이면 모든 토마토가 익지 않은 상태이다. 즉 -1을 반환해야한다. 
	
		// visited 배열 쓰지말고 그냥 1로 바꿔버리자...
		// 저장될때부터 모든 토마토가 익어있는 상태면 0 출력 
		// 토마토가 모두 익지 못하는 상황이면 1-이다.
	}

	public static boolean check() {	// 0이 하나도 없으면 true를 반환함
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) return false;
			}
		}
		return true;
	}
	
}
