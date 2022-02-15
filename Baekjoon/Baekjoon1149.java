package feb15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon1149 {
	
	
	public static int N; // N은 집의 수
	public static int[][] houses; // 집과 색깔, 빨간색, 초록색, 파란색 순서대로
	
	public static int[][] distances;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		houses = new int[N+1][3];
		distances = new int[N+1][3];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			houses[i][0] = Integer.parseInt(st.nextToken()); // 빨간색
			houses[i][1] = Integer.parseInt(st.nextToken()); // 초록색
			houses[i][2] = Integer.parseInt(st.nextToken()); // 파란색
		}
		distances[0][0] = distances[0][1] = distances[0][2] = houses[0][0] = houses[0][1] = houses[0][2] = 0;
		for (int i = 1; i <= N; i++) {
			distances[i][0] = Min(distances[i-1][1], distances[i-1][2]) + houses[i][0];
			distances[i][1] = Min(distances[i-1][0], distances[i-1][2]) + houses[i][1];
			distances[i][2] = Min(distances[i-1][0], distances[i-1][1]) + houses[i][2];
		}
		int temp = Min(distances[N][0], distances[N][1]);
		temp = Min(temp, distances[N][2]);
		
		System.out.println(temp);
	}
	
	public static int Min(int a, int b)
	{
		return a < b ? a : b;
	}
}
