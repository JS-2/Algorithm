import java.util.Arrays;

class Solution {
	
	public static String timeToString(int time) {
		String timeStamp = "";
		int hour = time / 60;
		int min = time % 60;
		
		if(hour < 10) timeStamp += "0";
		timeStamp += hour;
		timeStamp += ":";
		if(min < 10) timeStamp += "0";
		timeStamp += min;
		
		return timeStamp;
	}
	
    public static String solution(int n, int t, int m, String[] timetable) {
    	int answer = 0;
    	int[] waits = new int[timetable.length];
    	for(int i = 0; i < timetable.length; i++) {
    		String time = timetable[i];
    		String[] split = time.split(":");
    		waits[i] = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    	}
    	
    	Arrays.sort(waits);
    	
    	int nowTime = 9 * 60;
    	int waitIdx = 0;
    	int nowShuttle;
    	int nowPersonInShuttle = 0;
    	
    	for(nowShuttle = 0; nowShuttle < n; nowShuttle++) {
    		for(nowPersonInShuttle = 0; nowPersonInShuttle < m; nowPersonInShuttle++) {
    			if(waitIdx == waits.length) {
    	    		break;
    			}
    			if(waits[waitIdx] > nowTime) break;
    			++waitIdx;
    		}
    		nowTime += t;
    	}
    	
    	// ¼ÅÆ²¹ö½º°¡ ´Ù Ã¡À¸¸é
    	if(nowPersonInShuttle == m) {
    		for(int i = nowPersonInShuttle - 1; i >= 1; i--) {
    			if(waits[waitIdx - 1] != waits[waitIdx - 2]) {
    				answer = waits[waitIdx - 1] - 1;
    				return timeToString(answer);
    			}
    			--waitIdx;
    		}
    		if(nowPersonInShuttle == 1) {
    			answer = waits[waitIdx - 1] - 1;
    		} else {
    			answer = waits[waitIdx] - 1;
    		}
    	} else { // ¼ÅÆ²¹ö½º°¡ ´Ù ¾ÈÃ¡À¸¸é
    		answer = nowTime - t;
    	}
        return timeToString(answer);
    }
    
    public static void main(String[] args) {
    	int n = 5;
    	int t = 43;
    	int m = 2;
    	String[] timetable = {"11:32", "11:44"};
		System.out.println(solution(1, 12, 2, new String[] { "21:46", "07:00", "00:50" }));
	}
}