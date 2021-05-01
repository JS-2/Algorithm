
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
	static class QItem {
		int index;
		int move;
		boolean[] completes;
		
		QItem(int _index, int _move, boolean[] _completes) {
			index = _index;
			move = _move;
			completes = _completes;
		}
	}
	
    public static int solution(String name) {
    	int answer = Integer.MAX_VALUE;
        
    	char[] alphabets = name.toCharArray();
        boolean[] completes = new boolean[alphabets.length];
        int notA = 0;
        
    	for(int i = 0; i < alphabets.length; i++) {
    		if(alphabets[i] == 'A') completes[i] = true;
    		else ++notA;
    	}
        
    	Queue<QItem> q = new LinkedList<>();
    	
    	completes[0] = true;
    	q.add(new QItem(0, 0, completes));
    	
    	if(alphabets[0] != 'A') --notA;
    	final int[] dir = { 1, -1 };
    	while(notA-- != 0) {
    		int qSize = q.size();
    		for(int qi = 0; qi < qSize; qi++) {
	    		QItem qitem = q.poll();
	    		
	    		for(int d: dir) {
		    		int newIdx = qitem.index;
		    		int cnt = 0;
		    		
		    		do {
		    			cnt++;
		    			newIdx = newIdx + d >= 0 ? (newIdx + d) % completes.length : completes.length - 1;
		    		}while(qitem.completes[newIdx]);
		    		
		    		boolean[] newCompletes = qitem.completes.clone();
		    		
		    		newCompletes[newIdx] = true;
		    		q.add(new QItem(newIdx, qitem.move + cnt, newCompletes));
	    		}
    		}
    	}
    	
    	for(QItem e: q) {
    		answer = Math.min(answer, e.move);
    	}
    	
    	for(char alphabet: alphabets) {
    		answer += Math.min(alphabet - 'A', 'Z' - alphabet + 1);
    	}
    	
        return answer;
    }
    
    public static void main(String[] args) {
    	String name = "ABAAAAAAAAABB";
    	System.out.println(solution(name));
	}
}