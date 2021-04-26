import java.util.Arrays;

class Solution {
	
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int ansIdx = 0;
        
    	for(int[] command: commands) {
    		int from = command[0];
    		int to = command[1];
    		int find = command[2];
    		
    		int[] temp = new int[to - from + 1];
    		
    		for(int i = from - 1; i < to; i++) {
    			temp[i - from + 1] = array[i];
    		}
    		
    		Arrays.sort(temp);
    		answer[ansIdx++] = temp[find - 1];
    	}
    	
        return answer;
    }
    
    public static void main(String[] args) {
    	int[] array = { 1, 5, 2, 6, 3, 7, 4 };
    	int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
    	
    	System.out.println(Arrays.toString(solution(array, commands)));
	}
}