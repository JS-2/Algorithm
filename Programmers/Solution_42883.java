
class Solution {
	
    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        
        for(int i = 0; i < sb.length() - 1; i++) {
        	if(sb.charAt(i) < sb.charAt(i + 1)) {
        		sb.delete(i, i + 1);
        		i = i - 2 < 0 ? -1 : i - 2;
        		if(--k == 0) break;
        		continue;
        	}
        }
        
        while(k-- > 0) {
        	sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
		String number = "4177252841";
		int k = 4;
		System.out.println(solution(number, k));
	}
}