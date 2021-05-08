import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
	
    public static int solution(int N, int number) {
    	int[] numbers = new int[32001];
    	Arrays.fill(numbers, -1);
    	
    	ArrayList<ArrayList<Integer>> NCalList = new ArrayList<>();
    	for(int i = 0; i <= 8; i++) {
    		NCalList.add(new ArrayList<>());
    	}
    	
    	for(int cnt = 1; cnt <= 8; cnt++) {
    		ArrayList<Integer> NCal = NCalList.get(cnt);
    		
    		String strOnlyNs = new String();
    		for(int i = 0; i < cnt; i++) {
    			strOnlyNs += N;
    		}
    		
    		int onlyNs = Integer.parseInt(strOnlyNs);
    		if(onlyNs <= 32000 && numbers[onlyNs] == -1) {
    			numbers[onlyNs] = cnt;
        		NCal.add(onlyNs);
    		}
    		
    		for(int s1 = 1; s1 < cnt; s1++) {
    			int s2 = cnt - s1;
    			ArrayList<Integer> NCal1 = NCalList.get(s1);
    			ArrayList<Integer> NCal2 = NCalList.get(s2);
    			for(int cal1: NCal1) {
    				for(int cal2: NCal2) {
    					int[] fourCal = {
    							cal1 + cal2,
    							cal1 - cal2,
    							cal1 * cal2,
    							cal1 / cal2	
    					};
    					
    					for(int f: fourCal) {
    						if(f >= 1 && f <= 32000 && numbers[f] == -1) {
    							numbers[f] = cnt;
    							NCal.add(f);
    						}
    					}
    				}
    			}
    		}
    	}
    	
        return numbers[number];
    }
    
    public static void main(String[] args) {
		int N = 2;
		int number = 11;
		System.out.println(solution(N, number));
	}
}