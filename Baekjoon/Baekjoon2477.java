package feb19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon2477 {
	// 1m^2 에 자라는 참외의 개수 먼저 헤아리기 
	// 그 다음 참외밭의 넓이를 구하기 그러면 비례식을 이용해 참외의 총개수를 구할 수 있음
	// 참외밭은 ㄱ자랑 ㄱ자 90, 180, 270 회전한 모양의 육각형
	public static int K; // 1제곱미터에 자라는 참외의 개수
	
	public static class line implements Comparable<line>{
		int d;
		int length;

		public line(int d, int length) {
			super();
			this.d = d;
			this.length = length;
		}
		
		@Override
		public int compareTo(line o) {
			return o.length - this.length;
		}
	}
	
	public static int[][] lines = new int[6][2];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());

		// 키 포인트 바로 직각이된다. 반시계 방향이다.
		// 그림을 몇번 그려보자 
		// 그러면 규칙이 나온다.
		// 그 규칙은 바로 가장 가장 긴변은 방향이 같은 두변의 합으로 무조건 구성된다는것.
		// 그럼 그 남은 떨거지들 중에서 가장 긴변을 구하고 그 긴변은 나머지 두개 의 합으로 이루어진다.
		// 또 고려해야할것이 하나 그리면 바로 그 다음은 자신과 수직인 변이다.
		// 또 고려해야할것이 둘 그리면 바로  그것은 자신과 수평인 변이다.
		int maxlength = Integer.MIN_VALUE;
		int maxi = -1;
		for (int i = 0; i < 6; i++) {	// 1: 동 2 :서 3 :남 4 : 북
			st = new StringTokenizer(br.readLine());
			lines[i][0] = Integer.parseInt(st.nextToken());
			lines[i][1] = Integer.parseInt(st.nextToken());
			if(maxlength < lines[i][1]) {
				maxlength = lines[i][1];
				maxi = i;
			}
//			Math.max(lines[i][0], maxlength);
		}
		
		int rect = 0;
		
		int i, j;
		if(maxi == 0) {
			i = 5;
			j = 1;
		}
		else if(maxi == 5) {
			i = 4;
			j = 0;
		}
		else {
			i = maxi - 1;
			j = maxi + 1;
		}
		
		int maxnextmaxi;
		int maxnextmini;
		if(lines[i][1] > lines[j][1]) {
			maxnextmaxi = i;
			maxnextmini = j;
		}
		else {
			maxnextmaxi = j;
			maxnextmini = i;
		}
		
		rect = maxlength * Math.max(lines[i][1], lines[j][1]);
		
		int diff = maxi - maxnextmini;	// 이게문제 
		if(diff > 1) {
			diff = -1;
		}
		else if ( diff < -1) {
			diff = 1;
		}
		int next = maxnextmini - diff;
		
		if(next == -1) {
			next = 5;
		}
		else if(next == 6) {
			next = 0;
		}
		
		int minus = lines[next][1] * (lines[maxnextmaxi][1] - lines[maxnextmini][1]);
		
//		System.out.println(rect);
//		System.out.println(maxnextmaxi);
//		System.out.println(maxnextmini);
//		System.out.println(minus);
		int result = (rect - minus) * K;
		
		System.out.println(result);
		
	}

}
