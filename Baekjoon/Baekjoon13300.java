package feb25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon13300 {
	// 정보초교에서 단체로 수학여행을 가는데 남학생들은 남학생들끼리, 여학생들은 여학생들끼리 방을 배정하기로 함
	// 한방에는 같은 학년의 학생들을 배정해야함. 한방에 한명 가능
	// K: 한방에 배정할 수 있는 최대 인원 수
	// 필요한 방의 최소 개수를 구하여라

	static int N, K; // 수학여행에 참가하는 학생 수 , 한방에 배정할 수 있는 최대 인원수

	/**
	 * 16 2 1 1 0 1 1 1 0 2 1 2 0 2 0 3 1 3 1 4 1 3 1 3 0 6 1 5 0 5 1 5 1 6
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[][] students = new int[6][2];	// 학년, 성별
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken()); // 0이면 여자, 1이면 남학생
			int grade = Integer.parseInt(st.nextToken()); // 학생의 학년
			students[grade-1][sex]++;
		} // 입력완료
		
		int cnt = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				if(students[i][j] == 0) continue;
				cnt+= (students[i][j] % K == 0 ? students[i][j]/K : students[i][j]/K + 1);
			}
		}
		
		System.out.println(cnt);
		

	}

}
