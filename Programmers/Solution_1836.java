import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

class Solution {
	
	static String answer = "";
	
	public static boolean canMove(char[][] cBoard, int[] from, int[] to, boolean isRC) {
		int fromR = from[0];
		int fromC = from[1];
		char alphabet = cBoard[from[0]][from[1]];
		int dirR = to[0] - from[0] > 0 ? 1 : -1;
		int dirC = to[1] - from[1] > 0 ? 1 : -1;
		
		if(isRC) {
			while(fromR != to[0]) {
				fromR += dirR;
				if(cBoard[fromR][fromC] != '.' && cBoard[fromR][fromC] != alphabet) return false;
			}
			while(fromC != to[1]) {
				fromC += dirC;
				if(cBoard[fromR][fromC] != '.' && cBoard[fromR][fromC] != alphabet) return false;
			}
		} else {
			while(fromC != to[1]) {
				fromC += dirC;
				if(cBoard[fromR][fromC] != '.' && cBoard[fromR][fromC] != alphabet) return false;
			}
			while(fromR != to[0]) {
				fromR += dirR;
				if(cBoard[fromR][fromC] != '.' && cBoard[fromR][fromC] != alphabet) return false;
			}
		}
		return true;
	}
	
	public static boolean canRemove(char[][] cBoard, int[][] pos) {
		return canMove(cBoard, pos[0], pos[1], false) || canMove(cBoard, pos[0], pos[1], true);
	}
	
	public static void dfs(String removes, int[][][] apbPos, char[][] cBoard, ArrayList<Character> keys, ArrayList<Character> canRemoveApb) {
		if(keys.size() == 0 && canRemoveApb.size() == 0) {
			answer = removes;
			return;
		}
		
		Iterator<Character> iter = keys.iterator();
		
		while(iter.hasNext()) {
			char apb = iter.next();
			int[][] positions = apbPos[apb - 'A'];
    		if(canRemove(cBoard, positions)) {
    			canRemoveApb.add(apb);
        		iter.remove();
    		}
		}
		
		Collections.sort(canRemoveApb);
		
		for(char apb: canRemoveApb) {
			int[][] positions = apbPos[apb - 'A'];
			for(int[] pos: positions) {
				cBoard[pos[0]][pos[1]] = '.';
			}
			canRemoveApb.remove(Character.valueOf(apb));
			
			dfs(removes + apb, apbPos, cBoard, keys, canRemoveApb);
			
			if(answer.length() != 0) return;
			
			for(int[] pos: positions) {
				cBoard[pos[0]][pos[1]] = apb;
			}
			canRemoveApb.add(apb);
		}
		answer = "IMPOSSIBLE";
	}
	
    public static String solution(int m, int n, String[] board) {
        int[][][] apbPos = new int[26][2][];
        int[] apbVisit = new int[26];
        char[][] cBoard = new char[board.length][board[0].length()];

        ArrayList<Character> keys = new ArrayList<>();
        
        for(int r = 0; r < board.length; r++) {
        	char[] chars = board[r].toCharArray();
        	for(int c = 0; c < chars.length; c++) {
        		cBoard[r][c] = chars[c];
        		if(cBoard[r][c] == '.' || cBoard[r][c] == '*') continue;
        		++apbVisit[cBoard[r][c] - 'A'];
        		if(apbVisit[cBoard[r][c] - 'A'] == 2) { // µÎ¹øÂ°
        			apbPos[cBoard[r][c] - 'A'][1] = new int[] { r, c };
        		} else {
        			apbPos[cBoard[r][c] - 'A'][0] = new int[] { r, c };
        			keys.add(cBoard[r][c]);
        		}
        	}
        }
        
        dfs("", apbPos, cBoard, keys, new ArrayList<>());
        return answer.length() == 0 ? "IMPOSSIBLE" : answer;
    }
    
    public static void main(String[] args) {
    	int m = 4;
    	int n = 4;
    	String[] board = { 
    			"GGHD", "ADHF", "*ACB", "CF*B" };
    	
		System.out.println(solution(m, n, board));
	}
}