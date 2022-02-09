package feb09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Swea1210 {
//	public static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}};	// 우, 좌, 하 순 
	public static int[][] deltas2 = {{0, 1}, {0, -1}, {-1, 0}};	// 우, 좌, 상 순 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 0; i < 10; i++) {
			int t = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			int rr = -1; int cc = -1;
			
			for (int r = 0; r < 100; r++) {
				String[] str = br.readLine().split(" ");
				for (int c = 0; c < 100; c++) {
					arr[r][c] = Integer.parseInt(str[c]);
					if(arr[r][c] == 2) {
						rr = r; cc = c;
					}
				}
			}
			// 배열 구성 완료
			// 거꾸로 올라가자...
			while(true) {
				if(rr == 0) {
//					System.out.println("#" + t + " " + cc);
					bw.write("#" + t + " " + cc);
					bw.newLine();
					break;
				}
				
				for (int j = 0; j < 3; j++) {
					int nr = rr + deltas2[j][0];
					int nc = cc + deltas2[j][1]; 
					if(nr >= 0 && nc >= 0 && nr < 100 && nc < 100 && arr[nr][nc] == 1) {
						arr[rr][cc] = 0;
						rr = nr; cc = nc;
					}
				}
			}
			
			
		}
		bw.close();
	}

}
