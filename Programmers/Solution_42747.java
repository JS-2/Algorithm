import java.util.Arrays;

class Solution {
    
	public static int solution(int[] citations) {
		Arrays.sort(citations);
		for(int i = citations.length - 1; i >= 0; i--) {
			if(citations[i] < citations.length - i) return citations.length - i - 1;
		}
        return citations.length;
    }
    
    public static void main(String[] args) {
		int[] citations = { 0, 0, 0, 0 };
		System.out.println(solution(citations));
	}
}