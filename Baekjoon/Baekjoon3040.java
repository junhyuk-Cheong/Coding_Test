package feb14;

import java.util.*;
import java.io.*;

public class Baekjoon3040 {
	
	public static int[] arr = new int[9];
	public static int[] selected = new int[7];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Combination(0, 0, 0);
	}
	
	public static void Combination(int cnt, int start, int sum) {
		
		if(cnt == 7) {
			if(sum == 100)
				for (int i = 0; i < 7; i++) {
					System.out.println(selected[i]);
				}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			selected[cnt] = arr[i]; 
			Combination(cnt + 1, i + 1, sum + arr[i]);
		}
		
		
	}

}
