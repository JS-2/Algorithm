import java.util.ArrayList;

class Solution {
	
    public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        ArrayList<String> subStr1 = new ArrayList<>();
        ArrayList<String> subStr2 = new ArrayList<>();
        
        for(int i = 0; i < str1.length() - 1; i++) {
        	String sub = str1.substring(i, i + 2);
        	sub = sub.replaceAll("[^a-zA-Z]", "");
        	if(sub.length() != 2) continue;
        	subStr1.add(str1.substring(i, i + 2));
        }
        
        for(int i = 0; i < str2.length() - 1; i++) {
        	String sub = str2.substring(i, i + 2);
        	sub = sub.replaceAll("[^a-zA-Z]", "");
        	if(sub.length() != 2) continue;
        	subStr2.add(str2.substring(i, i + 2));
        }
        
        ArrayList<String> hab = new ArrayList<>();
        ArrayList<String> gyo = new ArrayList<>();
        
        for(int i = 0; i < subStr1.size(); i++) {
        	String sub = subStr1.get(i);
        	if(subStr2.contains(sub)) {
        		subStr2.remove(sub);
        		gyo.add(sub);
        	}
        	hab.add(sub);
        }
        
        for(int i = 0; i < subStr2.size(); i++) {
        	hab.add(subStr2.get(i));
        }
        
        if(hab.size() == 0) return 65536;
        return 65536 * gyo.size() / hab.size();
    }
    
    public static void main(String[] args) {
		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";
		
		System.out.println(solution(str1, str2));
	}
}