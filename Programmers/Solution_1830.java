import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	
	public static boolean checkRule1(String str) {
		if(str.length() % 2 == 0) return false;
		if(str.length() == 1) return false;
		
		char pattern = str.charAt(1);
		for(int i = 0; i < str.length(); i++) {
			if(i % 2 == 0) {
				if(Character.isLowerCase(str.charAt(i))) return false;
			} else {
				if(pattern != str.charAt(i)) {
					return false;
				}
			}
			
		}
		return true;
	}
	
	public static String rule1(String str, boolean[] patternVisited) {
		StringBuilder sb = new StringBuilder();
		if(patternVisited[str.charAt(1) - 'a']) return null;
		patternVisited[str.charAt(1) - 'a'] = true;
		for(int i = 0; i < str.length(); i += 2) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
	public static String rule2(String str, boolean[] patternVisited) {
		if(patternVisited[str.charAt(0) - 'a']) return null;
		patternVisited[str.charAt(0) - 'a'] = true;
		String result = str.substring(1, str.length() - 1);
		if(result.equals(result.toUpperCase())) {
			return result;
		} else {
			if(checkRule1(result)) {
				return rule1(result, patternVisited);
			} else {
				return null;
			}
		}	
	}
	
	public static boolean addAnswer(ArrayList<String> answers, String subStr, boolean[] patternVisited) {
		if(Character.isUpperCase(subStr.charAt(0))) {
			if(subStr.length() == 1) {
				answers.add(subStr);
				return false;
			}
			if(!checkRule1(subStr)) {
				return true;
			}
			String result = rule1(subStr, patternVisited);
			if(result == null || result.equals("")) return true;
			answers.add(result);
		} else {
			String result = rule2(subStr, patternVisited);
			if(result == null || result.equals("")) return true;
			answers.add(result);
		}
		return false;
	}
    
	public static String solution(String sentence) {
        String sb = "";
        ArrayList<String> answers = new ArrayList<>();
        if(sentence.replaceAll("[^A-Za-z]", "").length() != sentence.length()) return "invalid";
        if(sentence.length() == 0) return "invalid";
		int[] patternCnt = new int[27];
		int[] patternLeft = new int[27];
		int[] patternRight = new int[27];
		boolean[] patternVisited = new boolean[27];
		
		Arrays.fill(patternLeft, -1);
		Arrays.fill(patternRight, -1);
		
		for(int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			if(Character.isLowerCase(c)) {
				++patternCnt[c - 'a'];
				if(patternLeft[c - 'a'] == -1) {
					patternLeft[c - 'a'] = i;
				} else {
					patternRight[c - 'a'] = i;
				}
			}
		}
		
		int left = 0;
		
		for(int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			if(Character.isLowerCase(c)) {
				if(patternVisited[c - 'a']) return "invalid";
				
				if(patternCnt[c - 'a'] == 1) {
					if(i == 0 || i == sentence.length() - 1) return "invalid";
					if(left < i - 1) {
						String sub = sentence.substring(left, i - 1);
						answers.add(sub);
					}
					if(left <= i - 1) {
						boolean isInvalid = addAnswer(answers, sentence.substring(i - 1, i + 2), patternVisited);
						if(isInvalid) return "invalid";
					} else {
						return "invalid";
					}
					i = i + 1;
				} else if(patternCnt[c - 'a'] == 2) {
					if(i != left) answers.add(sentence.substring(left, i));
					boolean isInvalid = addAnswer(answers, sentence.substring(i, patternRight[c - 'a'] + 1), patternVisited);
					if(isInvalid) return "invalid";
					i = patternRight[c - 'a'];
				} else {
					if(i == left || 
					   i - 1 > patternRight[c - 'a'] + 2 || 
					   patternRight[c - 'a'] + 1 >= sentence.length() ||
					   !checkRule1(sentence.substring(i - 1, patternRight[c - 'a'] + 2))) return "invalid";
					else if(i > left + 1) answers.add(sentence.substring(left, i - 1));
						
					if(sentence.length() < patternRight[c - 'a'] + 1) return "invalid";
					boolean isInvalid = addAnswer(answers, sentence.substring(i - 1, patternRight[c - 'a'] + 2), patternVisited);
					if(isInvalid) return "invalid";
					i = patternRight[c - 'a'] + 1;
				}
				left = i + 1;
			}
		}
		if(left < sentence.length()) {
			answers.add(sentence.substring(left));
		}
		
		for(int i = 0; i < answers.size(); i++) {
			sb += answers.get(i);
			if(i == answers.size() - 1) break;
			sb += " ";
		}
		
		return sb.toString();
    }

	public static void main(String[] args) {
//		System.out.println(solution("HaEaLaLaObWORLDb"));
//		System.out.println(solution("SpIpGpOpNpGJqOqA"));
//		System.out.println(solution("AxAxAxAoBoBoB"));
//		System.out.println(solution("LzS"));
//		System.out.println(solution("OGjE"));
//		System.out.println(solution("LpXbZ"));
		System.out.println(solution("DWMdARdXjFjOjN"));
	}
}