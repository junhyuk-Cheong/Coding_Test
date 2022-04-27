package April.apr27;

import java.io.*;
import java.util.*;

import org.omg.CORBA.Principal;

import com.sun.corba.se.impl.util.PackagePrefixChecker;

public class Baekjoon10473 {

	static int N, M;	// N명의 학생, M개의 단방향 도로
	static int[][] adjMatrix;
	static class Vertex implements Comparable<Vertex>{	// 간선정보 
		int no;	// 정점번호
		int minDistance; // 정점 번호, 출발지에서 자신으로의 최소비용

		Vertex(int no, int minDistance){
			this.no = no;
			this.minDistance = minDistance;
		}

		public int compareTo(Vertex o){
			return this.minDistance - o.minDistance;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// N명의 학생
		M = Integer.parseInt(st.nextToken());	// M개의 단방향 도로 
		int X = Integer.parseInt(st.nextToken()); // X번 마을 
		adjMatrix = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = weight;
		}
		
		int[] students = new int[N+1];
		
		
		for (int start = 1; start <= N; start++) {
			int[] distance = new int[N+1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[start] = 0;
			
			PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
			pq.offer(new Vertex(start, distance[start]));
			boolean[] visited = new boolean[N+1];
			
			while(!pq.isEmpty()) {
				Vertex curr = pq.poll();
				if(visited[curr.no]) continue;
				visited[curr.no] = true;
				
				if(curr.no == X) break;
				
				for (int j = 1; j <= N; j++) {
					if(!visited[j] && adjMatrix[curr.no][j] != 0 &&
							distance[j] > distance[curr.no] + adjMatrix[curr.no][j]) {
						distance[j] = distance[curr.no] + adjMatrix[curr.no][j];
						pq.offer(new Vertex(j, distance[j]));
					}
				}
			} // <!-- while -->
			
			students[start] += distance[X];
			
			
			distance = new int[N+1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[X] = 0;
			
			pq = new PriorityQueue<Vertex>();
			pq.offer(new Vertex(X, distance[X]));
			visited = new boolean[N+1];
			
			while(!pq.isEmpty()) {
				Vertex curr = pq.poll();
				if(visited[curr.no]) continue;
				visited[curr.no] = true;
				
				if(curr.no == start) break;
				
				for (int j = 1; j <= N; j++) {
					if(!visited[j] && adjMatrix[curr.no][j] != 0 &&
							distance[j] > distance[curr.no] + adjMatrix[curr.no][j]) {
						distance[j] = distance[curr.no] + adjMatrix[curr.no][j];
						pq.offer(new Vertex(j, distance[j]));
					}
				}
			} // <!-- while -->
			
			students[start] += distance[start];
		}
		
//		System.out.println(Arrays.toString(students));
		Arrays.sort(students);
		System.out.println(students[students.length-1]);
	}

}
