import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

class Solution {
	
	static class Ticket {
		int index;
		String to;
		Ticket(int _index, String _to) {
			index = _index;
			to = _to;
		}
	}

    public static String[] dfs(int cnt, HashMap<String, ArrayList<Ticket>> map, boolean[] visited, String[][] tickets, String[] answer) {
    	 if(cnt == tickets.length + 1) {
    		 return answer;
    	 }
    	 if(!map.containsKey(answer[cnt - 1])) {
    		 return null;
    	 }
    	 ArrayList<Ticket> nexts = map.get(answer[cnt - 1]);
    	 for(Ticket next: nexts) {
    		 if(visited[next.index]) continue;
    		 visited[next.index] = true;
    		 answer[cnt] = tickets[next.index][1];
    		 String[] temp = dfs(cnt + 1, map, visited, tickets, answer);
    		 if(temp != null) return temp;
    		 visited[next.index] = false;
    	 }
    	 
    	 return null;
    }
    public static String[] solution(String[][] tickets) {
    	HashMap<String, ArrayList<Ticket>> map = new HashMap<>();
    	for(int ti = 0; ti < tickets.length; ti++) {
    		String from = tickets[ti][0];
    		String to = tickets[ti][1];
    		if(map.containsKey(from)) {
    			map.get(from).add(new Ticket(ti, to));
    			
    		} else {
    			ArrayList<Ticket> list = new ArrayList<>();
    			list.add(new Ticket(ti, to));
    			map.put(from, list);
    		}
    	}
    	
    	Set<String> kSet = map.keySet();
    	for(String key: kSet) {
    		Collections.sort(map.get(key), new Comparator<Ticket>() {
    			@Override
    			public int compare(Ticket o1, Ticket o2) {
    				return o1.to.compareTo(o2.to);
    			}
    		});
    	}
    	
    	String[] answer = new String[tickets.length + 1];
    	answer[0] = "ICN";
        return dfs(1, map, new boolean[tickets.length], tickets, answer);
    }
    
    public static void main(String[] args) {
    	String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
    	System.out.println(Arrays.toString(solution(tickets)));
	}
}