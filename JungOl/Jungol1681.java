package feb24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Jungol1681 {
	
	//  배달해야 하는 장소를 한번씩만 방문할것. 
	// 다시 회사로 돌아와야 할것.
	// 최소비용으로 할것.
	// 입력 둘 째 줄은 
	public static int N;
	public static int[][] adjMatrix;
	public static boolean[] visited;
	public static final int start = 1;
	public static int mmin = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 배달해야 하는 장소의 수 
		
		adjMatrix = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited[0] = true;
		visited[start] = true;
		dfs(start, 0, 1);
		
		System.out.println(mmin);
		
	}
	
	public static boolean check() { // boolean 배열이 모두   true 즉 모두 방문한경우
		
		 for ( boolean b : visited) {
			 if(b == false) {
				 return false;
			 }
		 }
		 return true;
	}
	
	public static void dfs(int node, int cost, int cnt) {
		
		if(cnt == N) // 모두 방문 했다면
		{
			if(adjMatrix[node][start] != 0) {
				cost += adjMatrix[node][start];
			}
			else {
				return;
			}
			mmin = Math.min(cost, mmin);
			
			return;
		}
		if(cost > mmin) return;
		
		
		for (int next = 1; next <= N; next++) {
			if(adjMatrix[node][next] != 0 && !visited[next]) {
				visited[next] = true;
				dfs(next, cost + adjMatrix[node][next], cnt+1);
				visited[next] = false;
			}
		}
	}	// cnt 로 체크해서  cnt가 5이상 이면 체크를 할까???
	
	
	

}
