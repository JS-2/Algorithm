import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
	
	final static int JOIN_STATE = 0;
	final static int OUT_STATE = 1;
	
	static class Chat {
		String uid;
		int joinOrOut; // t: µé¾î¿È, f: ³ª°¨
		
		Chat(String _uid, int _joinOrOut) {
			uid = _uid;
			joinOrOut = _joinOrOut;
		}
	}
	
    public static String[] solution(String[] record) {
        HashMap<String, String> user = new HashMap<>();
    	
        ArrayList<Chat> chats = new ArrayList<>();
        for(String r: record) {
        	StringTokenizer st = new StringTokenizer(r);
        	String cmd = st.nextToken();
    		String uid = st.nextToken();
        	if(cmd.equals("Enter")) {
        		String name = st.nextToken();
        		chats.add(new Chat(uid, JOIN_STATE));
        		user.put(uid, name);
        	} else if(cmd.equals("Leave")) {
        		chats.add(new Chat(uid, OUT_STATE));
        	} else if(cmd.equals("Change")) {
        		String name = st.nextToken();
        		user.put(uid, name);
        	}
        }
        String[] answer = new String[chats.size()];
        for(int i = 0; i < chats.size(); i++) {
        	Chat chat = chats.get(i);
        	answer[i] = user.get(chat.uid);
        	if(chat.joinOrOut == JOIN_STATE) {
        		answer[i] += "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
        	} else if(chat.joinOrOut == OUT_STATE) {
        		answer[i] += "´ÔÀÌ ³ª°¬½À´Ï´Ù.";
        	}
        }
        return answer;
    }
    
    public static void main(String[] args) {
    	String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan" };
		System.out.println(Arrays.toString(solution(record)));
	}
}