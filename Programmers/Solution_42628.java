import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Solution {
    public static int[] solution(String[] operations) {
    	StringTokenizer st;
    	LinkedList<Integer> lList = new LinkedList<>();

    	for(String oper: operations) {
    		st = new StringTokenizer(oper);
    		String token1 = st.nextToken();
    		String token2 = st.nextToken();
    		
    		if("I".equals(token1)) {
    			int number = Integer.parseInt(token2);
    			lList.add(number);
    			Collections.sort(lList, new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o2 - o1;
					}
				});
    		} else if("D".equals(token1)) {
    			int number = Integer.parseInt(token2);
    			if(lList.isEmpty()) continue;
    			if(number == -1) lList.remove(lList.size() - 1);
    			if(number == 1) lList.remove(0);
    		}
    	}
    	if(lList.isEmpty()) return new int[] { 0, 0 };
        int[] answer = new int[lList.size()];
        for(int i = 0; i < lList.size(); i++) answer[i] = lList.get(i);
        return answer;
    }
    
    public static void main(String[] args) {
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		System.out.println(Arrays.toString(solution(operations)));
	}
}