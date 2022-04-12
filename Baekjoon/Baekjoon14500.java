package April.apr12;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.*;
import java.util.*;

import com.sun.security.auth.SolarisNumericGroupPrincipal;

public class Baekjoon14500	 {

	static int[][] map;
	static int N, M;
	static int mmax = Integer.MIN_VALUE;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력완료
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
//				visited = new boolean[N][M];
				visited[i][j] = true;
				dfs(i, j, 0, map[i][j]);
				mmax = Math.max(mmax, last(i, j, map[i][j]));
				visited[i][j] = false;
			}
		}
		System.out.println(mmax);
	}

	public static void dfs(int r, int c, int level, int sum) {
		
		if(level == 3) {
			mmax = Math.max(sum, mmax);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];
			if(nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc]) {
				visited[r][c] = true;
				dfs(nr, nc, level + 1, sum + map[nr][nc]);
				visited[r][c] = false;
			}
		}
	}
	
	public static int last(int r, int c, int sum) {
		
		int cnt = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];
			if(nr >= 0 && nc >= 0 && nr < N && nc < M ) {
				sum += map[nr][nc];
				cnt++;
				min = Math.min(map[nr][nc], min);
			}
		}
		
		if(cnt == 4) {
			sum -= min;
			return sum;
		}else if(cnt == 3) {
			return sum;
		}else {
			return -1;
		}
		
	}

}
