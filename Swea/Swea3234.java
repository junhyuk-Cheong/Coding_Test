package feb18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea3234 {


	public static int[] selected;
	public static boolean[] isSelected;
	public static boolean[] isSelected2;
	public static int[] element;

//	public static int leftsum, rightsum;
	public static int totalcnt;
	public static int resultcnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(br.readLine());
			element = new int[N];
			isSelected = new boolean[N];
			selected = new int[N];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				element[i] = Integer.parseInt(st.nextToken());
			}

			resultcnt = 0;
			perm(0, N);

			sb.append("#").append(t).append(" ").append(resultcnt).append("\n");

			// 테케 t 의 끝
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	public static void perm(int cnt, int N) {
		if (cnt == N) {
//			System.out.println(Arrays.toString(selected));
			isSelected2 = new boolean[N];
			totalcnt = 0;
			int leftsum = 0;
			int rightsum = 0;
			solve(0, N, leftsum, rightsum);
			resultcnt += totalcnt;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i] == true)
				continue;
			selected[cnt] = element[i];
			isSelected[i] = true;
			perm(cnt + 1, N);
			isSelected[i] = false;

		}
	}

	public static void solve(int cnt, int N, int leftsum, int rightsum) {
		// must satisfy this condition : left >= right
		// true는 right 선택한것 false left 를 선택하는 것.
		if (cnt == N) {
			totalcnt++;
			return;
		}

		if (isvalid(cnt, leftsum, rightsum)) {	// 유효할때만 right를 선택함
			isSelected2[cnt] = true;
//			rightsum += selected[cnt];
			solve(cnt + 1, N, leftsum, rightsum + selected[cnt]);
//			rightsum -= selected[cnt];
		}	// 유효할때나 유효하지 않으면 left를 선택함
		isSelected2[cnt] = false;
//		leftsum += selected[cnt];
		solve(cnt + 1, N, leftsum + selected[cnt], rightsum);
//		leftsum -= selected[cnt];
	}

	public static boolean isvalid(int cnt, int leftsum, int rightsum) { // 유효하면 left를 선택할수도 있고 right를선택할수도 있지만
		// 유효하지 않으면 무조건 left을 선택해야함

		rightsum += selected[cnt];
		
		if(rightsum > leftsum) {
			rightsum -= selected[cnt];
			return false;
		}
		rightsum -= selected[cnt];
		return true;
	}



}
