import java.util.ArrayList;

class Solution {
	
	static int[] linkedCnt;
    	
	public static void getParents(ArrayList<ArrayList<Integer>> path, int node, boolean[] visited) {
		for(int p: path.get(node)) {
			if(visited[p]) continue;
			visited[p] = true;
			++linkedCnt[p];
			getParents(path, p, visited);
		}
	}
	
	public static int getChildren(ArrayList<ArrayList<Integer>> path, int node, boolean[] visited) {
		int childrenCnt = 1;
		
		for(int p: path.get(node)) {
			if(visited[p]) continue;
			visited[p] = true;
			childrenCnt += getChildren(path, p, visited);
		}
		return childrenCnt;
	}
	
    public static int solution(int n, int[][] results) {
    	int answer = 0;
    	linkedCnt = new int[n + 1];
    	
    	ArrayList<ArrayList<Integer>> path = new ArrayList<>();
    	for(int i = 0; i <= n; i++) {
    		path.add(new ArrayList<>());
    	}
    	
    	for(int[] result: results) {
    		path.get(result[0]).add(result[1]);
    	}
    	
    	for(int i = 1; i <= n; i++) {
    		boolean[] visited = new boolean[n + 1];
    		visited[i] = true;
    		++linkedCnt[i];
    		getParents(path, i, visited);
    	}
        
    	for(int i = 1; i <= n; i++) {
    		linkedCnt[i] += getChildren(path, i, new boolean[n + 1]) - 1;
    		if(linkedCnt[i] == n) ++answer;
    	}
        return answer;
    }
    
    public static void main(String[] args) {
    	int n = 6;
    	int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
    	System.out.println(solution(n, results));
	}
}