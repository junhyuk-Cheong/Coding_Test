package feb11;

import java.io.*;
import java.util.*;

public class Swea1861 {

	public static int[][] deltas = { {-1,0},{1,0},{0,-1},{0,1} }; // 상, 하, 좌, 우
	
	public static class Point{
		int x; 
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int count = 0;
			int[] tmax = new int[2];	// tmax[0] 는 처음에 출발해야 하는 방 번호, tmax[1]는 최대몇개
			
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				String[] temp = br.readLine().split(" ");
				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(temp[c]);
				}
			} //배열 구성 완료
			
			// 배열 순회
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					count = 0;
					
					Queue<Point> queue = new LinkedList<Point>();
					queue.offer(new Point(r, c));
					
					while(!queue.isEmpty()) {
						Point curr = queue.poll();
						count++;
						
						for (int j = 0; j < 4; j++) {
							int nr = curr.x + deltas[j][0];
							int nc = curr.y + deltas[j][1];
							
							if(nr >= 0 && nc >= 0 && nr < N && nc < N && (arr[nr][nc] == arr[curr.x][curr.y]+1))
								queue.offer(new Point(nr, nc));
						}
					}
					if(count == tmax[1]) {
						if(tmax[0] > arr[r][c])
							tmax[0] = arr[r][c];
					}
					
					if(count > tmax[1]) {
						tmax[1] = count;
						tmax[0] = arr[r][c];
					}
					
				}
			}
			bw.write("#" + (i+1) + " " + tmax[0] + " " + tmax[1]);
			bw.newLine();
		}
		br.close();
		bw.close();
		
	}

}
