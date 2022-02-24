package feb24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

	
public class Baekjoon1753 {

	static class Node{
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
//		int[][] adjmatrix = new int[V+1][V+1];
		int[] distance = new int[V+1];
		boolean[] visited = new boolean[V+1];
		
		int E = Integer.parseInt(st.nextToken());	// 간선의 개수
		int K = Integer.parseInt(br.readLine()); // 시작정점의 번호
		
		Node[] adjList = new Node[V+1];
//		int end = V;
		
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adjList[u] = new Node(v, w, adjList[u]);
		}
		// 입력완료 
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0; // 시작점 0으로
		
		
		
		for (int i = 1; i < V+1; i++) {
			// 단계 1 : 최소비용이 확정되지 않은 정점중 최소비용의 정점 선택
			int min = Integer.MAX_VALUE, current = 0;
			for (int j = 1; j < V+1; j++) {
				if(!visited[j] && min > distance[j] ) {
					min = distance[j];
					current = j;
				}
			}
			
			visited[current] = true;
//			if(current == end) break;// 선택 정점이 도착정점이면 탈출.만약,탈출하지 않고 계속 하면 출발지로부터 모든 정점 각각까지 도착하는 최소거리비용이 다 계산됨.
			
			
//			// 단계2 : 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른정점의 최소비용을 고려
//			for (int j = 1; j < V+1; j++) {
//				if(!visited[j] && adjmatrix[current][j] != 0 && 
//						distance[j] > distance[current] + adjmatrix[current][j]) {
//					distance[j] = distance[current] + adjmatrix[current][j];
//				}
//			}
			//b단계: 출발지에서 가까운 current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
			for(Node temp = adjList[current]; temp != null; temp=temp.next) {
				if(!visited[temp.vertex] &&  
						distance[temp.vertex] > min+temp.weight){
					distance[temp.vertex] = min+temp.weight;
				}
			}
			
			
		} // <!-- for (int i = 1; i < V+1; i++) -->
		
//		System.out.println(Arrays.toString(distance));
		
		
		for (int i = 1; i < V+1; i++) {
			if(distance[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else System.out.println(distance[i]);
		}
		
		
	}

}
