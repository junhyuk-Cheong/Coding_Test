package feb10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;

public class Baekjoon2667 {

	public static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우 순
	
	public static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];

		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < N; c++) {
				arr[r][c] = str.charAt(c) - '0';
			}
		}
		// 배열에 구성 완료
		
//		Vector<Integer> result = new Vector<Integer>();
		PriorityQueue<Integer> result = new PriorityQueue<>();
		
		int count = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				count = 0;
				if(arr[r][c] == 1) { // 1이 발견되었으면 일단 큐에 때려박는다.
					arr[r][c] = 0;
					Queue<Point> queue = new <Point>LinkedList();
					Point point = new Point(r, c);
					queue.offer(point);
					
					while(!queue.isEmpty()) {
						Point temp = queue.poll();
						count++;
						for (int i = 0; i < 4; i++) {
							
							int nr = temp.x + deltas[i][0];
							int nc = temp.y + deltas[i][1];
							
							
							if(nr >= 0 && nc >= 0 && nr < N && nc < N && arr[nr][nc] == 1) {
								arr[nr][nc] = 0;
								Point p = new Point(nr, nc);
								queue.offer(p);
							}
						}
					}
//					System.out.println(count);
					result.add(count);
				} // if(arr[r][c] == 1)
				
			}
		} // for (int r = 0; r < N; r++)
		
		System.out.println(result.size());
		while(!result.isEmpty()){
			System.out.println(result.poll());
		}
		
		
	}

}
