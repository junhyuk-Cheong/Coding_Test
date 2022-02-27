package feb26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10163 {
	// 평면에서로 다른 직사각형 모양이 색종이 N장이 하나씩 차례로 놓아짐.
	// 색종이는 모두 서로 평행혹은 수직임
	// N장의 색종이가 주어진 위치에 차례로 놓일 경우에 색종이가 보이는 부분의면적을 구하여라

	static int N;

	public static int[][] map = new int[1001][1001];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 색종이의 장수
//		int[] result = new int[N];
//		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());	// 너비
			int h = Integer.parseInt(st.nextToken());	// 높이
			
			
			for (int r = x; r < w+x; r++) {
				for (int c = y; c < h+y; c++) {
					map[r][c] = i;
				}
			}
		} // <!--for (int i = 0; i < N; i++) -->
		
		
		int[] result = new int[N+1];
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				int temp = map[i][j];
				for (int k = 1; k <= N; k++) {
					if(temp == k) result[k]++;
				} 
			}
		}
		
		for (int i = 1; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
		
	}

}
