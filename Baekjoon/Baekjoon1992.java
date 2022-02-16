package feb16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjoon1992 {

	public static int N;
	public static int[][] map;
	public static boolean flag;
	
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		
		solution(0, 0, N);
		System.out.println(sb.toString());
	}
	
	
	
	public static void solution(int r, int c, int size) {
		
		if(CanCompression(r, c, size)) {
			sb.append(map[r][c]);
			return;
		}
		
		sb.append('(');
		
		// 왼쪽 위
		solution(r, c, size/2);		
		// 오른쪽 위 
		solution(r, c + size/2, size/2);
		// 왼쪽 아래
		solution(r + size/2, c, size/2);	
		// 오른쪽 아래
		solution(r+size/2, c+size/2, size/2);
		
		sb.append(')');
		
	}
	
	
	
	public static boolean CanCompression(int x, int y, int size) {
		int val = map[x][y];
		
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if(val != map[i][j]) {
					return false;
				}
			}
			
		}
		return true;
	}
	

}
