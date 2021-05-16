import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	final static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static char[][] map;
	static int R, C;
	static BufferedReader br;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			if(R == 0 && C == 0) break;
			bfs();
		}
		System.out.print(sb.toString());
	}
	
	public static void bfs() throws IOException {
		int[] cleanerPos = null;
		
		map = new char[R][C];
		int cnt = 0;
		int goal = 0;
		for(int r = 0; r < R; r++) {
			char[] chars = br.readLine().toCharArray();
			for(int c = 0; c < C; c++) {
				map[r][c] = chars[c];
				if(chars[c] == '*') {
					map[r][c] = (char)('0' + cnt);
					goal = goal | (1 << cnt++);
				} else if(chars[c] == 'o') cleanerPos = new int[] { r, c, 0 };
			}
		}
		if(cnt == 0) {
			sb.append(0).append("\n");
			return;
		}
		boolean[][][] visited = new boolean[R][C][1 << cnt];
		Queue<int[]> q = new LinkedList<>();
		q.add(cleanerPos);
		visited[cleanerPos[0]][cleanerPos[1]][0] = true;
		
		int answer = -1;
		
		int move = 0;
		loop:
		while(!q.isEmpty()) {
			int qsize = q.size();
			for(int qi = 0; qi < qsize; qi++) {
				int[] pos = q.poll();
				int row = pos[0];
				int col = pos[1];
				int clean = pos[2];
				
				for(int[] d: dir) {
					int newRow = row + d[0];
					int newCol = col + d[1];
					int newClean = clean;
					if(newRow < 0 || newRow >= R ||
					   newCol < 0 || newCol >= C ||
					   map[newRow][newCol] == 'x' ||
					   visited[newRow][newCol][newClean]) continue;
					visited[newRow][newCol][newClean] = true;
					if(map[newRow][newCol] >= '0' && map[newRow][newCol] <= '9') {
						int num = map[newRow][newCol] - '0';
						newClean = newClean | (1 << num);
						if(newClean == goal) {
							answer = move + 1;
							break loop;
						}
						q.add(new int[] { newRow, newCol, newClean });
						continue;
					}
					q.add(new int[] { newRow, newCol, newClean });
				}
			}
			++move;
		}
		sb.append(answer).append("\n");
	}
}