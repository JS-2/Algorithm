class Solution {
	
	static int answer;
	
	public static void dfs(int[] numbers, int index, int sum, int target) {
		if(index == numbers.length) {
			if(sum == target) {
				++answer;
			}
			return;
		}
		
		dfs(numbers, index + 1, sum + numbers[index], target);
		dfs(numbers, index + 1, sum - numbers[index], target);
	}
	
    public static int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, 0, 0, target);
        return answer;
    }
    
    public static void main(String[] args) {
    	int[] numbers = { 1, 1, 1, 1, 1 };
    	int target = 3;
    	System.out.println(solution(numbers, target));
	}
}