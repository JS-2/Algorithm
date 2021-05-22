class Solution {
	
    public static int solution(int[] money) {
        int answer = Math.max(money[0], money[1]);
        
        //ù��° �� ����, �������� �������� �ʴ� ���
        int max = money[0];
        int beforeMoney = 0;
        for(int i = 2; i < money.length - 1; i++) {
        	int sum = money[i] + max;
        	answer = Math.max(answer, sum);
        	max = Math.max(beforeMoney, max);
        	beforeMoney = sum;
        }
        
        //ù��° �� ������, �������� �����ϴ� ���
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