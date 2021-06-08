import java.util.Arrays;

class Solution {
	
	public static int combination(int start, int cnt, int[] arr, int[] sel, boolean[] visited ) {
		if(cnt == 3) {
			int sum = 0;
			
			for(int e: sel) {
				sum += e;
			}
			
			for(int i = 2; i < sum; i++) {
				if(sum % i == 0) return 0;
			}
			
			return 1;
		}
		
		int answer = 0;
		
		for(int i = start; i < arr.length; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			sel[cnt] = arr[i];
			answer += combination(i, cnt + 1, arr, sel, visited);
			visited[i] = false;
		}
		
		return answer;
	}
	
    public static int solution(int[] nums) {
        int answer = combination(0, 0, nums, new int[3], new boolean[nums.length]);
        return answer;
    }
    
    public static void main(String[] args) {
    	int[] nums = { 1,2,7,6,4 };
		System.out.println(solution(nums));
	}
}