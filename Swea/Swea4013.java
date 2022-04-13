package April.apr13;

import java.io.*;
import java.util.*;


public class Swea4013 {

	static class Topni{
		int[] arr;
		Topni(int[] arr) {
			this.arr = arr;
		}
	}
	static Topni[] topnis;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			topnis = new Topni[4];
			int K = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				int[] temp = new int [8];
				for (int j = 0; j < 8; j++) {
					temp[j] =Integer.parseInt(st.nextToken());
				}
				topnis[i] = new Topni(temp);
			}
			// 입력완료
			
			
//			print_topni();
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());

				visited = new boolean[4];
				solution(num, dir);
				
//				print_topni();
			}
			
			int result = 0;
			
			for (int i = 0; i < 4; i++) {
				if(topnis[i].arr[0] == 1) {
					result += Math.pow(2, i);
				}
			}
			
//			if(topnis[0].arr[0] == 1) {
//				result += 1;
//			}
//			if(topnis[1].arr[0] == 1) {
//				result += 2;
//			}
//			if(topnis[2].arr[0] == 1) {
//				result += 4;
//			}
//			if(topnis[3].arr[0] == 1) {
//				result += 8;
//			}
			
			sb.append("#" + t + " " + result + "\n");
			
		}	// 각각 테케별
		System.out.println(sb.toString());
	} // <!-- main -->
	
	static void print_topni() {
		
		for (int i = 0; i < 4; i++) {
			int[] tmp = topnis[i].arr;
			for (int j = 0; j < 8; j++) {
				System.out.print(tmp[j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	
	static void solution(int num, int dir) {
		
		if (visited[num]) {
			return;
		}
		visited[num] = true;
		
		int[] tmp = topnis[num].arr;
		
		int right = tmp[2];
		int left = tmp[6];
		
		if(dir == 1) { // 시계방향
			int last = tmp[7];
			for (int i = 7; i >= 1; i--) {
				tmp[i] = tmp[i-1];
			}
			tmp[0] = last;
		}else if(dir == -1) { // 반시계 방향 
			int first = tmp[0];
			for (int i = 0; i <= 6; i++) {
				tmp[i] = tmp[i+1];
			}
			tmp[7] = first;
		}
		
		if(num + 1 < 4) {
			int[] tmp2 = topnis[num+1].arr;
			if(right + tmp2[6] == 1) {
				solution(num + 1, -dir);
			}
		}
		
		if(num - 1 >= 0) {
			int[] tmp2 = topnis[num-1].arr;
			if(left + tmp2[2] == 1) {
				solution(num - 1, -dir);
			}
		}
	}
	
	

}
