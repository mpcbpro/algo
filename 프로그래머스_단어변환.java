public class WordConversion {
    int answer;                        
    boolean[] used;                    
    public int solution(String begin, String target, String[] words) {
        answer = 51;               
        used = new boolean[words.length];
        dfs(begin, target, 0, words);
        return answer == 51 ? 0 : answer;    
    }
    
    public void dfs(String presentWord, String target, int count,String[] words) {
        if(presentWord.equals(target)) {
            answer = (answer > count) ? count : answer;
            return;
        }
        
        for(int i = 0; i < words.length; i++) {                    
            if(!used[i] && check(presentWord, words[i])) {
                used[i] = true;
                dfs(words[i],target,count+1, words);
                used[i] = false;
            }
        }
    }
    
    public boolean check(String presentWord, String nextWord) {       
        int count = 0;
        for(int i = 0; i < presentWord.length(); i++) {
            if(presentWord.charAt(i) != nextWord.charAt(i)) {
                count++;
            }
        }
        return count == 1 ? true : false;
    }
}