class Solution {
	
    public static int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        
        for(int[] puddle: puddles) {
        	map[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        map[0][0] = 1;
        
        for(int r = 0; r < n; r++) {
        	for(int c = 0; c < m; c++) {
        		if(map[r][c] < 0) continue;
        		if(r + 1 < n && map[r + 1][c] >= 0) {
    				map[r + 1][c] = (map[r][c] + map[r + 1][c]) % 1000000007;
        		}
        		if(c + 1 < m && map[r][c + 1] >= 0) {
        			map[r][c + 1] = (map[r][c] + map[r][c + 1]) % 1000000007;
        		}
        	}
        }
        
        return map[n - 1][m - 1];
    }
    
    public static void main(String[] args) {
    	int m = 4;
    	int n = 3;
    	int[][] puddles = { { 2, 2 } };
    	System.out.println(solution(m, n, puddles));
	}
}