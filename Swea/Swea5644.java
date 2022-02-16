package feb16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea5644 {

	public static int[][] map;
	public static int T, M, A; // 테스트 케이스 개수, 총 이동시간, BC의 개수
	public static int[] userA, userB; // 0 이동안함 1 상 2 우 3 하 4 좌
//	public static int[][] ap;
	public static Ap[] ap;

	public static int[][] deltas = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 이동안함, 상, 우, 하, 좌 순

	public static int temprembera = -1;
	public static int tempremberb = -2;

	public static class Point {
		public int x, y;
		public int sum = 0;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static class Ap implements Comparable<Ap> {
		public int x, y, crange, performance;

		public Ap(int x, int y, int crange, int performance) {
			this.x = x;
			this.y = y;
			this.crange = crange;
			this.performance = performance;
		}

		@Override
		public int compareTo(Ap o) {

			return o.performance - this.performance;
		}

	}

	// 비트마스크로 접근..?
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int sumA, sumB = 0;
			Point currA = new Point(1, 1);
			Point currB = new Point(10, 10);
			map = new int[11][11];
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 총 이동시간
			A = Integer.parseInt(st.nextToken()); // BC의 개수

//			ap = new int[A][4];	// BC의 좌표와 충전범위 영향력
			ap = new Ap[A];

			userA = new int[M + 1];
			userB = new int[M + 1];
			userA[0] = 0;
			userB[0] = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				userA[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				userB[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());

				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int crange = Integer.parseInt(st.nextToken());
				int performance = Integer.parseInt(st.nextToken());
				// ap[i][1] = Integer.parseInt(st.nextToken());
//				ap[i][0] = Integer.parseInt(st.nextToken()); // x, y 값 바꾸어줌
//				ap[i][2] = Integer.parseInt(st.nextToken()); // 충전범위
//				ap[i][3] = Integer.parseInt(st.nextToken()); // 성능
				ap[i] = new Ap(x, y, crange, performance);
			}

			// 입력다 받음

			// 본격적으로 map 생성하자

//			for (int i = 0; i < A; i++) {
//				int x = ap[i][0];
//				int y = ap[i][1];
//				map[x][y] =  map[x][y]  | (1 << i);
//				
//				
//				for (int j = ap[i][2]; j >= 0; j--) {
//					int nr = x + j*deltas[1][0];
//					int nc = y + j*deltas[1][1];
//					
//					if(nr >= 1 && nc >= 1 && nr < 11 && nc < 11) {
//						map[nr][nc] = map[nr][nc] | (1<<i);
//					}
//					
//					for (int k = 0; k < 1; k++) {
//						
//					}
//					
//				}
//				
//				
//				int nr = x + ap[i][2]*deltas[1][0];
//				int nc = y + ap[i][2]*deltas[1][1];
//				
//				if(nr >= 1 && nc >= 1 && nr < 11 && nc < 11) {
//					map[nr][nc] = map[nr][nc] | (1<<i);
//				}
//					
//			}

			//////////////////// map 생성완료

			// AP 정렬할것 성능순으로 /////////////////////
			Arrays.sort(ap);
//			for (int j = 0; j < A; j++) {
//				System.out.println(ap[j].performance);
//				
//			}
			///////////////////////////

			////////////////////////////

			// 초기조건 계산해야함

			for (int i = 0; i <= M; i++) {
				ArrayList<Integer> lista = new ArrayList<Integer>();
				ArrayList<Integer> listb = new ArrayList<Integer>();
				
				
				currA.x = currA.x + deltas[userA[i]][0];
				currA.y = currA.y + deltas[userA[i]][1];

				currB.x = currB.x + deltas[userB[i]][0];
				currB.y = currB.y + deltas[userB[i]][1];

				for (int j = 0; j < A; j++) {
//					System.out.println("#" + i + " " + currA.x + " " + currA.y);

					int temp = Math.abs(currA.x - ap[j].x) + Math.abs(currA.y - ap[j].y);
					if (temp <= ap[j].crange) {
//						currA.sum += ap[j].performance;
//						temprembera = j;
//						break;
						lista.add(j);
					}

				} // <-- for -->

				for (int j = 0; j < A; j++) {
//						System.out.println("#" + i + " " + currB.x + " " + currB.y);

					int temp = Math.abs(currB.x - ap[j].x) + Math.abs(currB.y - ap[j].y);
					if (temp <= ap[j].crange) {
						
//						currB.sum += ap[j].performance;
//						tempremberb = j;
//						break;
						listb.add(j);
					}

				} // <-- for -->
				
				
				// 1. 둘다 없는경우 패스 
				// 2. 둘중 하나는 있는경우 (a는 비었고 b는 있는 경우)
				if(lista.isEmpty() && !listb.isEmpty()) {
					currB.sum += ap[listb.get(0)].performance;
				}
				// 3. 둘중 하나는 있는경우 (b는 비었고 a는 있는 경우)
				else if(!lista.isEmpty() && listb.isEmpty()) {
					currA.sum += ap[lista.get(0)].performance;
				}
				
				// 4. 둘다 사이즈 1인경우 
				else if(lista.size() == 1 && listb.size() == 1) {
					// 만일 둘다 같은애면 절반씩 잘라서 넣기
					if(lista.get(0) == listb.get(0)) {
						currA.sum += ap[lista.get(0)].performance/2;
						currB.sum += ap[listb.get(0)].performance/2;
					}
					else {
						currA.sum += ap[lista.get(0)].performance;
						currB.sum += ap[listb.get(0)].performance;
					}
					
				}
				else if(lista.size() == 1 && listb.size() >= 2) {
					currA.sum += ap[lista.get(0)].performance;
					currB.sum += ap[listb.get(1)].performance;
				}
				else if(lista.size() >= 2 && listb.size() == 1) {
					currA.sum += ap[lista.get(1)].performance;
					currB.sum += ap[listb.get(0)].performance;
				}
				else if(lista.size() >= 2 && listb.size() >= 2) { // 둘다 사이즈 2이상이면 
					
					//1. 첫번째 원소 같으면 
					if(lista.get(0) == listb.get(0)) {
						// 두번째 원소 비교해서 큰 놈 
						if(lista.get(1) < listb.get(1)) { // b의 두번째 원소가 더 크다면 
							currA.sum += ap[lista.get(0)].performance;
							currB.sum += ap[listb.get(1)].performance;
						}
						else if(lista.get(1) > listb.get(1)){	// a의 두번재 원소가 더 크다면 
							currA.sum += ap[lista.get(1)].performance;
							currB.sum += ap[listb.get(0)].performance;
						}
						else { // 두번째 원소마저 같다면
							currA.sum += ap[lista.get(0)].performance;
							currB.sum += ap[listb.get(1)].performance;
						}
					}
					//2. 첫번재 원소가 같지 않으면
					else {
						currA.sum += ap[lista.get(0)].performance;
						currB.sum += ap[listb.get(0)].performance;
					}
					
				}
				
			
				
				
				
				
//				// 진짜
//				if (temprembera == tempremberb) {
//					currA.sum -= ap[temprembera].performance / 2;
//					currB.sum -= ap[tempremberb].performance / 2;
//				}

//				System.out.println("#" + i + " " + currA.sum + " " + currB.sum);

				
				
				
			} // <-- for >

			System.out.println(currA.sum + currB.sum);

		}

	}

}
