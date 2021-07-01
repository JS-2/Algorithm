import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
	
	static ArrayList<Integer> list;
	
	public static boolean isMinimality(int[] sel) {
		for(int l: list) {
			int temp = 0;
			for(int s: sel) temp = temp | 1 << s;
			
			if((l & temp) == l) return false;
		}
		return true;
	}
	
	public static boolean isUniqueness(int[] sel, String[][] relation) {
		Set<String> set = new HashSet<>();
		for(String[] rel: relation) {
			StringBuilder sb = new StringBuilder();
			for(int s: sel) {
				sb.append(rel[s]);
			}
			
			if(set.contains(sb.toString())) {
				return false;
			} else {
				set.add(sb.toString());
			}
		}
		return true;
	}
	
	public static void combination(int target, int start, int N, int cnt, int[] sel, boolean[] visited, String[][] relation) {
		if(target == cnt) {
			if(isUniqueness(sel, relation) && isMinimality(sel)) {
				int item = 0;
				for(int s: sel) item = item | 1 << s;
				list.add(item);
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			sel[cnt] = i;
			combination(target, i + 1, N, cnt + 1, sel, visited, relation);
			visited[i] = false;
		}
	}
	
    public static int solution(String[][] relation) {
        list = new ArrayList<>();
        int colNum = relation[0].length;
        
        for(int i = 1; i <= colNum; i++) {
            combination(i, 0, colNum, 0, new int[i], new boolean[colNum], relation);
        }
        return list.size();
    }
    
    public static void main(String[] args) {
    	String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
    	System.out.println(solution(relation));
	}
}