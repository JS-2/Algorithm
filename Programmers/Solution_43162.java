class Solution {
	
	public static void dfs(int node, boolean[] visited, int n, int[][] computers) {
		if(visited[node]) return;
		visited[node] = true;
		for(int i = 0; i < n; i++) {
			if(computers[node][i] == 1 && !visited[i]) {
				dfs(i, visited, n, computers);
			}
		}
	}
	
    public static int solution(int n, int[][] computers) {
    	int answer = 0;
    	boolean[] visited = new boolean[n];
    	
        for(int i = 0; i < n; i++) {
        	if(visited[i]) continue;
        	++answer;
        	dfs(i, visited, n, computers);
        }
    	
        return answer;
    }
    
    public static void main(String[] args) {
    	int n = 3;
    	int[][] computers = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
		System.out.println(solution(n, computers));
	}
}