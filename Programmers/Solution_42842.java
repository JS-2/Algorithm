import java.util.Arrays;

class Solution {
    public static int[] solution(int brown, int yellow) {
    	int total = brown + yellow;
    	for(int height = 1; height <= (int)Math.sqrt(yellow); height++) {
    		if(yellow % height != 0) continue;
    		int width = yellow / height;
    		if((width + 2) * (height + 2) == total) return new int[] { width + 2, height + 2 };
    	}
    	return null;
    }
    
    public static void main(String[] args) {
		int brown = 24;
		int yellow = 24;
		System.out.println(Arrays.toString(solution(brown, yellow)));
	}
}