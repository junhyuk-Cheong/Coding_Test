package March.mar16;

import java.io.*;
import java.util.*;

public class Baekjoon11723 {

	
	
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new HashSet<>();
		
		for (int i = 1; i <= t; i++) {
			
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			if(str.equals("add")) {
				int temp = Integer.parseInt(st.nextToken());
				if(!set.contains(temp)) {
					set.add(temp);
				}
			}
			else if(str.equals("check")) {
				int temp = Integer.parseInt(st.nextToken());
				if(set.contains(temp)) {
					bw.write(1 + "");
					bw.newLine();
				}
				else {
					bw.write(0 + "");
					bw.newLine();
				}
			}
			else if(str.equals("remove")) {
				int temp = Integer.parseInt(st.nextToken());
				if(set.contains(temp)) {
					set.remove(temp);
				}
			}
			else if(str.equals("toggle")) {
				int temp = Integer.parseInt(st.nextToken());
				if(set.contains(temp)) {
					set.remove(temp);
				}
				else {
					set.add(temp);
				}
			}
			else if(str.equals("all")) {
				set.clear();
				for (int j = 1; j <= 20; j++) {
					set.add(j);
				}
			}
			else if(str.equals("empty")) {
				set.clear();
			}
			
			
			
		}
		
		br.close();
		bw.close();

	}

}
