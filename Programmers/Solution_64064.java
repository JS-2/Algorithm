
class Solution {
	
	public static boolean ban(String user, String ban) {
		if(user.length() != ban.length()) return false;
		for(int i = 0; i < user.length(); i++) {
			if(ban.charAt(i) == '*') continue;
			if(ban.charAt(i) != user.charAt(i)) return false;
		}
		return true;
	}
	
	public static int dfs(String[] user_id, String[] banned_id, int idx, int bit, boolean[] visited) {
		if(idx == banned_id.length) {
			if(visited[bit]) return 0;
			visited[bit] = true;
			return 1;
		}
		
		String now_banned_id = banned_id[idx];
		int cnt = 0;
		
		for(int i = 0; i < user_id.length; i++) {
			if((bit & 1 << i) > 0 || !ban(user_id[i], now_banned_id)) continue;
			bit = (bit | 1 << i);
			cnt += dfs(user_id, banned_id, idx + 1, bit, visited);
			bit = (bit & ~(1 << i));
		}
		
		return cnt;
	}
	
    public static int solution(String[] user_id, String[] banned_id) {
        return dfs(user_id, banned_id, 0, 0, new boolean[1 << user_id.length]);
    }
    
    public static void main(String[] args) {
    	String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
    	String[] banned_id = { "fr*d*", "*rodo", "******", "******" };
    	
		System.out.println(solution(user_id, banned_id));
	}
}