import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static int solution(int[] scoville, int K) {
    	PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {
			@Override
			public int compare(Long o1, Long o2) {
				if(o1 - o2 > 0) return 1;
				else if(o1 == o2) return 0;
				else return -1;
			}
    	});
    	
    	for(int s: scoville) pq.add((long)s);
    	
    	int fusionCnt = 0;
    	
    	while(!pq.isEmpty()) {
    		long s1 = pq.poll();
    		
    		if(s1 >= K) return fusionCnt;
    		
    		if(pq.isEmpty()) return -1;
    		long s2 = pq.poll();
    		
    		pq.add(s1 + s2 * 2);
    		++fusionCnt;
    	}
        
        return -1;
    }
    
    public static void main(String[] args) {
    	int[] scoville = { 1, 2, 3, 9, 10, 12 }; 
    	int K = 1;
    	System.out.println(solution(scoville, K));
	}
}