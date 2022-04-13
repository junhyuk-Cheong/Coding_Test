package April.apr13;

import java.io.*;
import java.util.*;

public class Baekjoon14891 {

	static class Topni {
		int[] arr;

		Topni(int[] arr) {
			this.arr = arr;
		}
	}

	static Topni[] topnis;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		topnis = new Topni[4];

		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			int[] temp = new int[8];
			for (int j = 0; j < 8; j++) {
				temp[j] = str.charAt(j) - '0';
			}
			topnis[i] = new Topni(temp);
		}
		int K = Integer.parseInt(br.readLine());

//			print_topni();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());

			visited = new boolean[4];
			solution(num, dir);
		}

		int result = 0;

		for (int i = 0; i < 4; i++) {
			if (topnis[i].arr[0] == 1) {
				result += Math.pow(2, i);
			}
		}

		System.out.println(result);
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

		if (dir == 1) { // 시계방향
			int last = tmp[7];
			for (int i = 7; i >= 1; i--) {
				tmp[i] = tmp[i - 1];
			}
			tmp[0] = last;
		} else if (dir == -1) { // 반시계 방향
			int first = tmp[0];
			for (int i = 0; i <= 6; i++) {
				tmp[i] = tmp[i + 1];
			}
			tmp[7] = first;
		}

		if (num + 1 < 4) {
			int[] tmp2 = topnis[num + 1].arr;
			if (right + tmp2[6] == 1) {
				solution(num + 1, -dir);
			}
		}

		if (num - 1 >= 0) {
			int[] tmp2 = topnis[num - 1].arr;
			if (left + tmp2[2] == 1) {
				solution(num - 1, -dir);
			}
		}
	}

}
