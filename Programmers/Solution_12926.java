class Solution {
    public static String solution(String s, int n) {
    	char[] chars = s.toCharArray();
    	char[] answerChars = new char[chars.length];
    	
    	for(int i = 0; i < chars.length; i++) {
    		char c = chars[i];
    		if(c >= 'a' && c <= 'z') {
    			answerChars[i] = (char)((c + n - 'a') % ('z' - 'a' + 1) + 'a');
    		} else if(c >= 'A' && c <= 'Z') {
    			answerChars[i] = (char)((c + n - 'A') % ('Z' - 'A' + 1) + 'A');
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(char c: answerChars) {
    		if(c == '\u0000') sb.append(" ");
    		else sb.append(c);
    	}
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	String s = "a B z"	;
    	int n = 4;
    	System.out.println(solution(s, n));
	}
}