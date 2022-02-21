package feb21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1260 {
	
	public static int N, M, V; // N : 정점의 개수, M : 간선의 개수, V : 탐색을 시작할 정점의 번호
	public static int[][] map;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = 1;
			map[to][from] = 1;
		}
		
		
		dfs(V, new boolean[N+1]);
		bw.newLine();
		bfs(V, new boolean[N+1]);
		
		br.close();
		bw.close();
		
	}
	
	public static void bfs(int start, boolean[] visited) throws IOException{
		
		visited[start] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			bw.write(current + " ");
			
			for (int j = 1; j <= N; j++) {
				if(!visited[j] && map[current][j] == 1) {
					visited[j] = true;
					queue.offer(j);
				}
			}
		}
	}
	
	public static void dfs(int current, boolean[] visited) throws IOException{
		
		visited[current] = true;
		bw.write(current + " ");
		
		for (int j = 1; j <= N; j++) {
			if(!visited[j] && map[current][j] == 1) {
				visited[j] = true;
				dfs(j, visited);
			}
				
		}
	}

}
