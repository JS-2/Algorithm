import java.util.ArrayList;
import java.util.Iterator;

class Solution
{
	static int answer;
	
	public static void findAnswer(char[] chars, int n, ArrayList<Integer> idxs) {
		ArrayList<Integer> nextIdxs = new ArrayList<>();
		
		for(int idx: idxs) {
			if(idx == 0 || idx + n == chars.length) continue;
			if(chars[idx - 1] == chars[idx + n]) {
				nextIdxs.add(idx - 1);
			}
		}
		if(nextIdxs.size() != 0) {
			answer = Math.max(answer, n + 2);
			findAnswer(chars, n + 2, nextIdxs);
		}
	}
	
    public static int solution(String s)
    {
    	answer = 1;
    	char[] chars = s.toCharArray();
    	
    	ArrayList<Integer> idxs;
    	
    	for(int i = 1; i <= 2; i++) {
    		idxs = new ArrayList<>();
	    	for(int j = 0; j < chars.length - i; j++) {
	    		if(chars[j] == chars[j + i]) idxs.add(j);
	    	}
	    	if(idxs.size() != 0) {
	    		answer = Math.max(answer, i + 1);
	    		findAnswer(chars, i + 1, idxs);
	    	}
    	}
    	
        return answer;
    }
    
    public static void main(String[] args) {
    	String s = "a";
    	System.out.println(solution(s));
	}
}