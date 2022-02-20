package feb19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2491 {

	public static int N;
	public static int[] arr;
	
	public static void main(String[] args) throws IOException{
		// 주어진 수열 안에서 수열이 연속해서 커지거나 연속해서 작아져야 하는데 그 중에서 길이가 가장 긴것을 찾아내기 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	// 수열의 길이
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 입력완료
		
		// 같은것을 + 로 처리
		char[] arr2 = new char[N-1];
		// 같은것을 - 로 처리
		char[] arr3 = new char[N-1];
		
		
		for (int i = 0; i < N-1; i++) {
			int diff = arr[i+1] - arr[i];
			
			if(diff > 0) {
				arr2[i] = '+';
				arr3[i] = '+';
			}
			else if(diff < 0) {
				arr2[i] = '-';
				arr3[i] = '-';
			}
			else {	// diff == 0일때
				arr2[i] = '+';
				arr3[i] = '-';
			}
		}
		// arr2, arr3 배열 생성 완료
		
//		System.out.println(Arrays.toString(arr2));
//		System.out.println(Arrays.toString(arr3));
		
		int cnt2 = Integer.MIN_VALUE; 
		int cnt3 = Integer.MIN_VALUE;
		int temp = 0;
		for (int i = 0; i < N-1; i++) {
			if(arr2[i] == '+')
				temp++;
			else if(arr2[i] == '-') {
//				cnt2 = Math.max(temp, cnt2);
				temp = 0;
			}
			cnt2 = Math.max(temp, cnt2);
		}
		// arr2 탐색완료
		
		temp = 0;
		for (int i = 0; i < N-1; i++) {
			if(arr3[i] == '-')
				temp++;
			else if(arr3[i] == '+') {
//				cnt3 = Math.max(temp, cnt3);
				temp = 0;
			}
			cnt3 = Math.max(temp, cnt3);
		}
		// arr3 탐색완료
		
		
		if(N == 1) {
			System.out.println(1);
		}
		else {
		System.out.println(Math.max(++cnt2, ++cnt3));
		}
	}
	
//	/***
//	 * 
//	 * @param cnt 의 길이만큼 연속해서 커지거나(같은것 포함) 연속해서 작아지거나(같은것) 포함 가능한지? 
//	 * @return 가능하면 true 반환 불가능하면 false반환
//	 */
//	public static boolean isPossible(int cnt) {	  
//		// 커지는것.
//		for (int i = 0; i < N; i++) {
//			if(arr[i] <= arr[i+1])
//		}
//		
//		// 작아지는것.
//		
//		return false;
//	}

}
