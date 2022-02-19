package feb18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Baekjoon15683_3 {
	// 사각지대의 최소 크기를 출력
	
	static int [][][] watchDirs = {
			{},	// 0번 타입
			{ {0}, {1}, {2}, {3} }, // 1번 타입  : 상, 하, 좌, 우 순
			{ {0, 1}, {2, 3} },	// 2번 타입
			{ {0,2}, {2,1}, {1,3}, {3,0} },  // 3번 타입
			{ {0,1,2}, {0,1,3}, {0,2,3}, {1,2,3} }, //4번 타입,
			{{0,1,2,3}} // 5번 타입
	};
	
	static int [][] deltas = {{-1, 0}, {1, 0}, {0, 1}, {0, -1} };
	static int N, M, Min;
	static int [][] map;
	
	
	// 관리할 CCTV 목록들
	static List<CCTV> cctvs;
	
	// 초기 상태에서 관리해야 할 지점의 개수
	static int whiteArea = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사무실의 세로 크기 N
		M = Integer.parseInt(st.nextToken()); // 사무실의 가로 크기 M

		map = new int[N][M];
		cctvs = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				//CCTV 발견!!
				if(map[r][c] > 0 && map[r][c] < 6) {
					cctvs.add(new CCTV(r, c, map[r][c]));  
				}else if(map[r][c] == 0) {
					whiteArea++;
				}
					
			}
		}
//		System.out.println("white area: "+whiteArea+", cctv : "+cctvs);
		// 입력완료
		
		Min = Integer.MAX_VALUE;
		dfs(0, 0);
		System.out.println(Min);
	}
	
	static void dfs(int ccctvIdx, int clearSpot) {
		// 기저조건 
		if(ccctvIdx == cctvs.size()) {
			// 그럼 현 시점에서의 최소 사각은?
			Min = Math.min(Min, whiteArea - clearSpot);
			return;
		}
		
		
		//1. CCTV 한대를 가져온다. --> 그 CCTV가 볼 수 있는 방향으로 회전시킨다.
		CCTV cctv = cctvs.get(ccctvIdx);
		for (int d = 0; d < watchDirs[cctv.t].length; d++) {
			// 이때의 방향
			int [] dirs = watchDirs[cctv.t][d];
			// 그 dirs 방향으로 찾아보기	--> 맵 오염
			
			int scaned = scan(cctv, dirs, -1);
			dfs(ccctvIdx + 1, clearSpot + scaned);
			
			// dirs 방향에 대해서 맵 원복
			scan(cctv, dirs, 1);
		}
	}
	/**
	 * 
	 * @param cctv - 사용할 CCTV
	 * @param dirs - 그 CCTV가 보는 방향 정
	 * @param flag - 오염(-1), 원복(+1)
	 * @return 현재의 CCTV가 볼 수 있는 방향에서 처리할 수 있는 영역의 개수
	 */
	static int scan(CCTV cctv, int [] dirs, int flag) {
		int cnt = 0;
		for (int d = 0; d < dirs.length; d++) {
			for (int i = 1;  ; i++) {
				int nr = cctv.r + deltas[dirs[d]][0]*i;
				int nc = cctv.c + deltas[dirs[d]][1]*i;
				
				if( !isIn(nr, nc) || map[nr][nc] == 6)
					break;
				// 다른 CCTV - 생략하고 다음꺼 체크하러 가기
				if(map[nr][nc] > 0) {
					continue;
				}
				// 사각해소 지역 증가.
				if(map[nr][nc] == 0) {
					cnt++;
				}
				map[nr][nc] += flag;
			}
		}
		return cnt;
	}
	
	static boolean isIn(int r, int c) {
		return 0<= r && r < N && 0 <= c && c < M;
	}
	
	
	static class CCTV{
		int r, c, t;

		public CCTV(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}

		@Override
		public String toString() {
			return "CCTV [r=" + r + ", c=" + c + ", t=" + t + "]";
		}
		
		
	}
	


	

}
