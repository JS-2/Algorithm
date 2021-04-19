import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class Solution {
	 
	static class Work {
		int progress;
		int speed;
		int num;
		
		Work(int _progress, int _speed, int _num) {
			progress = _progress;
			speed = _speed;
			num = _num;
		}
		
		public boolean next() {
			progress += speed;
			if(progress >= 100) return true;
			else return false;
		}
	}
	
    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<>(); // 답 저장 배열리스트 생성
        ArrayList<Work> works = new ArrayList<>(); // Work 배열 리스트 생성
        boolean[] canDeploy = new boolean[progresses.length + 1];
        int deployOrder = 0;
        
        for(int i = 0; i < progresses.length; i++) {
        	works.add(new Work(progresses[i], speeds[i], i)); // Work 객체 할당
        }
        
        while(!works.isEmpty()) {
        	Iterator<Work> iter = works.iterator();
        	while(iter.hasNext()) {
        		Work w = iter.next();
        		if(w.next()) {
        			canDeploy[w.num] = true;
        			iter.remove();
        		}
        	}
        	int deployCnt = 0;
        	while(canDeploy[deployOrder]) {
        		++deployOrder;
        		++deployCnt;
        	}
        	if(deployCnt > 0) answerList.add(deployCnt);
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++) answer[i] = answerList.get(i);
        
        return answer;
    }
    
    public static void main(String[] args) {
    	int[] progresses = { 95, 90, 99, 99, 80, 99 }; 
    	int[] speeds = { 1, 1, 1, 1, 1, 1 };
    	System.out.println(Arrays.toString(solution(progresses, speeds)));
	}
}