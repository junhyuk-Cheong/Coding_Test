package feb19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon2564 {

	public static int W, H, N;	// 가로, 세로, 개수
//	public static int[][] map;
	public static store[] stores;
	
	public static class store{
		int dir;
		int x;	// 북, 남쪽이면 왼쪽부터 동, 서쪽이면 위쪽부터
		public store(int dir, int x) {
			super();
			this.dir = dir;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
//		map = new int[R][C];
		N = Integer.parseInt(br.readLine()); 	// 상점의 개수
		stores = new store[N];
		
		
		
		// 1은 블록의 북쪽, 2는 남쪽, 3은 서쪽 4는 동쪽에 상점이 있음
		// 상점의 위치나 동근이의 위치는 블록의 꼭짓점이 될 수 없음
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int d = Integer.parseInt(st.nextToken()); //  1 : 북, 2 : 남, 3 : 서, 4 : 동
			int x = Integer.parseInt(st.nextToken()); // 북, 남이면 왼쪽으로부터 떨어진 거리 동, 서이면 위로부터 떨어진 거리
			stores[i] = new store(d, x);
		}
		st = new StringTokenizer(br.readLine());
		int currd = Integer.parseInt(st.nextToken());	// 동근이의 방향
		int currx = Integer.parseInt(st.nextToken());	// 동근이의 거리
		
		int sum = 0;
		
		
		for (int i = 0; i < N; i++) {
			int tempd = stores[i].dir;
			int tempx = stores[i].x;
			int diff = Math.abs(currd-tempd);

			if(diff == 0) {
				sum += Math.abs(currx - tempx);
				continue;
			}
			
			if(currd == 1) {	// 동근이가 북, 인접은 서, 동
				if(tempd == 3) {	// 상점이 서쪽일때
					sum += currx + tempx;
				}
				else if(tempd == 4) {	// 상점이 동쪽일때
					sum += W - currx + tempx;
				}
				else { // 상점이 남쪽일때
					int comp1 = currx + tempx + H;
					int comp2 = W - currx + W - tempx + H; 
					sum += Math.min(comp1, comp2);
				}
			}
			else if(currd == 2) {	// 동근이가 남
				if(tempd == 3) { // 상점이 서쪽일때 
					sum += currx + H - tempx;
				}
				else if(tempd == 4) {	// 상점이 동쪽일때
					sum += W - currx + H - tempx;
				}
				else {	// 상점이 북쪽일때
					int comp1 = currx + tempx + H;
					int comp2 = 2*(H+W) - comp1;
					sum += Math.min(comp1, comp2);
				}
			}
			else if(currd == 3) { // 동근이가 서
				if(tempd == 1) {	// 상점이 북쪽
					sum += currx + tempx;
				}
				else if(tempd == 2) { // 상점이 남쪽
					sum += H - currx + tempx;
				}
				else {	// 상점이 동쪽
					int comp1 = currx + tempx + W;
					int comp2 = 2*(H+W) - comp1;
					sum += Math.min(comp1, comp2);
				}
			}
			else { // currd == 4일때	// 동근이가 동
				if(tempd == 1) { // 상점이 북
					sum += currx + W - tempx;
				}
				else if(tempd == 2) {	// 상점이 남
					sum += H - currx + W - tempx;
				}
				else {	// 상점이 서쪽
					int comp1 = currx + tempx + W;
					int comp2 = 2*(H+W) - comp1;
					sum += Math.min(comp1, comp2);
				}
				
			}
			
		} // <!-- for -->
		System.out.println(sum);
	} // <!-- main -->

}
