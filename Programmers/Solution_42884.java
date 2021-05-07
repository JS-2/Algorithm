import java.util.Arrays;
import java.util.Comparator;

class Solution {
	
    public static int solution(int[][] routes) {
    	Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
    	});

        int answer = 1;
        
        int left = routes[0][0];
        int right = routes[0][1];
        
        for(int i = 1; i < routes.length; i++) {
        	int[] route = routes[i];
        	
        	if(left <= route[0] && route[0] <= right) {
        		left = Math.max(left, route[0]);
        		right = Math.min(right, route[1]);
        	} else {
        		left = route[0];
        		right = route[1];
        		++answer;
        	}
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
    	int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
    	System.out.println(solution(routes));
	}
}