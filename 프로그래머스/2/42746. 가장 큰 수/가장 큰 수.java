import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        // 1. 일단 String 배열로 받기
        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            arr[i] = numbers[i] + "";
        }
        
        // 2. 내림차순 정렬
        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));
        
        // 3. 반환 문자열 생성
        StringBuilder answer = new StringBuilder();
        for(String str : arr){
            answer.append(str);
        }
        if(answer.charAt(0) == '0') return "0";
        return answer.toString();
    }
}