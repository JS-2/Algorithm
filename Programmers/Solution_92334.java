import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reportMap = new HashMap<>();
        
        for(String r: report) {
            String[] rSplit = r.split(" ");
            String reporter = rSplit[0];
            String criminal = rSplit[1];
            
            Set<String> reporterSet = reportMap.getOrDefault(criminal, new HashSet<>());
            reporterSet.add(reporter);
            reportMap.put(criminal, reporterSet);
        }
        
        for(String criminal: reportMap.keySet()) {
            Set<String> reporterSet = reportMap.get(criminal);
            
            if(reporterSet.size() < k) continue;
            
            for(String reporter: reporterSet) {
                ++answer[Arrays.asList(id_list).indexOf(reporter)];
            }
        }
        
        return answer;
    }
}