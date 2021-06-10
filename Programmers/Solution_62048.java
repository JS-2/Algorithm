
class Solution {
	
    public static long solution(int w, int h) {
        long answer = 1;
        answer = answer * (long)w * (long)h;
        
        if(w < h) {
        	int temp = w;
        	w = h;
        	h = temp;
        }
        
        long cnt = 0;
        
        for(int i = 0; i < h; i++) {
        	double top = i * (double)w / (double)h;
        	double bottom = (i + 1) * (double)w / (double)h;
        	cnt += Math.ceil(bottom) - Math.floor(top);
        }
        
        return answer - cnt;
    }
    
    public static void main(String[] args) {
		System.out.println(solution(8, 12));
	}
}