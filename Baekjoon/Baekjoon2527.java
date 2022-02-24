package feb22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon2527 {
	// 모든 직사각형은 두 꼭짓점의 좌표 x, y, p, q로 표현됨, 단 항상 x < p, y < q이다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken());
			int y3 = Integer.parseInt(st.nextToken());
			int x4 = Integer.parseInt(st.nextToken());
			int y4 = Integer.parseInt(st.nextToken());
			
			
			// 겹칠때 먼저 생각하자.
			if ((x2 == x3 && y2 == y3) || (x3 == x2 && y1 == y4) || (x1 == x4 && y1 == y4) || (x1 == x4 && y3 == y2)) {
				bw.write("c");
				bw.newLine();
			}
			else if((x2 == x3 && y2 != y3) || (x3 != x2 && y1 == y4) || (x1 != x4 && y1 == y4) || (x1 == x4 && y3 != y2)) {
				bw.write("b");
				bw.newLine();
			}
			else if(x2 < x3 || x4 < x1 || y2 < y3 || y4 < y1) {
				bw.write("d");
				bw.newLine();
			}
			else {
				bw.write("a");
				bw.newLine();
			}
		
		}
		br.close();
		bw.close();
		
		
	}	// 각각의 테스트 케이스 여기선 총 4개이다.
		

}
	
