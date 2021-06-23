import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> winSet = new HashSet<>();
        int sameCnt = 0;
        int zeroCnt = 0;
        for(int n: win_nums) {
            winSet.add(n);
        }
        for(int n: lottos) {
            if(n == 0) {
                ++zeroCnt;
                continue;
            } else if(winSet.contains(n)) {
                ++sameCnt;
            }
        }
        int[] answer = new int[2];
        answer[0] = zeroCnt + sameCnt < 2 ? 6 : 7 - zeroCnt - sameCnt;
        answer[1] = sameCnt < 2 ? 6 : 7 - sameCnt; 
        return answer;
    }
}