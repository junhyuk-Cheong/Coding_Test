package April.apr29;

import java.io.*;
import java.util.*;

class Solution {
    
    static boolean[][] adjMatrix;
    static boolean[] visited; 
    
    public int solution(int n, int[][] results) {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        adjMatrix = new boolean[n+1][n+1];
        
        for(int i = 0; i < results.length; i++){
            int to = results[i][0];
            int from = results[i][1];
            adjMatrix[from][to] = true;
        }
        
        int answer = 0; 
        for(int i = 1; i <= n; i++){
            int cnt = 0;
            visited = new boolean[n+1];
            
            cnt += bfs(i, n);
            cnt += rbfs(i, n);
            
            if(cnt == n-1) answer++;
        }
                                    
        return answer;
    }
    
    static int rbfs(int start, int n){
        int result = 0;
        // boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<Integer>();
        ///
        // if(visited[start]) return result;
        ///
        visited[start] = true;
        // result++;
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            
            for(int i = 1; i <= n; i++){
                if(!visited[i] && adjMatrix[i][curr] != false){
                    visited[i] = true;
                    result++;
                    queue.offer(i);
                }
            }
        }
        
        return result;
    }
    
    
    static int bfs(int start, int n){
        int result = 0;
        // boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<Integer>();
        ///
        // if(visited[start]) return result;
        ///
        visited[start] = true;
        // result++;
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            
            for(int j = 1; j <= n; j++){
                if(!visited[j] && adjMatrix[curr][j] != false){
                    visited[j] = true;
                    result++;
                    queue.offer(j);
                }
            }
        }
        
        return result;
    }
}