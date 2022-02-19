package feb18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea1247 {

	public static int T, N; 	// T : 테스트 케이스의 개수, N : 고객의 수
	public static int[][] map;
	
	public static boolean[] isSelected;
	public static int[] selected;
//	public static int[][] person;	// person의 2차원 배열 0은 시작점 맨 마지막은 인덱스
	
	public static int mmin;
	public static int sum;
	
	public static class Point{
		public int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static Point[] persons; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;
		
		T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		
		for (int t = 1; t <= T; t++) {
			
			sb = new StringBuilder();
			
			map = new int[101][101];	// 테케별로 map 초기화
			N = Integer.parseInt(br.readLine()); // N : 고객의 수 
			persons = new Point[N+2];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N + 2; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
//				System.out.println("x : " + x + "y : " + y);
				
				persons[i] = new Point(x, y);
			}
			isSelected = new boolean[N+2];
			selected = new int[N+2];
			
			
			mmin = Integer.MAX_VALUE;
			selected[0] = 0;
			selected[N+1] = 1;
			Perm(1);
			
//			System.out.println(mmin);
			sb.append("#").append(t).append(" ").append(mmin);
			bw.write(sb.toString());
			bw.newLine();
			
		}
		bw.close();
		
	}
	
	public static int cal(Point A, Point B) {
		return Math.abs(A.x - B.x) + Math.abs(A.y - B.y);
	}
	
	public static void Perm(int cnt) {
		if(cnt == N+1) {
//			System.out.println(Arrays.toString(selected));
			int temp = 0;
			for (int i = 0; i < N+1; i++) {
				temp += cal(persons[selected[i]], persons[selected[i+1]]);
			}
			
			if(temp < mmin) {
				System.out.println(Arrays.toString(selected));
				mmin = temp;
			}
			return;
		}
		for (int i = 2; i < N+2; i++) {
			if(isSelected[i] == true) continue;
			selected[cnt] = i;
			isSelected[i] = true;
			Perm(cnt+1);
			isSelected[i] = false;
		}
	}
	
	

}
