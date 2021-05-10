import java.util.Arrays;

class Solution {
	
    public static int solution(int[][] triangle) {
        for(int i = 1; i < triangle.length; i++) {
        	int[] row = triangle[i];
        	for(int col = 0; col < i + 1; col++) {
        		int left = col - 1;
        		int right = col;
        		if(left < 0) {
        			row[col] += triangle[i - 1][right];
        		} else if(right > i - 1) {
        			row[col] += triangle[i - 1][left];
        		} else {
        			row[col] += Math.max(triangle[i - 1][right], triangle[i - 1][left]);
        		}
        	}
        }
        
        int[] lastRow = triangle[triangle.length - 1];
        Arrays.sort(lastRow);
        
        return lastRow[lastRow.length - 1];
    }
    
    public static void main(String[] args) {
    	int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
    	System.out.println(solution(triangle));
	}
}