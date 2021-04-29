import java.util.HashSet;
import java.util.Set;

class Solution {
	
	public static void permutation(int N, int cnt, String[] numberArr, String[] selectArr, boolean[] visited, Set<Integer> s) {
		if(cnt == N) {
			String temp = "";
			for(String number: selectArr) { temp += number; }
			int number = Integer.parseInt(temp);
			if(s.contains(number) || number <= 1) { return; }
			for(int i = 2; i <= (int)Math.sqrt(number); i++) {
				if(number % i == 0) { return; }
			}
			s.add(number);
			return;
		}
		for(int i = 0; i < numberArr.length; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			selectArr[cnt] = numberArr[i];
			permutation(N, cnt + 1, numberArr, selectArr, visited, s);
			visited[i] = false;
		}
	}
    public static int solution(String numbers) {
        Set<Integer> s = new HashSet<>();
        String[] numberArr = new String[numbers.length()];
        for(int i = 0; i < numberArr.length; i++) { 
        	numberArr[i] = numbers.substring(i, i + 1); 
        }
        for(int i = 1; i <= numberArr.length; i++) {
        	permutation(i, 0, numberArr, new String[i], new boolean[numberArr.length], s);
        }
        return s.size();
    }
    
    public static void main(String[] args) {
		String numbers = "701";
		System.out.println(solution(numbers));
	}
}