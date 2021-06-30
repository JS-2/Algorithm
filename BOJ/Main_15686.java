import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Point> chicken; // 치킨집들의 위치
	static ArrayList<Point> home; // 집들의 위치
	static int answer = Integer.MAX_VALUE;
	static int M; // 남길 치킨집
	static int numberOfChicken = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		for(int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col = 0; col < N; col++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 1) home.add(new Point(row, col));
				else if(n == 2) { 
					chicken.add(new Point(row, col));
					++numberOfChicken;
				}
			}
		}
		
		combination(0, 0, new Point[M]);
		System.out.println(answer);
	}
	
	private static void combination(int index, int cnt, Point[] choice) {
		if(cnt == M) {
			//가까운 치킨거리를 구한다.
			Iterator<Point> iter = home.iterator();
			int sum = 0;
			while(iter.hasNext()) {
				Point h = iter.next();
				int minDistance = Integer.MAX_VALUE;
				
				for(int i = 0; i < choice.length; i++) {
					int diffX = h.x - choice[i].x;
					int diffY = h.y - choice[i].y;
					int distance = Math.abs(diffX) + Math.abs(diffY);
					minDistance = minDistance > distance ? distance : minDistance;
				}
				sum += minDistance;
			}
			answer = answer > sum ? sum : answer;
			return;
		}
		
		if(index == numberOfChicken)
			return;
		
		choice[cnt] = chicken.get(index);
		combination(index + 1, cnt + 1, choice);
		combination(index + 1, cnt, choice);
	}

}
