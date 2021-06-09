import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Solution {
	
	public static String charArrToString(char[] arr) {
		StringBuilder sb = new StringBuilder();
		for(char e: arr) {
			sb.append(e);
		}
		return sb.toString();
	}
	
	public static void combination(int n, int selN, int cnt, char[] arr, char[] sel, boolean[] visited, HashMap<String, Integer> map) {
		if(n == cnt) {
			String str = charArrToString(sel);
			if(map.containsKey(str)) map.put(str, map.get(str) + 1);
			else map.put(str, 1);
			return;
		}
		
		for(int i = selN; i < arr.length; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			sel[cnt] = arr[i];
			combination(n, i, cnt + 1, arr, sel, visited, map);
			visited[i] = false;
		}
	}
	
    public static String[] solution(String[] orders, int[] course) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String order: orders) {
        	char[] chars = order.toCharArray();
        	Arrays.sort(chars);
        	for(int c: course) {
        		if(order.length() < c) continue;
            	combination(c, 0, 0, chars, new char[c], new boolean[order.length()], map);
        	}
        }
        
        ArrayList<String> answerList = new ArrayList<>();
        
        for(int c: course) {
            ArrayList<String> list = new ArrayList<>();
            int max = 2;
        	for(String key: map.keySet()) {
            	if(key.length() == c) {
            		int orderCnt = map.get(key);
	        		if(orderCnt > max) {
	        			max = orderCnt;
	            		list.clear();
	        			list.add(key);
	            	} else if(orderCnt == max) {
	            		list.add(key);
	            	}
            	}
            }
        	for(String e: list) {
        		answerList.add(e);
        	}
        }
        
    	String[] answer = new String[answerList.size()];
    	for(int i = 0; i < answerList.size(); i++) {
    		answer[i] = answerList.get(i);
    	}
    	Arrays.sort(answer);
        return answer;
    }
    
    public static void main(String[] args) {
    	String[] orders = { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" };
    	int[] course = {2, 3, 5};
    	System.out.println(Arrays.toString(solution(orders, course)));
	}
}