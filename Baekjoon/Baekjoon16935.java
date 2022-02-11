package feb11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon16935 {

	public static int N, M, R;
	public static int[][] map;

	public static void swap(int r, int c, int r1, int c1) {
		int tmp = 0;
		tmp = map[r][c];
		map[r][c] = map[r1][c1];
		map[r1][c1] = tmp;
	}

	public static void op1(int part) { // 배열 상하 반전시키기

			for (int c = 0; c < M; c++) {
				for (int r = 0; r < (N / 2); r++) {
					swap(r, c, N - 1 - r, c);
				}
			}

	}

	public static void op2(int part) { // 배열 좌우 반전시키기

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < (M / 2); c++) {
					swap(r, c, r, M - 1 - c);
				}
			}

	}

	public static void op3(int part) { // 오른쪽으로 90도 회전


			int[][] result = new int[Math.max(M, N)][Math.max(M, N)];

			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					result[r][c] = map[N - 1 - c][r];
				}
			}

			int tmp;
			tmp = M;
			M = N;
			N = tmp;
			map = result;

	}

	public static void op4(int part) {


			int[][] result = new int[Math.max(M, N)][Math.max(M, N)];

			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					result[r][c] = map[c][M - 1 - r];
				}
			}

			int tmp;
			tmp = M;
			M = N;
			N = tmp;
			map = result;

	}

	public static void op5(int part) {

			int[][] wn = new int[N / 2][M / 2];
//		int[][] en = new int[N/2][M/2];
//		int[][] es = new int[N/2][M/2];
//		int[][] ws = new int[N/2][M/2];

			for (int r = 0; r < N / 2; r++) {
				for (int c = 0; c < M / 2; c++) {
					wn[r][c] = map[r][c];
				}
			}

			// 왼쪽
			for (int r = N / 2; r < N; r++) {
				for (int c = 0; c < M / 2; c++) {
					map[r - N / 2][c] = map[r][c];
				}
			}

			// 밑에쪽
			for (int r = N / 2; r < N; r++) {
				for (int c = M / 2; c < M; c++) {
					map[r][c - M / 2] = map[r][c];
				}
			}

			// 오른쪽
			for (int r = 0; r < N / 2; r++) {
				for (int c = M / 2; c < M; c++) {
					map[N / 2 + r][c] = map[r][c];
				}
			}

			// 맨 위쪽
			for (int r = 0; r < N / 2; r++) {
				for (int c = 0; c < M / 2; c++) {
					map[r][M / 2 + c] = wn[r][c];
				}
			}

	}

	public static void op6(int part) {


			int[][] wn = new int[N / 2][M / 2];

			for (int r = 0; r < N / 2; r++) {
				for (int c = 0; c < M / 2; c++) {
					wn[r][c] = map[r][c];
				}
			}

			// 위쪽
			for (int r = 0; r < N / 2; r++) {
				for (int c = M / 2; c < M; c++) {
					map[r][c - M/2] = map[r][c];
				}
			}

			// 오른쪽
			for (int r = N / 2; r < N; r++) {
				for (int c = M / 2; c < M; c++) {
					map[r - N/2][c] = map[r][c];
				}
			}

			// 밑에쪽
			for (int r = N / 2; r < N; r++) {
				for (int c = 0; c < M/2; c++) {
					map[r][c + M/2] = map[r][c];
				}
			}

			// 왼쪽
			for (int r = 0; r < N/2; r++) {
				for (int c = 0; c < M/2; c++) {
					map[r + N/2][c] = wn[r][c];
				}
			}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		int part = Math.min(N, M); // 몇번 돌려야 하는가?

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			int op = Integer.parseInt(st.nextToken());

			switch (op) {
			case 1:
				op1(part);
				break;
			case 2:
				op2(part);
				break;
			case 3:
				op3(part);
				break;
			case 4:
				op4(part);
				break;
			case 5:
				op5(part);
				break;
			case 6:
				op6(part);
				break;

			default:
				break;
			}
			
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}

	}

}
