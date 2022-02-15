package feb15;

import java.io.*;
import java.util.*;

public class Baekjoon2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int result = 0;
		int N = Integer.parseInt(br.readLine());

		int x, y;	// x는 5kg y는 3kg
		int xleft, yleft; // 5kg을 처리하고 남은것.
		x = N/5;
		xleft = N%5;
		y = xleft/3;
		yleft = xleft%3;
		
		if(yleft == 0) System.out.println(x+y);
		else {
			while( --x >= 0) {
				xleft = N - (x*5);
				y = xleft/3;
				yleft = xleft%3;
				
				if(yleft == 0) {
					System.out.println(x+y);
					break;
				}
			}
			if(x == -1) {
				System.out.println(-1);
			}
		}
		
		
	}

}
