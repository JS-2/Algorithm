import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	final static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static char[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new char[12][];
		for(int i = 0; i < 12; i++) map[i] = br.readLine().toCharArray();
		
		int answer = 0;
		loop:
		while(true) {
			boolean flag = false;
			for(int r = 0; r < 12; r++) {
				for(int c = 0; c < 6; c++) {
					if(map[r][c] == '.') continue;
					flag = flag | puyo(r, c, new boolean[12][6]);
				}
			}
			gravity();
			if(flag) ++answer;
			else break;
		}
		System.out.println(answer);
	}
	
	public static void gravity() {
		for(int row = 10; row >= 0; row--) {
			for(int col = 0; col < 6; col++) {
				if(map[row][col] != '.' && map[row + 1][col] == '.') {
					
					int nextRow = row + 1;
					while(nextRow <= 11 && map[nextRow][col] == '.') {
						map[nextRow][col] = map[nextRow - 1][col];
						map[nextRow - 1][col] = '.';
						++nextRow;
					}
				}
			}
		}
	}
	
	public static boolean puyo(int r, int c, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		visited[r][c] = true;
		char nowColor = map[r][c];
		
		Queue<int[]> puyoPos = new LinkedList<>();
		puyoPos.add(new int[] { r, c });
		
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int row = pos[0];
			int col = pos[1];
			
			for(int[] d: dir) {
				int newRow = row + d[0];
				int newCol = col + d[1];
				if(newRow < 0 || newRow >= 12 ||
				   newCol < 0 || newCol >= 6 ||
				   visited[newRow][newCol] ||
				   nowColor != map[newRow][newCol]) continue;
				visited[newRow][newCol] = true;
				++cnt;
				q.add(new int[] { newRow, newCol });
				puyoPos.add(new int[] { newRow, newCol });
			}
		}
		if(cnt < 4) return false;
		
		while(!puyoPos.isEmpty()) {
			int[] pos = puyoPos.poll();
			int row = pos[0];
			int col = pos[1];
			map[row][col] = '.';
		}
		return true;
	}
}
