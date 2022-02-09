package feb09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Swea3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) { // 각각 테케
			int N = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			
			Queue<String> q1 = new LinkedList<String>();
			Queue<String> q2 = new LinkedList<String>();
			
			int j = 0;
			for (j = 0; j < ((N%2 == 0) ? N/2 : N/2+1) ; j++) {
				q1.offer(arr[j]);
			}
			for (; j < N ; j++) {
				q2.offer(arr[j]);
			}
			// 큐에 삽입 완료
			bw.write("#" + (i+1) + " ");
			while(!q2.isEmpty()) {
				bw.write(q1.poll() + " " + q2.poll() + " ");
			}
			if(!q1.isEmpty()) {
				bw.write(q1.poll());
			}
			bw.newLine();
		}
		bw.close();
		br.close();

	}

}
