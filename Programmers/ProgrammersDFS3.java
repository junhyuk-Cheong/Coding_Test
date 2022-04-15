package April.apr15;

import java.util.*;
import java.io.*;

class Solution {
    // System.out.println();
    public static int[] nodes;
    public static int[][] arr;
    public static int end;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int len = words.length;
        nodes = new int[len + 1];
        arr = new int[len+1][len+1];
        
        boolean flag = false;
        for(int i = 0; i < len; i++){
            if(words[i].equals(target)){
                end = i;
                flag = true;
                break;
            }
        }
        
        if(!flag) return 0;
        
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                if(possible(words[i], words[j])){ // 한개의 알파벳을 바꿀수 있는가
                    arr[i][j] = 1;
                    arr[j][i] = 1;
                }                
            }
        }
        
        for(int i = 0; i < len; i++){
           if(possible(words[i], begin)){ // 한개의 알파벳을 바꿀수 있는가
                    arr[i][len] = 1;
                    arr[len][i] = 1;
            }   
        }
        
        answer = bfs(new Point(len, 0), len+1);
        return answer;
    }
    
    // 한개의 알파벳을 바꿀수 있는가 바꿀수 있으면 true 그렇지 않으면 false   
    public static boolean possible(String a, String b){
        if(a.length() != b.length()) return false;
        
        int cnt = 0; // 알파벳이 다를수록 1씩 증가 
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) !=  b.charAt(i)){
                cnt++;
            }
        }
        
        if(cnt >= 2)  return false;
        else{
            return true;
        }
        
    }
    
    public static class Point{
        int num, level;
        Point(int num, int level){
            this.num = num;
            this.level = level;
        }
    }
    
    public static int bfs(Point snode, int len){   

        int result = 0;
        boolean[] visited = new boolean[len];
        Queue<Point> queue = new LinkedList<Point>();
        visited[snode.num] = true;
        queue.offer(snode);
        
        while(!queue.isEmpty()){
            Point curr = queue.poll();
          
            if(curr.num == end){
                result = curr.level;
                break;
            }
            
            for(int i = 0; i < len; i++){
                if(!visited[i] && arr[curr.num][i] == 1){
                    visited[i] = true;
                    queue.offer(new Point(i, curr.level + 1));   
                }
            }
        }
        
        return result;
        
    }
    
    
}