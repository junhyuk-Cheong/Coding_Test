package feb22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_10026 {

	public static int N;
	public static char[][] map;
	
	public static char[][] abmap;
	
	public static int normal;	//적록색약이 아닌 사람
	public static int abnormal;	//적록색약인 사람
	
	public static int[][] deltas = { {-1, 0}, {1, 0}, { 0, -1}, {0, 1}};
	public static boolean[][] visited;
	public static boolean[][] abvisited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		abmap = new char[N][N];
		
		visited = new boolean[N][N];
		abvisited = new boolean[N][N];
		
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c);
				if(str.charAt(c) == 'G') {
					abmap[r][c] = 'R';
					continue;
				}
				abmap[r][c] = str.charAt(c);
			}
		}
		
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(!visited[r][c]) {
					normal++;
					visited[r][c] = true;
					dfs(r, c);
				}
				if(!abvisited[r][c]) {
					abnormal++;
					abvisited[r][c] = true;
					abdfs(r,c);
				}
			}
		}
		
		System.out.println(normal + " " + abnormal);
		
	}
	
	public static void dfs(int r, int c) {

//		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];
			
			if(nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && map[r][c] == map[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}
	}
	
	public static void abdfs(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];
			
			if(nr >= 0 && nc >= 0 && nr < N && nc < N && !abvisited[nr][nc] && abmap[r][c] == abmap[nr][nc]) {
				abvisited[nr][nc] = true;
				abdfs(nr, nc);
			}
		}
	}

}
