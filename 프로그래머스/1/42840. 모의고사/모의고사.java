import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 1. 수포자 정답 패턴
        int[][] patterns = {{1, 2, 3, 4, 5},
                            {2, 1, 2, 3, 2, 4, 2, 5},
                            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        // 2. 정답 체크
        int[] scores = new int[3];
        for(int i=0; i<answers.length; i++){
            if(answers[i] == patterns[0][i%5]) scores[0]++;
            if(answers[i] == patterns[1][i%8]) scores[1]++;
            if(answers[i] == patterns[2][i%10]) scores[2]++;
        }
        
        // 3. 최고득점 탐색
        int max = Integer.MIN_VALUE;
        for(int score : scores){
            if(score >= max) max = score;
        }
        
        // 4. 동점자 탐색
        ArrayList<Integer> answerList = new ArrayList<>();
        for(int i=0; i<3; i++){
            if(scores[i] == max) answerList.add(i+1);
        }
        
        // 5. 정수형 배열 변환
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}