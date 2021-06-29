import java.util.Arrays;

class Solution {
    public static int solution(int[] A, int[] B) {
        int answer = 0;
        
    	Arrays.sort(A);
    	Arrays.sort(B);
    	
    	int AIdx = 0;
    	int BIdx = 0;
    	
    	while(BIdx < B.length) {
    		if(A[AIdx] < B[BIdx]) {
    			++AIdx;
    			++BIdx;
    			++answer;
    		} else {
    			++BIdx;
    		}
    	}
    	
        return answer;
    }
    
    public static void main(String[] args) {
		System.out.println(solution(new int[] {5,1,3,7} ,new int[] {2,2,6,8}));
	}
}