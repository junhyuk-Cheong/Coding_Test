package feb21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1759 {

	public static int L, C;
	public static char[] element;
	public static char[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken()); // 암호는
		// 서로 다른 L개의 알파벳 소문자들로 구성됨, 최소 한개의 모음과 두개의 자음으로 구성
		selected = new char[L];

		C = Integer.parseInt(st.nextToken());
		element = new char[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			element[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(element);
		comb(0, 0);
	}

	public static void comb(int cnt, int start) {
		if (cnt == L) {
			if (isitTrue()) {
				Arrays.sort(selected);
				print();
//				System.out.println(Arrays.toString(selected));
			}
			return;
		}

		for (int i = start; i < C; i++) {
			selected[cnt] = element[i];
			comb(cnt + 1, i + 1);
		}
	}

	public static boolean isitTrue() {

		int jaem = 0;
		int moem = 0;

		for (int i = 0; i < L; i++) {
			char temp = selected[i];
			if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u')
				moem++;
			if (temp != 'a' && temp != 'e' && temp != 'i' && temp != 'o' && temp != 'u')
				jaem++;
		}

		if (moem >= 1 && jaem >= 2)
			return true;
		else
			return false;
	}
	
	public static void print() {
		for (int i = 0; i < L; i++) {
			System.out.print(selected[i]);
		}
		System.out.println();
	}

}
