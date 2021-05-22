import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
	class QItem {
		String now;
		boolean[] visited;
		
		QItem(String _now, boolean[] _visited) {
			now = _now;
			visited = _visited;
		}
	}
	
	public boolean checkOneApb(String str1, String str2){
		int cnt = 0;
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		
		for(int i = 0; i < chars1.length; i++) {
			if(chars1[i] != chars2[i]) {
				++cnt;
			}
		}
		
		return cnt == 1 ? false : true;
	}
    
    public int solution(String begin, String target, String[] words) {

        Queue<QItem> q = new LinkedList<>();
        
        q.add(new QItem(begin, new boolean[words.length]));
        
        int moveCnt = 1;
        while(!q.isEmpty()) {
        	int qSize = q.size();
        	for(int qi = 0; qi < qSize; qi++) { 
	        	QItem qItem = q.poll();
	        	for(int i = 0; i < words.length; i++) {
	        		if(qItem.visited[i] || checkOneApb(qItem.now, words[i])) {
	        			continue;
	        		}
	        		if(words[i].equals(target)) {
	        			return moveCnt;
	        		}
	        		boolean[] nextVisited = qItem.visited.clone();
	        		nextVisited[i] = true;
	        		q.add(new QItem(words[i], nextVisited));
	        	}
        	}
        	++moveCnt;
        }
        return 0;
    }
}