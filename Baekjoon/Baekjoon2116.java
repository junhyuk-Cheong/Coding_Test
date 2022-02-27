package feb26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2116 {

	static class Pair { // 마주보는 한쌍
		int x1, x2;

		public Pair(int x1, int x2) {
			super();
			this.x1 = x1;
			this.x2 = x2;
		}
	}

	static class Dice {
		Pair[] pairs = new Pair[3];

		public Dice(Pair[] pairs) {
			super();
			this.pairs = pairs;
		}

//		int x1, x2, x3, x4, x5, x6;	
//		public Dice(int x1, int x2, int x3, int x4, int x5, int x6) {
//			super();
//			this.x1 = x1;
//			this.x2 = x2;
//			this.x3 = x3;
//			this.x4 = x4;
//			this.x5 = x5;
//			this.x6 = x6;
//		}
	}

	static Dice[] dices;
	static int N;
	
	static int mmax = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 주사위의 개수 10,000개 이하임
		dices = new Dice[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

//			for (int j = 0; j < 6; j++) {
			Pair[] pairs = new Pair[3];
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int x3 = Integer.parseInt(st.nextToken());
			int x4 = Integer.parseInt(st.nextToken());
			int x5 = Integer.parseInt(st.nextToken());
			int x6 = Integer.parseInt(st.nextToken());
			pairs[0] = new Pair(x1, x6);
			pairs[1] = new Pair(x2, x4);
			pairs[2] = new Pair(x3, x5);
			dices[i] = new Dice(pairs);
//				dices[j] = new Dice(x1, x2, x3, x4, x5, x6);
			// 주사위의 (x1과 x6), (x2, x4), (x3, x5)는 마주보고 있음
//			}
		} // 입력완료

		int[] result = new int[6];
		for (int i = 1; i <= 6; i++) {
			mmax = 0;
			solve(0, i);
			result[i-1] = mmax;
		}
		
		Arrays.sort(result);
		System.out.println(result[5]);
	}

	static void solve(int k, int choose) { // 몇번째 주사위 인가?, 맨 밑에 깔려야 하는 숫자는 무엇인가?

		if(k == N) return;
		
		for (int i = 0; i < 3; i++) {
			if (choose == dices[k].pairs[i].x1) {
				mmax += getMax(dices[k].pairs[i].x1, dices[k].pairs[i].x2);
				solve(k+1, dices[k].pairs[i].x2);
				break;
			}
			if (choose == dices[k].pairs[i].x2) {
				mmax += getMax(dices[k].pairs[i].x1, dices[k].pairs[i].x2);
				solve(k+1, dices[k].pairs[i].x1);
				break;
			}
		}

	}
	
	static int getMax(int i, int j) { // 1~6사이중 가장 큰 값을 반환한다. 단 i, j제외
		int result = 0;
		for (int j2 = 1; j2 <= 6; j2++) {
			if(j2 == i || j2 == j) continue;
			result = Math.max(result, j2);
		}
		return result;
	}

}
