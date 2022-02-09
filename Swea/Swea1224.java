package feb09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Swea1224 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 0; i < 10; i++) {
			int tlength = Integer.parseInt(br.readLine());	// 피연산자, 연산자의 총 개수 
			
			String infix = br.readLine();	
			StringBuilder postfix = new StringBuilder();
			Stack<Character> poststack = new <Character>Stack();	// 후위표기법으로 바꾸기 위한 연산자 집어넣는 용도의 stack 
			
			for (int j = 0; j < tlength; j++) {
				
				char c = infix.charAt(j);
				
				if(oplevel(c) == -2) { // 숫자임
					postfix.append(c);
				}
				
				else if(oplevel(c) == -1) {	// 닫는괄호임
					
					while(poststack.peek() != '(') { // 다음 pop 할것이 여는괄호가 나올때까지 반복한다. 
						postfix.append(poststack.pop());	// 연산자들 빼서 스트링빌더에 append
					}
					poststack.pop();	// 여는괄호는 그냥 팝해서 버린다.
				}
				
				else if(oplevel(c) == 0) {	// 여는괄호임 무조건 스택에 삽입
					poststack.push(c);
				}
				
				else {	// +, * 기호가 나왔을시 
					if(poststack.isEmpty()) poststack.push(c);	// 만일 스택이 비어있으면 덧셈이든 곱셈이든 무조건 삽입
					else { // 비어있지 않다면
						while(oplevel(poststack.peek()) >= oplevel(c) ) {	// 현재 삽입하려는 연산자가 이미 스택에 들어있는 연산자보다 우선순위가 초과할때까지 반복문을 돌림
							postfix.append(poststack.pop());
						}
						poststack.push(c); // 초과했으면 postfix 스택에 삽입함
					}
				}
				
			}
			// <!-- for -->
			while(!poststack.isEmpty()) {
				postfix.append(poststack.pop());
			}
			
			String str = new String(postfix);
			System.out.println(str);
			
			// 후위 표기법 계산 
			Stack<Integer> stack = new <Integer>Stack();
			int result = 0;
			for (int j = 0; j < str.length(); j++) {
				
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
	
	public static int oplevel(char c) {	// 숫자 반환시  -2를 반환한다. 
		
		int result = -2;
		switch (c) {
			case ')':
				result = -1;
				break;
			case'(':
				result = 0;
				break;
			case '+':
				result = 1;
				break;
			case '*':
				result = 2;
				break;
			default:
				break;
		}
		return result;
		
	}

}
