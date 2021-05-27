import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
	
    public static int solution(int n, int[][] edge) {
    	ArrayList<ArrayList<Integer>> links = new ArrayList<>();
    	for(int i = 0; i <= n; i++) {
    		links.add(new ArrayList<>());
    	}
    	
    	for(int[] e: edge) {
    		links.get(e[0]).add(e[1]);
    		links.get(e[1]).add(e[0]);
    	}
    	
    	boolean[] visited = new boolean[n + 1];
    	
    	Queue<Integer> q = new LinkedList<>();
    	q.add(1);
    	visited[1] = true;

        int answer = 0;
        
    	while(!q.isEmpty()) {
    		int qSize = q.size();
    		answer = qSize;
    		for(int qi = 0; qi < qSize; qi++) {
	    		int node = q.poll();
	    		for(int next: links.get(node)) {
	    			if(visited[next]) continue;
	    			visited[next] = true;
	    			q.add(next);
	    		}
    		}
    	}
    	
        return answer;
    }
    
    public static void main(String[] args) {
		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
		
		System.out.println(solution(n, edge));
	}
}