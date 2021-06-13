import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
	
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
    	ArrayList<Queue<Integer>> cols = new ArrayList<>();
    	Stack<Integer> bucket = new Stack<>();
    	
    	for(int i = 0; i < board.length; i++) {
    		cols.add(new LinkedList<>());
    	}
    	
    	for(int c = 0; c < board.length; c++) {
    		Queue<Integer> col = cols.get(c);
    		for(int r = 0; r < board.length; r++) {
    			if(board[r][c] == 0) continue;
    			col.add(board[r][c]);
    		}
    	}
    	
    	for(int move: moves) {
    		--move;
    		Queue<Integer> col = cols.get(move);
    		if(col.size() == 0) continue;
    		int doll = col.poll();
    		
    		if(!bucket.isEmpty() && bucket.peek() == doll) {
    			bucket.pop();
    			answer += 2;
    		} else {
    			bucket.add(doll);
    		}
    	}
    	
        return answer;
    }
    
    public static void main(String[] args) {
    	int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
    	int[] moves = { 1,5,3,5,1,2,1,4 };
		System.out.println(solution(board, moves));
	}
}