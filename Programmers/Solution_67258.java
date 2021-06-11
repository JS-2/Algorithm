import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	
    public static int[] solution(String[] gems) {
    	int[] answer = new int[2];
    	int answerSize = Integer.MAX_VALUE;
    	
    	Map<String, Integer> map = new HashMap<>();
    	int[] numByGems = new int[gems.length];
    	int gemKinds = 0;
    	
    	for(int i = 0; i < gems.length; i++) {
    		String gem = gems[i];
    		if(!map.containsKey(gem)) {
    			map.put(gem, gemKinds++);	
    		}
    		numByGems[i] = map.get(gem);
    	}
    	
    	int[] selectedGem = new int[map.size()];
    	
    	int start = 0;
    	int end = 0;
    	int selectedGemKinds = 1;
    	
    	++selectedGem[numByGems[0]];
    	
    	while(true) {
    		if(selectedGemKinds == gemKinds && answerSize > end - start) {
    			answer[0] = start + 1;
    			answer[1] = end + 1;
    			answerSize = end - start;
    		}
    		
    		if(selectedGemKinds < gemKinds) {
    			if(++end >= numByGems.length) break;
    			int addGem = numByGems[end];
    			if(selectedGem[addGem] == 0) {
    				++selectedGemKinds;
    			}
    			++selectedGem[addGem];
    		} else {
    			int removeGem = numByGems[start];
    			if(++start >= numByGems.length) break;
    			if(selectedGem[removeGem] == 1) {
    				--selectedGemKinds;
    			}
    			--selectedGem[removeGem];
    		}
    	}
    	
        return answer;
    }
    
    public static void main(String[] args) {
    	String[] gems = { "A", "B", "A", "C", "B", "A", "B", "D", "C", "B" };
		System.out.println(Arrays.toString(solution(gems)));
	}
}