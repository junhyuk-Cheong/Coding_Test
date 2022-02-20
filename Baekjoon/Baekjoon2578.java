package feb19;

import java.util.*;
import java.io.*;

public class Baekjoon2578 {

	public static int[][] map = new int[5][5];
	public static int[][] deltas = { {-1,0}, {1,0}, {0, -1}, {0, 1}, {1,1}, {-1, 1}}; // 상, 하, 좌, 우, 우하, 우상
	public static int[] dir = {0, 1, 2, 3}; // 상, 하, 좌, 우
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int cnt = 0;
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // map 생성 완료
		
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				cnt++;
				setmap(Integer.parseInt(st.nextToken()));
//				print();
				if(checkBingo() == true) {
					bw.write(cnt + "");
					br.close(); bw.close();
					return;
				}
			}
		}
		
	}
	
	public static void print() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	public static void setmap(int tmp) {
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(map[i][j] == tmp)
					map[i][j] = 0;
			}
		}
	}
	
	public static boolean checkBingo() {	// 빙고가 되었는지 알려주는 함수 
		int cnt = 0;
		
		// 가로체크
		for (int i = 0; i < 5; i++) {
			if(map[i][0] == 0) {
				if(dfs(i, 0, 3) == true) {
					cnt++;
					if(cnt >= 3) 
						return true;
				}
			}
		}
		// 세로 체크
		for (int j = 0; j < 5; j++) {
			if(map[0][j] == 0) {
				if(dfs(0, j, 1) == true) {
					cnt++;
					if(cnt >= 3) 
						return true;
				}
			}
		}
		// 대각선 체크 (우하 방향)
		if(map[0][0] == 0)
			if(dfs(0, 0, 4) == true) {
				cnt++;
				if(cnt >= 3) 
					return true;
			}
		// 대각선 체크(우상 방향)
		if(map[4][0] == 0)
			if(dfs(4, 0, 5) == true) {
				cnt++;
				if(cnt >= 3) 
					return true;
			}
				
		
		return false;
	}
	
	public static boolean dfs(int r, int c, int d) { // d : 방향 0 상 1 하 2 좌 3우
		
		boolean flag = true;
		for (int i = 1; i < 5 ; i++) {
			int nr = r + deltas[d][0]*i;
			int nc = c + deltas[d][1]*i;
			
			if(map[nr][nc] != 0) {
				flag = false;
				break;
			}
		}
		
		return flag;
		
	}	// <!-- dfs -->

}
