
class Solution {
	
    public static String solution(int[] numbers, String hand) {
    	final int[][] numPos = { { 3, 1 }, { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 }, { 2, 1 }, { 2, 2 } };
    	int[] lFinger = { 3, 0 };
    	int[] rFinger = { 3, 2 };
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int number: numbers) {
    		if(number == 1 || number == 4 || number == 7) {
    			lFinger = numPos[number];
    			sb.append("L");
    		} else if(number == 3 || number == 6 || number == 9) {
    			rFinger = numPos[number];
    			sb.append("R");
    		} else {
    			int[] posToMove = numPos[number];
    			int lDist = Math.abs(lFinger[0] - posToMove[0]) + Math.abs(lFinger[1] - posToMove[1]);
    			int rDist = Math.abs(rFinger[0] - posToMove[0]) + Math.abs(rFinger[1] - posToMove[1]);
    			
    			if(lDist > rDist) {
    				rFinger = posToMove;
    				sb.append("R");
    			} else if(lDist < rDist) {
    				lFinger = posToMove;
    				sb.append("L");
    			} else {
    				if(hand.equals("right")) {
    					rFinger = posToMove;
    					sb.append("R");
    				} else {
    					lFinger = posToMove;
    					sb.append("L");
    				}
    			}
    		}
    	}
    	
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
    	String hand = "right";
		System.out.println(solution(numbers, hand));
	}
}