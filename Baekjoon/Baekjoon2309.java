package feb19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2309 {

//	public boolean[] isSelected
	public static int[] selected = new int[7];
	public static int[] hobits = new int[9];
	public static boolean flag = false;
	
	public static void main(String[] args) throws IOException{
		
//		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 9; i++) {
			hobits[i] = Integer.parseInt(br.readLine());
		}
		
		Comb(0, 0, 0);
		Arrays.sort(selected);
		for (int i = 0; i < 7; i++) {
			sb.append(selected[i]).append("\n");
		}
		bw.write(sb.toString());
//		long end = System.currentTimeMillis();
		
//		System.out.println(end-start);
		br.close();
		bw.close();
		
	}
	
	public static void Comb(int cnt, int start, int sum) {
		if(cnt == 7) {
//			System.out.println(Arrays.toString(selected));
			if(sum == 100) {
				flag = true;
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			selected[cnt] = hobits[i];
			Comb(cnt+1, i+1, sum + selected[cnt]);
			if(flag == true) break;
		}
	}
	
//	public static int sum() {
//		int sum = 0;
//		for (int i = 0; i < 7; i++) {
//			sum += selected[i];
//		}
//		return sum;
//	}
	

}
