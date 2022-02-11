package feb11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon16926 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		int R = Integer.parseInt(temp[2]);

		int[][] arr = new int[N][M];

		for (int r = 0; r < N; r++) {
			temp = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(temp[c]);
			}
		}

		// 1. 일단 먼저 몇 파트로 나눌것인지 결정하자
		int part = (Math.min(N, M) / 2);

		for (int k = 0; k < R; k++) {
			for (int p = 0; p < part; p++) {
				// (0, 0)을 기준으로 왼쪽, 아래쪽, 오른쪽, 위쪽 순서로 처리한다.

				

				// 왼쪽 처리하자.
				int rem = arr[N - 1 - p][p]; // 왼쪽 아래 귀퉁이 기억함.
				for (int r = N - 1 - p; r > p; r--) {
					arr[r][p] = arr[r - 1][p];
				}
				// okay
				
				// 아래쪽 처리하자.
				int rem1 = arr[N - 1 - p][M - 1 - p]; // 오른쪽 아래 귀퉁이 기억함.
				for (int c = M - 1 - p; c > (p + 1); c--) {
					arr[N - 1 - p][c] = arr[N - 1 - p][c - 1];
				}
				arr[N - 1 - p][p + 1] = rem;
				// okay 
				
				
				// 오른쪽 처리하자.
				int rem2 = arr[p][M - 1 - p]; // 오른쪽 위 귀퉁이 기억
				for (int r = p; r < N - 2 - p; r++) {
					arr[r][M - 1 - p] = arr[r + 1][M - 1 - p];
				}
				arr[N - 2 - p][M - 1 - p] = rem1;

				// 위쪽 처리하자.
				for (int c = p; c < M - p -1; c++) {
					arr[p][c] = arr[p][c + 1];
				}
				arr[p][M - 2 - p] = rem2;

			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}

	}

}
