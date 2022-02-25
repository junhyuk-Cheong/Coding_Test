package feb25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon2628 {

	// 가로점선을 자르는 경우는 종이의 왼쪽 끝에서 오른쪽 끝까지
	// 세로 점선인 경우는 위쪽끝에서 아래쪽 끝까지 한번에 자른다고 한다. 
	
	static int W, L;
	static int result = 0;
	static class rect implements Comparable<rect>{
		int w1, w2, l1, l2;
		int w, l, area;
		
		public rect(int w1, int w2, int l1, int l2) {
			this.w1 = w1;
			this.w2 = w2;
			this.l1 = l1;
			this.l2 = l2;
			
			this.w = w2 - w1;
			this.l = l2 - l1;
			this.area = w*l;
		}
		public int compareTo(rect o){
			return o.area - this.area;
		}
		@Override
		public String toString() {
			return "rect [w1=" + w1 + ", w2=" + w2 + ", l1=" + l1 + ", l2=" + l2 + ", w=" + w + ", l=" + l + ", area="
					+ area + "]";
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());	// 종이의 가로의 길이
		L = Integer.parseInt(st.nextToken());	// 종이의 세로의 길이 
		int T = Integer.parseInt(br.readLine()); // 칼로 잘라야 할 점선의 개수
		
		ArrayList<rect> rects = new ArrayList<>();
		rects.add(new rect(0, W, 0, L));
		
		
		for (int i = 0; i < T; i++) {
			ArrayList<rect> temps = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < rects.size(); j++) {
				
				if(dir == 1) { //  세로방향으로 자름 (실제 자르는건 가로)
					if(rects.get(j).w1 < num && num < rects.get(j).w2) {
						temps.add(new rect(rects.get(j).w1, num, rects.get(j).l1, rects.get(j).l2));
						temps.add(new rect(num, rects.get(j).w2, rects.get(j).l1, rects.get(j).l2));
					}
					else {
						//  아무일 안하면 된다.
						temps.add(rects.get(j));
					}
					
				}
				else{	// 가로방향으로 자름 (실제 자르는건 세로)
					if(rects.get(j).l1 < num && num < rects.get(j).l2) {
						temps.add(new rect(rects.get(j).w1, rects.get(j).w2, rects.get(j).l1, num));
						temps.add(new rect(rects.get(j).w1, rects.get(j).w2, num, rects.get(j).l2));
					}
					else {
						//  아무일 안하면 된다.
						temps.add(rects.get(j));
					}
				}
			}	// <!--for-->
			
			rects = new ArrayList<>();
			for (int j = 0; j < temps.size(); j++) {
				rects.add(temps.get(j));
			}
			
			
//			for (int j = 0; j < rects.size(); j++) {
//				System.out.println(rects.get(j));
//			}
//			System.out.println();
		} // <!-- 한번의  for문 --->
		
		Collections.sort(rects);
		
		System.out.println(rects.get(0).area);
		
		
		
	}

}
