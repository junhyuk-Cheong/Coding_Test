package feb09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Swea1223 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 0; i < 10; i++) {
			int tlength = Integer.parseInt(br.readLine());
			
			String infix = br.readLine();
			StringBuilder postfix = new StringBuilder();
			Stack<Character> poststack = new <Character>Stack();	// 후위표기법으로 바꾸기 위한 연산자 집어넣는 용도의 stack 
			
			for (int j = 0; j < tlength; j++) {
				
				if(infix.charAt(j) == '+') {
					
					if(poststack.isEmpty()) poststack.push('+');
					else {
						while(!poststack.isEmpty()) {
							postfix.append(poststack.pop());
						}
						poststack.push('+');
					}
					
				}
				else if(infix.charAt(j) == '*') {
					
					
					if(poststack.isEmpty()) poststack.push('*');
					else {
						if(poststack.peek() == '+') {
							poststack.push('*');
						}
						else {
							while(!poststack.isEmpty() && poststack.peek() == '+') {
								postfix.append(poststack.pop());
							}
							postfix.append("*");
						}
					}
					
				}
				else {	// 숫자일때 
					postfix.append(infix.charAt(j));
				}
			}
			// <!-- for -->
			while(!poststack.isEmpty()) {
				postfix.append(poststack.pop());
			}
			
			String str = new String(postfix);
			
			// 후위 표기법 계산 
			Stack<Integer> stack = new <Integer>Stack();
			int result = 0;
			for (int j = 0; j < tlength; j++) {
				
				if(str.charAt(j) == '+') {
					stack.push(stack.pop() + stack.pop());
				}
				else if(str.charAt(j) == '*') {
					stack.push(stack.pop() * stack.pop());
				}
				else {
					stack.push(str.charAt(j) - '0');
				}
			}
			
			bw.write("#" + (i+1) + " " + stack.pop());
			bw.newLine();
		}
		bw.close();
	}

}
