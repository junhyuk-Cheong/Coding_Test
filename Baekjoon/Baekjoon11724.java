package March.mar17;

import java.io.*;
import java.util.*;


public class Baekjoon11724 {

	public static boolean[] visited;
	
	public static int[][] map;
	public static int count = 0;
	public static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 정점의 개수 N
		int M = Integer.parseInt(st.nextToken());	// 간선의 개수 M
		map = new int [N+1][N+1];
		visited = new boolean[N+1];
		
		for (int t = 1; t <= M; t++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			map[u][v] = 1;
			map[v][u] = 1;
		}
		
//		for (int i = 1; i <= N ; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				count++;
				visited[i] = true;
				dfs(i);
			}
			
		}
		
		
		System.out.println(count);
		
//		visited[1] = true;
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				if(map[i][j] == 1 && !visited[i]) {
//					visited[j] = true; // 방문체크
//					count++;
////					map[i][j] = 0;
//					dfs(i, j);
//				}
//				
//			}
//		}
	
	}
	
	public static void dfs(int i) {
		
		for (int j = 1; j <= N; j++) {
			if(map[i][j] == 1 && !visited[j]) {
				visited[j] = true;
				dfs(j);
			}
		}
		
		
	}
	
	

}
