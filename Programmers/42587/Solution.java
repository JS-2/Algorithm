import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
	static class Work {
		int priority;
		int location;
		
		Work(int _priority, int _location) {
			priority = _priority;
			location = _location;
		}
	}
	
    public static int solution(int[] priorities, int location) {
        int[] priorityCnt = new int[10];
    	int maxPriority = 0;
    	int order = 1;
    	
    	Queue<Work> q = new LinkedList<>();
    	
    	for(int pi = 0; pi < priorities.length; pi++) {
    		int priority = priorities[pi];
    		++priorityCnt[priority];
    		q.add(new Work(priority, pi));
    		maxPriority = Math.max(maxPriority, priority);
    	}
    	
        
        while(!q.isEmpty()) {
        	Work work = q.poll();
        	
        	if(work.priority == maxPriority) {
        		if(work.location == location) return order;
        		++order;
        		
        		if(--priorityCnt[maxPriority] == 0) {
        			while(priorityCnt[--maxPriority] == 0);
        		}
        	}
        	
        	q.add(work);
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
    	int[] priorities = { 1, 1, 9, 1, 1, 1 };
    	int location = 0;
    	System.out.println(solution(priorities, location));
	}
}