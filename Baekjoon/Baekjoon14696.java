package feb26;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon14696 {
	// 별 : 4, 동그라미 : 3, 네모 : 2, 세모 : 1
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	// 총 라운드 수를 나타냄
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int anum = Integer.parseInt(st.nextToken());
			Integer[] A = new Integer[anum];
			for (int j = 0; j < anum; j++) {
				A[j] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			int bnum = Integer.parseInt(st.nextToken());
			Integer[] B = new Integer[bnum];
			for (int j = 0; j < bnum; j++) {
				B[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(A, Collections.reverseOrder());
			Arrays.sort(B, Collections.reverseOrder());
			
			bw.write(solve(A, B));
			bw.newLine();
		}
		br.close();
		bw.close();
	}
	
	
	static char solve(Integer[] A, Integer[] B) {
		int anum = A.length;
		int bnum = B.length;
		
		for (int j = 0; j < Math.min(anum, bnum); j++) {
			if( A[j] > B[j] ) {
				return 'A';
			}
			else if( A[j] < B[j] ) {
				return 'B';
			}
		}
		
		if(anum == bnum) {
			return 'D';
		}
		else if(anum < bnum) {
			return 'B';
		}
		else if(anum > bnum) {
			return 'A';
		}
		return 0;
	}

}
