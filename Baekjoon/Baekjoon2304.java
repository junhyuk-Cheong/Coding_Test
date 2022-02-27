package feb26;

import java.io.*;
import java.util.*;

public class Baekjoon2304 {

	static class Pillar implements Comparable<Pillar> {
		int l, h;

		public Pillar(int l, int h) {
			this.l = l;
			this.h = h;
		}

		public int compareTo(Pillar o) {
			return this.l - o.l;
		}

		@Override
		public String toString() {
			return "Pillar [l=" + l + ", h=" + h + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 기둥의 개수
		Pillar[] pillars = new Pillar[N];
		int maxheight = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken()); // 기둥의 왼쪽 위치를 나타냄
			int H = Integer.parseInt(st.nextToken()); // 기둥의 높이를나타냄

			pillars[i] = new Pillar(L, H);
			maxheight = Math.max(maxheight, H);
		} // 입력완료
		Arrays.sort(pillars);
		// 정렬완료

		
		
		int result = 0;
		Pillar prev = pillars[0];
		int left = pillars[0].l;
		int right = pillars[N-1].l;
		
		// 오르막
		for (int i = 1; i < pillars.length; i++) {
			if (prev.h <= pillars[i].h) {
				result += (pillars[i].l - prev.l) * prev.h;
				if(pillars[i].h == maxheight) {
					left = pillars[i].l;
					break;
				}
				prev = pillars[i];
			}
		}
		// 제일 높은 기둥 전까지 면적구함
		
//		System.out.println(result);
		
		prev = pillars[N-1];
		// 내리막 거꾸로 접근...
		for (int i = N-2; i >= 0; i--) {
			if (prev.h <= pillars[i].h) {
				result += (prev.l - pillars[i].l) * prev.h;
				if(pillars[i].h == maxheight) {
					right = pillars[i].l;
					break;
				}
				prev = pillars[i];
			}
		}
		
//		System.out.println(result);
		
		
		
		right = right + 1;

//		System.out.println("left : " + left + " " + "right " + right);
		
		result += maxheight * (right-left);
		
		System.out.println(result);

	}

}
