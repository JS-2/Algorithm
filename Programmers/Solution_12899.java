import java.util.Stack;

class Solution {
	
    public static String solution(int n) {
        StringBuilder answer = new StringBuilder();
    	Stack<Integer> stack = new Stack<>();
    	int mok = (n - 1) / 3;
    	int na = (n - 1) % 3;
    	stack.add(na);
    	while(mok > 3) {
    		na = (mok - 1) % 3;
    		mok = (mok - 1) / 3;
    		stack.add(na);
    	}
    	if(mok == 1 || mok == 2) answer.append(mok);
    	else if(mok == 3) answer.append(4);
    	
    	while(!stack.isEmpty()) {
    		int num = stack.pop();
    		if(num == 0) answer.append(1);
    		else if(num == 1) answer.append(2);
    		if(num == 2) answer.append(4);
    	}
        return answer.toString();
    }
    
    public static void main(String[] args) {
    		System.out.println(100 + ": " + solution(100));
    	
	}
}

//10진법에 1빼고 나누기 3
//
//1 - 1 0 
//2 - 1 1
//3 - 1 2
//4 - 1 / 3 -> 1 나머지 0
//5 - 1 / 3 -> 1 나머지 1
//6 - 1 / 3 -> 1 나머지 2
//7 - 1 / 3 -> 2 나머지 0
//8 - 1 / 3 -> 2 나머지 1
//9 - 1 / 3 -> 2 나머지 2
//10 - 1 / 3 -> 3 나머지 0
//11 - 1 / 3 -> 3 나머지 1
//12 - 1 / 3 -> 3 나머지 2
//13 - 1 / 3 -> 4 나머지 0 -> 4 - 1 / 3 -> 1 나머지 0, 0