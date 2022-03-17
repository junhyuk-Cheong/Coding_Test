package March.mar17;

import java.io.*;
import java.util.*;

public class Baekjoon11726 {

	public static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[N+2];
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
			
		}
		System.out.println(dp[N] % 10007);
			
		
		
	}

}
