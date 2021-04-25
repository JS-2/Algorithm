import java.util.Arrays;
import java.util.Comparator;

class Solution {
	
    public static String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
    	
        for(int i = 0; i < numbers.length; i++) {
    		strNumbers[i] = Integer.toString(numbers[i]);
    	}
    	
        Arrays.sort(strNumbers, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int temp1 = Integer.parseInt(o1 + o2);
				int temp2 = Integer.parseInt(o2 + o1);
				return temp2 - temp1;
			}
        });
        
        if(strNumbers[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String str: strNumbers) sb.append(str);
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	int[] numbers = { 0, 0, 0, 0, 0 };
    	System.out.println(solution(numbers));
	}
}