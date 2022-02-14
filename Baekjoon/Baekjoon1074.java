package feb14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon1074 {

	public static int N, M;
	public static int count = 0;
	public static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] strarr = br.readLine().split(" ");
		N = Integer.parseInt(strarr[0]);
		R = Integer.parseInt(strarr[1]);
		C = Integer.parseInt(strarr[2]);
		int size = (int)Math.pow(2, N);

		zzz(R, C, size);
		System.out.println(count);
	}

	public static void zzz(int rr, int cc, int size) {
		// 기저조건
		if(size == 1) {
			return;
		}
		
		// 왼쪽위
		if( rr < size/2 && cc < size/2) {
			zzz(rr, cc, size/2);
		}
		// 오른쪽 위
		if( rr < size/2 && cc >= size/2) {
			count += size * size / 4;
			zzz(rr, cc - size/2, size/2);
		}
		// 왼쪽 아래
		if ( rr  >= size/2 && cc < size/2) {
			count += (size * size / 4) * 2;
			zzz(rr - size/2, cc, size/2);
		}
		// 오른쪽 아래
		if( rr >= size/2 && cc >= size/2) {
			count += (size * size / 4) * 3;
			zzz(rr - size/2, cc - size/2, size/2);
		}
		
		
	}



}
