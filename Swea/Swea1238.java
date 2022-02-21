package feb21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea1238{
	
//	public static int L, start;
	public static int[][] map;
	public static boolean[] visited;
	public static ArrayList<Point> lists;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) { // 각 테케별
			
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());	// 입력받는 데이터의 길이
			int start = Integer.parseInt(st.nextToken());	// 시작점
			
			
			map = new int[101][101];
			visited = new boolean[101];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < l/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				map[from][to] = 1;
			}
			// 입력 완료
			
			lists = new ArrayList<Point>();
			
			bfs(start);
			Collections.sort(lists);
			
			bw.write("#" + t + " " + lists.get(0).data + "");
			bw.newLine();
		}
		br.close();
		bw.close();
	}
	
	public static void bfs(int start) {
		
		int cnt = 0;
		visited[start] = true;
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(start, cnt));
		
		while(!queue.isEmpty()) {
			
			Point current = queue.poll();
			lists.add(current);
			cnt = current.level + 1;
			
			for (int next = 1; next <= 100; next++) {
				if(!visited[next] && map[current.data][next]==1) {
					visited[next] = true;
					queue.offer(new Point(next, cnt));
				}
			}
		}
	}
	
	public static class Point implements Comparable<Point>{
		int data;
		int level;
		public Point(int data, int level) {
			super();
			this.data = data;
			this.level = level;
		}
		@Override
		public String toString() {
			return "Point [data=" + data + ", level=" + level + "]";
		}
		
		@Override
		public int compareTo(Point o) {
			return this.level == o.level ? o.data - this.data : o.level - this.level;
		}
	}

}
