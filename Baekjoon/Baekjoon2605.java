package feb19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Baekjoon2605 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> students = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int idx = students.size();
			int temp = Integer.parseInt(st.nextToken());
			students.add(idx-temp, i);
		}
		for (int i = 0; i < N-1; i++) {
			sb.append(students.get(i)).append(" ");
		}
		sb.append(students.get(N-1));
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}
