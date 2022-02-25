package feb25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2635 {

	public static int N;
	public static int mmax = 2;	// 큰수가 나왔을때
//	public static int[] result;
	public static ArrayList<Integer> selected;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		
		
		int cnt = 0;
		int remember = 0;
		for (int i = 1; i <= N; i++) {
			int first = N;
			int second = i;
			cnt = 2;
			
			int temp;
			while((temp = first - second) >= 0) {
				first = second;
				second = temp;
				cnt++;
			}
			
			if(cnt > mmax) {
				mmax = cnt;
				remember = i;
			}
		}
		
		
		selected = new ArrayList<Integer>();
		selected.add(N);
		selected.add(remember);
		int first = N;
		int second = remember;
		int temp;
		while((temp = first - second) >= 0) {
			selected.add(temp);
			first = second;
			second = temp;
		}
		
		System.out.println(mmax);
		for ( int s : selected) {
			System.out.print(s + " ");
		}
		
//		for (int i = 1; i <= 100; i++) {
//			int first = N;
//			int second = i;
//			selected = new ArrayList<Integer>();
//			selected.add(N);
//			selected.add(i);
//			
//			int temp;
//			while((temp = first - second) >= 0) {
//				selected.add(temp);
//				first = second;
//				second = temp;
//			}
//		}
	}

}
