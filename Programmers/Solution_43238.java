import java.util.Arrays;

class Solution {
	
	public static long getCheckCnt(long mid, int[] times) {
		long sum = 0;
    	
    	for(int time: times) {
    		sum += mid / (long)time;
    	}
    	
    	return sum;
	}
    
	public static long solution(int n, int[] times) {
        long left = 0;
        Arrays.sort(times);
        long right = (long)n * (long)times[times.length - 1];

		long answer = 0;
		
        while(left <= right) {
        	long mid = (left + right) / 2;
        	long checkCnt = getCheckCnt(mid, times);
        	
        	if(checkCnt > n) {
        		right = mid - 1;
        	} else if(checkCnt < n) {
        		left = mid + 1;
        	} else {
        		answer = mid;
        		break;
        	}
        }
        
        if(answer == 0) return left;
        
        while(n == getCheckCnt(answer - 1, times)) {
        	--answer;
        }
        return answer;
    }
    
    public static void main(String[] args) {
    	int n = 5;
    	int[] times = { 1, 5 };
    	System.out.println(solution(n, times));
	}
}