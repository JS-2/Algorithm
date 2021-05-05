
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class Solution {
	
    public static int solution(int[] people, int limit) {
        int answer = 0;
    	LinkedList<Integer> list = new LinkedList<>();
    	
    	Arrays.sort(people);
    	
    	for(int p: people) {
    		list.add(p);
    	}
    	
    	while(!list.isEmpty()) {
    		if(list.get(0) > limit / 2) {
    			answer += list.size();
    			break;
    		}
    		++answer;
    		int heavy = list.pollLast();
    		if(list.isEmpty()) break;
    		int light = list.peek();
    		if(heavy + light <= limit) {
    			list.pollFirst();
    		}
    	}
        return answer;
    }
    
    public static void main(String[] args) {
    	int[] people = { 70, 50, 80, 50 };
    	int limit = 100	;
    	System.out.println(solution(people, limit));
	}
}