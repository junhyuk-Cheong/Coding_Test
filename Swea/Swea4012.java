package feb16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea4012 {

	public static int T, N, R;
	public static int[][] s;
	public static boolean[] isSelected;
	
	public static int min;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			
			N = Integer.parseInt(br.readLine());
			R = N/2;
			s = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					s[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			// 입력받음 
			
			isSelected = new boolean[N];
			min = Integer.MAX_VALUE;
			Combination(0, N/2);
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(min);
			bw.write(sb.toString());
			bw.newLine();
		}
		bw.close();
	}
	
	public static void Combination(int start, int r) {
		
		if(r == 0) {
			
			int temp = Solution();
			if(temp < min)
				min = temp;
		}
		
		for (int i = start; i < N; i++) {
			
			isSelected[i] = true;
//			selected[cnt] = input[i];
			Combination(i+1, r-1);
			isSelected[i] = false;
		}
		
		
	}
	

	public static int Solution(){
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		ArrayList<Integer> listb = new ArrayList<Integer>();
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i] == true) {
				lista.add(i);
			}
			else {
				listb.add(i);
			}
		}
		
		int suma = 0;
		int sumb = 0;
		for (int r = 0; r < lista.size(); r++) {
			for (int c = 0; c < lista.size(); c++) {
				suma += s[lista.get(r)][lista.get(c)];
//				suma += s[lista.get(c)][lista.get(r)];
				sumb += s[listb.get(r)][listb.get(c)];
//				sumb += s[listb.get(c)][listb.get(r)];
			}
		}
		
		
		return Math.abs(suma - sumb);
	}

}
