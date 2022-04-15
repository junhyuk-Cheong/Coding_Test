package April.apr15;

import java.util.*;
import java.io.*;

//System.out.println();

class ProgrammersBruteForce2 {
    
    static char[] element;  // 전체 원소
    static char[] selected; // 선택된 
    static boolean[] isSelected; // 선택되었는가?
    static int N, R; 
    static int count = 0;
    static Set<Integer> sosuset = new HashSet<Integer>();
    
    public int solution(String numbers) {
        int answer = 0;
        N = numbers.length();
        element = new char[N];
        
        for(int i = 0; i < N; i++){
            element[i] = numbers.charAt(i);
        }
        
        for(int r = 1; r <= N; r++){
            R = r;
            selected = new char[R];
            isSelected = new boolean[N];
            Perm(0);
        }
        
        // answer = count;
        answer = sosuset.size();
        return answer;
    }
    
    public void Perm(int cnt){
        
        if(cnt == R){
            // System.out.println(Arrays.toString(selected));
            if(isSosu()) count++;
            
            return;
        }
        
        for(int i = 0; i < N; i++){
            if(isSelected[i]) continue;
            isSelected[i] = true;
            selected[cnt] = element[i];
            Perm(cnt + 1);
            isSelected[i] = false;
        }
        
        return;
    }
    
    public boolean isSosu(){
        String str = new String(selected);
        int tmp = Integer.parseInt(str);
        // System.out.println(tmp);
        
        if(tmp <= 1) return false;

        boolean flag = false;
        for(int i = 2; i < tmp; i++){
            if( tmp % i == 0){
                flag = true;
                break;
            }
        }
        if(flag){ // 소수가 아니다.
            return false;
        }else{ // 소수이다.
            sosuset.add(tmp);
            return true;
        }
    
    }
    
    
    
}