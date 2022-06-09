class Solution {
    public String solution(int n) {
        String answer = "";
        String[] nums = {"4", "1", "2"};
        
        int num = n;
        
        while(num>0) {
            int res = num % 3;
            num /= 3;
            if(res == 0) num--;
            
            answer = nums[res] + answer;
        }
        return answer;
    }
}