import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    long answer;
    
    public void operList(ArrayList<Long> newNumList, ArrayList<Character> newOperList, int operIdx) {
        char oper;
        if(operIdx == 0) oper = '+';
        else if(operIdx == 1) oper = '-';
        else oper = '*';
        
        while(newOperList.contains(oper)) {
            int index = newOperList.indexOf(oper);
            long result;
            if(oper == '+') result = newNumList.get(index) + newNumList.get(index + 1);
            else if(oper == '-') result = newNumList.get(index) - newNumList.get(index + 1);
            else result = newNumList.get(index) * newNumList.get(index + 1);
            newNumList.remove(index);
            newNumList.remove(index);
            newOperList.remove(index);
            newNumList.add(index, result);
        }
        
    }
    
    public void dfs(ArrayList<Long> numList, ArrayList<Character> operList, int depth, boolean operVisited[]) {
        if(depth == 3) {
            answer = Math.max(answer, Math.abs(numList.get(0)));
            return;
        }
        for(int operIdx = 0; operIdx < 3; operIdx++) {
            if(operVisited[operIdx]) continue;
            operVisited[operIdx] = true;
            ArrayList<Long> newNumList = (ArrayList<Long>)numList.clone();
            ArrayList<Character> newOperList = (ArrayList<Character>)operList.clone();
            operList(newNumList, newOperList, operIdx);
            dfs(newNumList, newOperList, depth + 1, operVisited);
            operVisited[operIdx] = false;
        }
    }
    public long solution(String expression) {
        answer = 0;
        String temp = "";
        ArrayList<Long> numList = new ArrayList<>();
        ArrayList<Character> operList = new ArrayList<>();
        
        for(int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '+' ||
               expression.charAt(i) == '-' ||
               expression.charAt(i) == '*') {
                numList.add(Long.parseLong(temp));
                temp = "";
                operList.add(expression.charAt(i));
            } else {
                temp += expression.charAt(i);
            }
        }
        numList.add(Long.parseLong(temp));
        dfs(numList, operList, 0, new boolean[3]);
        return answer;
    }
}