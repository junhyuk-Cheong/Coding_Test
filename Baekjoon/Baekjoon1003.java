package feb11;

import java.io.*;

public class Baekjoon1003 {
	
	public static int zeroes_count;
	public static int ones_count;
	public static int[][] arr = new int[41][2];
	
	public static int[] fibonacci(int n) {
		
		if(arr[n][0] == -1 || arr[n][1] == -1) {
			arr[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
			arr[n][1] = fibonacci(n-1)[1] + fibonacci(n-2)[1]; 
		}
		return arr[n];
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < 41; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = -1;
			}
		}
		arr[0][0] = 1; 
		arr[0][1] = 0;
		arr[1][0] = 0;
		arr[1][1] = 1;

		
		
		for (int i = 0; i < T; i++) {
			int[] temp = fibonacci(Integer.parseInt(br.readLine()));
			bw.write(temp[0] + " " + temp[1]);
			bw.newLine();
		}
		
		br.close();
		bw.close();
	}
	
}
