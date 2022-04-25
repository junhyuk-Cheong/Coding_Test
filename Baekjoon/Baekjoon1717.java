package April.apr25;

import java.io.*;
import java.util.*;


public class Baekjoon1717 {

	static int N, M;
	static int[] parents;
	
	static void make_set() {
		parents = new int[N+1];
		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	static int find_set(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = find_set(parents[a]);
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
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		make_set();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(first == 0) {	 // 합친다 union
				union(a, b);
			}
			else if(first == 1) {
				if(find_set(a) == find_set(b)) {
					sb.append("YES\n");
				}
				else {
					sb.append("NO\n");
				}
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
