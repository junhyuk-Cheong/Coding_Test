package April.apr24;

import java.io.*;
import java.util.*;

public class Baekjoon1197 {

	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static int V, E;	// 정점의 개수 v, 간선의 개수 E
	static Edge[] edgeList; // 간선리스트
	static int[] parents; //
	
	static void make_set() {
		parents = new int[V + 1];
		for (int i = 0; i < V + 1; i++) {
			parents[i] = i;
		}
	}
	
	static int find_set(int i) {
		if(i == parents[i]) return i;
		return parents[i] = find_set(parents[i]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find_set(a);
		int bRoot = find_set(b);
		
		if(aRoot == bRoot) return false;

		parents[bRoot] = aRoot; 
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());	// 정점의 개수
		E = Integer.parseInt(st.nextToken());	// 간선의 개수
		
		edgeList = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(from, to, weight);
		}
		Arrays.sort(edgeList);
		
		
//		for (Edge edge : edgeList) {
//			System.out.println(edge.from + " " + edge.to + " " + edge.weight);
//		}
//		
		make_set();
		int result = 0, cnt = 0;
		
		for (Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++cnt == V - 1)
					break;
			}
		}
		System.out.println(result);
		
	}

}
