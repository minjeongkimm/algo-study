import java.io.*;
import java.util.*;

class Solution {
    
    int N, M;
    
    // 상 우 하 좌
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    
    int[][] dist;
    Queue<int[]> q;
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        
        dist = new int[N][M];
        
        q = new LinkedList<int[]>();
        q.add(new int[]{0, 0});
        dist[0][0] = 1;
        
        bfs(maps);
        if(dist[N-1][M-1] == 0) return -1;
        else return dist[N-1][M-1];
    }
    
    public void bfs(int[][] maps){
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                
                if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
                if(maps[nr][nc] == 0) continue;
                if(dist[nr][nc] != 0) continue;
                
                dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
                q.add(new int[]{nr, nc});

                if(nr == N-1 && nc == M-1) return;  
                
                
            }
        }
    }
}