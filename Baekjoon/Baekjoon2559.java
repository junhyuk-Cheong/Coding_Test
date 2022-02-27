package feb26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon2559 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 온도를 측정한 전체 날짜의 수 2이상, 100000이하 
		int K = Integer.parseInt(st.nextToken()); // 합을 구하기 위한 연속적인 날짜의 수 1과 N사이의 정수임
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();
 		for (int i = 0; i < N - K + 1; i++) {
 			int temp = 0;
 			for (int j = 0; j < K; j++) {
				temp += arr[i + j];
			}
 			result.add(temp);
		}
		Collections.sort(result, Collections.reverseOrder());
		
		System.out.println(result.get(0));
	}

}
