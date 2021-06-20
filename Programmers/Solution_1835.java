import java.util.Arrays;

class Solution {
	
	final static char[] person = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	static int answer;
	
	public static boolean canPhoto(int person1, int person2, char oper, int num) {
		if(oper == '=') {
			if(Math.abs(person1 - person2) - 1 != num) return false;
		} else if(oper == '<') {
			if(Math.abs(person1 - person2) - 1 >= num) return false;
		} else if(oper == '>') {
			if(Math.abs(person1 - person2) - 1 <= num) return false;
		}
		return true;
	}
	
	public static void permutation(int cnt, int[] pos, boolean[] visited, String[] data) {
		if(cnt == 8) {
			for(String d: data) {
				if(!canPhoto(pos[d.charAt(0) - 'A'], pos[d.charAt(2) - 'A'], d.charAt(3), d.charAt(4) - '0')) {
					return;
				}
			}
			++answer;
			return;
		}
		
		for(int i = 0; i < 8; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			pos[person[i] - 'A'] = cnt;
			permutation(cnt + 1, pos, visited, data);
			visited[i] = false;
		}
	}
	
    public static int solution(int n, String[] data) {
        answer = 0;
        permutation(0, new int[20], new boolean[8], data);
        return answer;
    }
    
    public static void main(String[] args) {
		System.out.println(solution(2, new String[] {"M~C<2", "C~M>1"}));
	}
}