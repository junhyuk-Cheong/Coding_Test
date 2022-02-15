package feb15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon1043 {
	// https://sohee-dev.tistory.com/75
	public static int N, M;
	public static boolean[] tperson = new boolean[51]; // 진실을 아는 사람들의 배열
	public static int count = 0;	// 과장된 이야기를 할 수 있는 파티 개수의 최대값
	public static int[][] map;	
	
	public static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 사람의 수
		M = Integer.parseInt(st.nextToken());	// 파티의 수

		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		
		st = new StringTokenizer(br.readLine());
		int temp = Integer.parseInt(st.nextToken());
		for (int i = 0; i < temp; i++) {
			tperson[Integer.parseInt(st.nextToken())] = true;
		}

		
		ArrayList<Integer>[] peoples = new ArrayList[M];
		for (int i = 0; i < M; i++) {
			peoples[i] = new ArrayList<Integer> ();
		}
		int val, pre = 0;
		
		
		for (int i = 0; i < M; i++) {	
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());

			if(tmp > 0) {
				pre = Integer.parseInt(st.nextToken());
				peoples[i].add(pre);
			}
		}
		
		
		//https://sohee-dev.tistory.com/75
		
		
	
	}

}
