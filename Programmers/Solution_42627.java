
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;


class Solution {
	

	static class Work {
		int start;
		int workTime;
		
		Work(int _start, int _workTime) {
			start = _start;
			workTime = _workTime;
		}
		
		int getEndTime() {
			return start + workTime;
		}
		
		@Override
		public String toString() {
			return "start: " + start + " workTime: " + workTime;
		}
	}
	
    public static int solution(int[][] jobs) {
    	PriorityQueue<Work> waiting = new PriorityQueue<>(new Comparator<Work>() {
			@Override
			public int compare(Work o1, Work o2) {
				return o1.workTime - o2.workTime;
			}
    	});
    	
    	LinkedList<Work> list = new LinkedList<>();
    	
    	for(int[] j: jobs) list.add(new Work(j[0], j[1]));    	
    	
    	Collections.sort(list, new Comparator<Work>() {
			@Override
			public int compare(Work o1, Work o2) {
				return o1.start - o2.start;
			}
		});
    	
    	int answer = 0;
    	int nowTime = 0;
    	
    	while(!list.isEmpty()) {
    		if(nowTime >= list.peek().start) 
    			while(!list.isEmpty() && nowTime >= list.peek().start) waiting.add(list.poll());
    		else {
    			nowTime = list.peek().start;
    			waiting.add(list.poll());
    		}
    		
    		while(!waiting.isEmpty()) {
    			while(!list.isEmpty() && nowTime >= list.peek().start) waiting.add(list.poll());
	    		Work w = waiting.poll();
	    		if(w.start < nowTime) nowTime += w.workTime;
	    		else nowTime = w.start + w.workTime;
	    		answer += nowTime - w.start;
    		}
    	}
    	
        return answer / jobs.length;
    }
    
    public static void main(String[] args) {
    	int[][] jobs = {{1, 3}, {1, 4}, {1, 5}, {1, 7}, {1, 9}};
		System.out.println(solution(jobs));
	}
}