
import java.io.*;
import java.util.*;

class Solution {
    
    String numbers;
    boolean[] visited;
    HashSet<Integer> set = new HashSet<>();
    
    
    public int solution(String numbers) {
        this.numbers = numbers;
        visited = new boolean[numbers.length()];
        
        dfs("");
        
        int answer = 0;
        for(int i : set){
            if(isPrime(i)) answer++;
        } 
        
        return answer;
    }
    
    public void dfs(String cur){
        //1. 비어있는지 체크
        //1-1. 비어있지 않으면 집합에 저장
        if(!cur.isEmpty()){
            set.add(Integer.parseInt(cur));
        }
    
        
        for(int i=0; i<numbers.length(); i++){
            //2. 방문 체크
            //2-1. 이미 썼으면 넘어감
            if(visited[i])  continue;
            //2-2. 안 썼으면 씀
            visited[i] = true;
            dfs(cur + numbers.charAt(i));
            visited[i] = false;            
        }
        
    }
    
    public boolean isPrime(int num){
        if(num < 2) return false;
        for(int i=2; i*i <= num; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}

