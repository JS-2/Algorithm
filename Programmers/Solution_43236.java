import java.util.Arrays;

class Solution {
	
    public static int solution(int distance, int[] rocks, int n) {
    	int answer = 0;
        int left = 1;
        int right = distance;
        Arrays.sort(rocks);
        int[] rockDistances = new int[rocks.length + 1];
        rockDistances[0] = rocks[0];
        rockDistances[rockDistances.length - 1] = distance - rocks[rocks.length - 1];
        
        for(int i = 0; i < rocks.length - 1; i++) {
        	rockDistances[i + 1] = rocks[i + 1] - rocks[i];
        }
        
        while(left <= right) {
        	int mid = (left + right) / 2;
        	int sum = 0;
        	int breakCnt = 0;
        	for(int rd: rockDistances) {
        		sum += rd;
        		if(sum < mid) {
        			++breakCnt;
        		} else {
        			sum = 0;
        		}
        	}
        	if(breakCnt <= n) {
        		left = mid + 1;
        	} else {
        		right = mid - 1;
        	}
        }
        return right;
    }
    // 4 4 3 5
    public static void main(String[] args) {
    	int distance = 25;
    	int[] rocks = { 2, 11, 19 };
    	int n = 2;
    	System.out.println(solution(distance, rocks, n));
	}
}