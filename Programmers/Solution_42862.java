import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static int solution(int n, int[] lost, int[] reserve) {
    	boolean[] canWear = new boolean[n + 1];
    	Arrays.fill(canWear, true);
    	
    	for(int l: lost) { 
    		canWear[l] = false;
    	}
        
    	ArrayList<Integer> list = new ArrayList<>();
    	for(int r: reserve) { 
    		if(!canWear[r]) {
    			canWear[r] = true;
    		} else {
    			list.add(r);
    		}
    	}
    	
    	reserve = list.stream().mapToInt(i -> i.intValue()).toArray();
    	
    	Arrays.sort(reserve);
    	for(int r: reserve) {
    		if(!canWear[r - 1]) {
    			canWear[r - 1] = true;
    		} else if(r + 1 < canWear.length && !canWear[r + 1]) {
    			canWear[r + 1] = true;
    		}
    	}
    	
    	int answer = 0;
    	
        for(int i = 1; i < canWear.length; i++) {
        	answer = canWear[i] ? answer + 1: answer;
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
		int n = 4;
		int[] lost = { 3, 1, 2 };
		int[] reserve = { 2, 4, 3 };
		System.out.println(solution(n, lost, reserve));
	}
}