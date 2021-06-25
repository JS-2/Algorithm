import java.util.*;

class Solution {
    
    static class FailPercent {
        double percent;
        int stage;
        FailPercent(double _percent, int _stage) {
            percent = _percent;
            stage = _stage;
        }
        
        @Override
        public String toString() {
        	return "stage: " + stage + ", percent: " + percent;
        }
    }
    
    // 1, 2, 2, 3, 4
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Arrays.sort(stages);
        int beforeIdx = 0;
        int idx = 0;
        
        FailPercent[] failPercents = new FailPercent[N];
        
        for(int stage = 1; stage <= N; stage++) {
            while(idx != stages.length && stages[idx] <= stage) {
                ++idx;
            }
            if(idx == beforeIdx) failPercents[stage - 1] = new FailPercent(0, stage);
            else failPercents[stage - 1] = new FailPercent((double)(idx - beforeIdx) / (double)(stages.length - beforeIdx), stage);
            beforeIdx = idx;
        }
        Arrays.sort(failPercents, new Comparator<FailPercent>() {
            @Override
            public int compare(FailPercent o1, FailPercent o2) {
                if(o1.percent == o2.percent) {
                    return o1.stage - o2.stage;
                }
                if(o1.percent - o2.percent < 0) return 1;
                else return -1;
            }
        });
        
        for(int i = 0; i < failPercents.length; i++) {
            answer[i] = failPercents[i].stage;
        }
        return answer;
    }
    
    public static void main(String[] args) {
    	int N = 5;
    	//0.2 0.5 0.5 
    	int[] stages = { 1, 2, 2, 3, 4 };
    	System.out.println(Arrays.toString(solution(N, stages)));
	}
}