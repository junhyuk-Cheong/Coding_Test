package feb17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon1987 {

	
	public static int R, C;	// 세로 R칸, 가로 C칸
	public static char[][] map;
	public static int[][] deltas = {{-1, 0}, {1, 0}, {0,-1}, {0,1}}; 	// 상, 하, 좌, 우
	
	public static int cnt; 
	public static int rem = Integer.MIN_VALUE; 
	
	public static Map<Character, Boolean> visited = new HashMap<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R+1][C+1];
		
		for (int i = 1; i <= R; i++) {
			String str = br.readLine();
			for (int j = 1; j <= C; j++) {
				map[i][j] = str.charAt(j-1);
				visited.put(map[i][j], false);
			}
		}
		
		visited.put(map[1][1], true);
		cnt++;
		solution(1, 1);
		System.out.println(rem);
	}
	
	public static void solution(int r, int c) {
		
//		System.out.println("r : c " + r + " " + c + " " + cnt);
		
		for (int i = 0; i < 4; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];
			
			if(nr >= 1 && nc >=1 && nr <= R && nc <= C && isvalid(map[nr][nc])) {
				cnt++;
				visited.put(map[nr][nc], true);
				solution(nr, nc);
				visited.put(map[nr][nc], false);
				cnt--;
			}
		}
		
//		System.out.println(cnt);
		if(cnt > rem) {
			rem = cnt;
		}
		return;
		
	}
	
	public static boolean isvalid(char temp) {	// 유효하면 true 유효하지 않으면 false 반환한다.
		
		if(visited.get(temp) == true) { // 유효하지 않음
			return false;
		}
		else {
			return true;
		}
	}

}
