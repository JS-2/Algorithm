import java.util.Arrays;
import java.util.Comparator;

class Solution {
	
	static int[] parents;
	
    public static int solution(int n, int[][] costs) {
    	parents = new int[n + 1];
    	
    	for(int i = 1; i < n + 1; i++) {
    		parents[i] = i;
    	}
    	
    	Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
    	
    	int cnt = 0;
        int answer = 0;
        
    	for(int[] cost: costs) {
    		if(union(cost[0], cost[1])) {
    			answer += cost[2];
    			if(++cnt == n - 1) break;
    		}
    	}
    	
        return answer;
    }
    
    public static boolean union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	parents[a] = b;
    	
    	if(a == b) return false;
    	else return true;
    }
    
    public static int find(int a) {
    	if(parents[a] == a) return a;
    	else return parents[a] = find(parents[a]);
    }
    
    public static void main(String[] args) {
    	int n = 4;
    	int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		System.out.println(solution(n, costs));
	}
}