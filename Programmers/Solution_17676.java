import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Solution {
	
	public static int toSecond(String[] hms) {
		BigDecimal hour = new BigDecimal(hms[0]).multiply(new BigDecimal(3600));
		BigDecimal min = new BigDecimal(hms[1]).multiply(new BigDecimal(60));
		BigDecimal sec = new BigDecimal(hms[2]);
		BigDecimal t = new BigDecimal(1000);

		BigDecimal sum = hour.add(min).add(sec).multiply(t);

		return sum.intValue();
	}
	
    public static int solution(String[] lines) {
        int answer = 1;
    	int[][] dLines = new int[lines.length][];
    	
    	for(int i = 0; i < lines.length; i++) {
    		String line = lines[i];
    		StringTokenizer st = new StringTokenizer(line);
    		st.nextToken();
    		String[] hms = st.nextToken().split(":");
    		int second = toSecond(hms);
    		BigDecimal b = new BigDecimal(st.nextToken().replace("s", ""));
    		int processTime = b.multiply(new BigDecimal(1000)).intValue();
    		dLines[i] = new int[] { second - processTime + 1, second };
    	}
    	
    	for(int i = 0; i < dLines.length; i++) {
    		int cnt = 1;
    		int[] now = dLines[i];
    		for(int j = i + 1; j < dLines.length; j++) {
    			int[] after = dLines[j];
    			if(after[0] > now[1] + 999) continue;	
    			++cnt;
    		}
    		answer = Math.max(answer, cnt);
    	}
    	
        return answer;
    }
    
    public static void main(String[] args) {
    	String[] lines = { 
    			"2016-09-15 01:00:04.001 1.001s",
    			"2016-09-15 01:00:07.001 2.001s" };
    	System.out.println(solution(lines));
    }
}