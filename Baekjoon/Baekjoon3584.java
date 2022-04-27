package April.apr27;

import java.io.*;
import java.util.*;

public class Baekjoon3584 {

	static int N;
	static int[] parents;
	static boolean[] visit;

	static int find_set(int a) {
		if (a == parents[a]) {
			return a;
		}
//		return parents[a] = find_set(parents[a]);
		return find_set(parents[a]);
	}

	static boolean union(int a, int b) {
		parents[b] = a;
		return true;
	}

	static int solution(int x, int y) {
		List<Integer> a_parents = new ArrayList<Integer>();
		List<Integer> b_parents = new ArrayList<Integer>();
		int result = 0;
		while (x != 0) {
			visit[x] = true;
			a_parents.add(x);
			x = parents[x];
		}
		
		System.out.println("============ for solution1 =========");
		for (int i = 0; i < a_parents.size(); i++) {
			System.out.print(a_parents.get(i) + " ");
		}
		System.out.println();
			

		while (y != 0) {
			b_parents.add(y);
			if (visit[y]) {
				result = y;
				break;
			}
			y = parents[y];
		}
		
		
		for (int i = 0; i < b_parents.size(); i++) {
			System.out.print(b_parents.get(i) + " ");
		}
		System.out.println();
		
		return result;
	}

	static int solution2(int a, int b) {
		List<Integer> a_parents = new ArrayList<Integer>();
		List<Integer> b_parents = new ArrayList<Integer>();
		while (a != 0) { // 조상 노드가 아닐때까지
			a_parents.add(a); // 조상 노드가 아니면 일단 추가
			a = parents[a];
		}

		while (b != 0) { // 조상 노드가 아닐때까지
			b_parents.add(b); // 조상 노드가 아니면 일단 추가
			b = parents[b];
		}

		///////////////////////
		System.out.println("============ for solution2 =========");
		for (int i = 0; i < a_parents.size(); i++) {
			System.out.print(a_parents.get(i) + " ");
		}
		System.out.println();

		for (int i = 0; i < b_parents.size(); i++) {
			System.out.print(b_parents.get(i) + " ");
		}
		System.out.println();
		///////////////////////

		int result = -1;
		for (int i = 0; i < a_parents.size(); i++) {
			for (int j = 0; j < b_parents.size(); j++) {
				if (a_parents.get(i) == b_parents.get(j)) {
					result = a_parents.get(i);
					return result;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());

		for (int t = 0; t < TC; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // N의 개수

			parents = new int[N + 1];
			visit = new boolean[N + 1];
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());

				union(parent, child);
			}
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			int result = solution(node1, node2);
			int result2 = solution2(node1, node2);
			sb.append(result + "\n");
			sb.append(result2 + "\n");
			
			
		}

		System.out.println(sb.toString());
	}

}
