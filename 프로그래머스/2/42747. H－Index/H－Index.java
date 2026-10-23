class Solution {
    public int solution(int[] citations) {
        
        // 1. 인용 횟수 당 논문 수
        int max = 0;
        for(int n : citations){
            if(max < n) max = n;
        }
        int[] count = new int[max + 1];
        for(int n: citations){
            count[n]++;
        }
        
        // 2. 누적 합
        int[] cSum = new int[max + 1];
        cSum[max] = count[max];
        for(int i=max-1; i>=0; i--){
            cSum[i] = cSum[i+1] + count[i];
        }
        
        // 3. 체크
        int answer = 0;
        for(int i=0; i<=max; i++){
            if(i <= cSum[i]) answer = i;
        }
        
        return answer;
    }
}