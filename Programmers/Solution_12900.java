
class Solution {
	
    public static int solution(int n) {
        int[] memo = new int[n + 2];
        memo[1] = 1;
        memo[2] = 2;
        
        for(int i = 3; i <= n; i++) {
        	memo[i] = (memo[i - 1] + memo[i - 2]) % 1000000007;
        }
        return memo[n];
    }
    
    public static void main(String[] args) {
		int n = 100001;
		System.out.println(solution(n));
	}
}