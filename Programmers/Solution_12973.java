class Solution
{
    public static int solution(String s)
    {
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 0; i < s.length(); i++) {
    		if(sb.length() != 0 && sb.charAt(sb.length() - 1) == s.charAt(i)) {
    	    	sb.delete(sb.length() - 1, sb.length());
    		} else {
    			sb.append(s.charAt(i));
    		}
    	}

        return sb.length() == 0 ? 1 : 0;
    }
    
    public static void main(String[] args) {
		String s = "cdcd";
		System.out.println(solution(s));
	}
}