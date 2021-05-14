import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	final static int U = 0, D = 1, F = 2, B = 3, L = 4, R = 5;
	//인접 면들
	//행인지 열인지
	//들어가는건 반시계방향으로
	final static int[][][] adj = { 
			{ { F, 0, -1 }, { R, 0, -1 }, { B, 0, -1 }, { L, 0, -1 } },
			{ { F, 2, -1 }, { L, 2, -1 }, { B, 2, -1 }, { R, 2, -1 } },
			{ { U, 2, -1 }, { L, -1, 2 }, { D, 0, -1 }, { R, -1, 0 } },
			{ { U, 0, -1 }, { R, -1, 2 }, { D, 2, -1 }, { L, -1, 0 } },
			{ { U, -1, 0 }, { B, -1, 2 }, { D, -1, 0 }, { F, -1, 0 } },
			{ { U, -1, 2 }, { F, -1, 2 }, { D, -1, 2 }, { B, -1, 0 } }
	};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int Ti = 0; Ti < T; Ti++) {
			char[][][] cube = {
					{
						{ 'w', 'w', 'w' },
						{ 'w', 'w', 'w' },
						{ 'w', 'w', 'w' }
					},
					{
						{ 'y', 'y', 'y' },
						{ 'y', 'y', 'y' },
						{ 'y', 'y', 'y' }
					},
					{
						{ 'r', 'r', 'r' },
						{ 'r', 'r', 'r' },
						{ 'r', 'r', 'r' }
					},
					{
						{ 'o', 'o', 'o' },
						{ 'o', 'o', 'o' },
						{ 'o', 'o', 'o' },
					},
					{
						{ 'g', 'g', 'g' },
						{ 'g', 'g', 'g' },
						{ 'g', 'g', 'g' }
					},
					{
						{ 'b', 'b', 'b' },
						{ 'b', 'b', 'b' },
						{ 'b', 'b', 'b' }
					},
			};
			
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				char[] chars = st.nextToken().toCharArray();
				//U = 0, D = 1, F = 2, B = 3, L = 4, R = 5;
				int now;
				
				if(chars[0] == 'U') now = 0;
				else if(chars[0] == 'D') now = 1;
				else if(chars[0] == 'F') now = 2;
				else if(chars[0] == 'B') now = 3;
				else if(chars[0] == 'L') now = 4;
				else now = 5;
				
				turn(cube, now, chars[1]);
			}
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					sb.append(cube[U][i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}
	
	public static void turn(char[][][] cube, int now, char direction) {
		Queue<Character> q = new LinkedList<>();
		LinkedList<char[]> adjQ = new LinkedList<>();
		
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				q.add(cube[now][r][c]); 
			}
		}
		
		if(direction == '+') {
			for(int r = 0; r < 3; r++) {
				for(int c = 0; c < 3; c++) {
					cube[now][c][2 - r] = q.poll(); 
				}
			}
			
			for(int[] ad: adj[now]) {
				adjQ.add(getRowCol(cube, ad));
			}
			adjQ.add(adjQ.poll());
		} else {
			for(int r = 0; r < 3; r++) {
				for(int c = 0; c < 3; c++) {
					cube[now][2 - c][r] = q.poll(); 
				}
			}
			
			for(int[] ad: adj[now]) {
				adjQ.add(getRowCol(cube, ad));
			}
			adjQ.addFirst(adjQ.pollLast());
		}
		
		for(int[] ad: adj[now]) {
			setRowCol(cube, ad, adjQ.poll());
		}
		
		if(now == F) {
			if(direction == '-') {
				swap(cube, R, 0, 0, 2, 0);
				swap(cube, L, 0, 2, 2, 2);
			} else {
				swap(cube, D, 0, 0, 0, 2);
				swap(cube, U, 2, 0, 2, 2);	
			}
		} else if(now == B) {
			if(direction == '-') {
				swap(cube, U, 0, 0, 0, 2);
				swap(cube, D, 2, 0, 2, 2);
			} else {
				swap(cube, L, 0, 0, 2, 0);
				swap(cube, R, 0, 2, 2, 2);	
			}
		}
	}
	
	public static char[] getRowCol(char[][][] cube, int[] dir) {
		int myun = dir[0];
		int row = dir[1];
		int col = dir[2];
		
		if(row != -1) return cube[myun][row];
		
		char[] colArr = new char[3];
		int cnt = 0;
		for(char[] rowArr: cube[myun]) colArr[cnt++] = rowArr[col]; 
		if(myun == B) {
			char temp = colArr[0];
			colArr[0] = colArr[2];
			colArr[2] = temp;
		}
		return colArr;
	}
	
	public static void setRowCol(char[][][] cube, int[] dir, char[] setArr) {
		int myun = dir[0];
		int row = dir[1];
		int col = dir[2];
		
		if(row != -1) {
			cube[myun][row] = setArr;
			return;
		}
		
		int cnt = 0;
		if(myun == B) {
			char temp = setArr[0];
			setArr[0] = setArr[2];
			setArr[2] = temp;
		}
		for(char[] rowArr: cube[myun]) rowArr[col] = setArr[cnt++]; 
	}
	
	public static void swap(char[][][] cube, int myun, int r1, int c1, int r2, int c2) {
		char temp = cube[myun][r1][c1];
		cube[myun][r1][c1] = cube[myun][r2][c2];
		cube[myun][r2][c2] = temp;
	}
}
