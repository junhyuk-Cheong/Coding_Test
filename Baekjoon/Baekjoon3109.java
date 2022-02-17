package feb17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// R * C 격자, 첫째열은 근처 빵집의 가스관 , 마지막 열은 원웅이의 빵집 
// 원웅이가 설치할 수 있는 가스관과 빵집을 연결하는 파이프라인의 최대 개수를 구하라
// 단 파이프라인은 오른쪽, 오른쪽위, 오른쪽아래로만 이동가능
public class Baekjoon3109_4 {

	public static int R, C;
	public static char[][] map;
	
	public static int[][] deltas = { {-1, 1}, {0, 1}, {1,1} }; // 오른쪽 위, 오른쪽, 오른쪽 아래 순
	
	public static int cnt;
	public static int max = Integer.MIN_VALUE;
	public static boolean[][] visited;

	public static boolean flag;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		visited = new boolean[R][C];
		
		for (int i = 1; i <= R; i++) {
			flag = false;
			setpipe(i, 0);
		}
		
		System.out.println(cnt);
	}
	
	public static void setpipe(int r, int c) {
		
		if(c == C-1) {
			cnt++;
			flag = true;
			return;
		}
	
		for (int i = 0; i < 3; i++) {
			
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];
			
			if(nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] == '.') {
//				visited[nr][nc] = true;
				if(flag == true) {
					
					break;
				}
				map[nr][nc] = 'x';
				setpipe(nr, nc);
//				visited[nr][nc] = false;
			}
			
		}
		
	}

}
