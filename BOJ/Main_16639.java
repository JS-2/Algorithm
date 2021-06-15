import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String math = br.readLine();
		ArrayList<Long> arr = cal(math);
		long max = Long.MIN_VALUE;
		for(int i = 0; i < arr.size(); i++) 
			max = Math.max(max, arr.get(i));
		System.out.println(max);
	}
	
	public static ArrayList<Long> cal(String math) {
		ArrayList<Long> arr = new ArrayList<>();
		if(math.length() == 1) {
			arr.add(Long.parseLong(math));
			return arr;
		}
		for(int i = 1; i < math.length(); i += 2) {
			ArrayList<Long> cal1 = cal(math.substring(0, i));
			ArrayList<Long> cal2 = cal(math.substring(i + 1, math.length()));
			for(int j = 0; j < cal1.size(); j++) {
				for(int k = 0; k < cal2.size(); k++) {
					switch(math.charAt(i)) {
					case '+':
						arr.add(cal1.get(j) + cal2.get(k));
						break;
					case '-':
						arr.add(cal1.get(j) - cal2.get(k));
						break;
					case '*':
						arr.add(cal1.get(j) * cal2.get(k));
						break;
					}
				}
			}
		}
		return arr;
	}
}