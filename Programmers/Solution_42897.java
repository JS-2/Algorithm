class Solution {
	
    public static int solution(int[] money) {
        int answer = Math.max(money[0], money[1]);
        
        //첫번째 집 포함, 마지막집 포함하지 않는 경우
        int max = money[0];
        int beforeMoney = 0;
        for(int i = 2; i < money.length - 1; i++) {
        	int sum = money[i] + max;
        	answer = Math.max(answer, sum);
        	max = Math.max(beforeMoney, max);
        	beforeMoney = sum;
        }
        
        //첫번째 집 미포함, 마지막집 포함하는 경우
        max = 0;
        beforeMoney = money[1];
        for(int i = 2; i < money.length; i++) {
        	int sum = money[i] + max;
        	answer = Math.max(answer, sum);
        	max = Math.max(beforeMoney, max);
        	beforeMoney = sum;
        }
        return answer;
    }
    
    public static void main(String[] args) {
		int[] money = new int[] { 10000,   1000,   7,   3,   2,   10,   100,   10000 };
		System.out.println(solution(money));
	}
}