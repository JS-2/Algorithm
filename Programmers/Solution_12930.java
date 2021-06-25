class Solution {
    public static String solution(String s) {
    	StringBuilder sb = new StringBuilder();
    	int index = 0;
    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i) == ' ') {
    			index = 0;
    			sb.append(' ');
    		} else {
    			if(index % 2 == 0) sb.append(Character.toUpperCase(s.charAt(i)));
    			else sb.append(Character.toLowerCase(s.charAt(i)));
    			++index;
    		}
    	}
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	String s = "try  hello world";
		System.out.println(solution(s));
	}
}