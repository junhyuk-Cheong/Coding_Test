package feb10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon2563 {
	// 색종이의 왼쪽 하단 꼭짓점이 바로 두번째 줄 부터 주어지는 것.
	// 색종이의 가로, 세로의 변의 길이는 10임 
	// 전체 도화지의 크기는 100 * 100임
	// 풀이방법 일단 하나의 색종이가 들어오면 넓이를 구해서 static sum 변수에 추가 
	// 두번째 색종이오면 첫번째랑 겹치는 부분 빼서 더하기 
	// 세번째 색종이오면 첫번째 두번째랑 겹치는 부분 빼서 더하기 시간복잡도 n^2..?
	// ㄴㄴ비효율적으로 위방법 말고  2차원 배열에 1 박아놓은 다음에 1 의 개수 세면 될지도..?
	public static int[][] arr = new int[100][100];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());	// T는 색종이의 개수 
		for (int i = 0; i < T; i++) {
			String[] strarr = br.readLine().split(" ");
			int x = Integer.parseInt(strarr[0]);
			int y = Integer.parseInt(strarr[1]);
			
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					arr[100-y-1-j][x+k] = 1;
				}
			}
		}// <!--for (int i = 0; i < T; i++)-->
		
		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(arr[i][j] == 1)
					count++;
			}
		}
		System.out.println(count);
		br.close();
	}

}
