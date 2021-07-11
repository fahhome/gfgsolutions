package gfg;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SparseRankStudents {

    public static void solve(String[] studentsarr , Integer[] marksarr){

        Map<String,Integer> totalMarksMap = new LinkedHashMap<>();
        Map<String, Integer> totalSubjectsMap = new LinkedHashMap<>();
        Map<String, Integer> averageScoreMap = new LinkedHashMap<>();


        for(int i = 0 ; i < studentsarr.length ; i++){
            if(totalMarksMap.containsKey(studentsarr[i])){
                totalMarksMap.put(studentsarr[i], totalMarksMap.get(studentsarr[i]) + marksarr[i]);
                totalSubjectsMap.put(studentsarr[i] , totalSubjectsMap.get(studentsarr[i]) + 1);
            }else{
                totalMarksMap.put(studentsarr[i],marksarr[i]);
                totalSubjectsMap.put(studentsarr[i], 1);
            }
        }

        for (Map.Entry<String, Integer> entry : totalMarksMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
            averageScoreMap.put(entry.getKey() , entry.getValue() / totalSubjectsMap.get(entry.getKey()));
        }


        Map<String, Integer> sortedByScore = averageScoreMap.entrySet()
                            .stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        
        System.out.println(sortedByScore);

        // Implement Dense Ranking

        int current_normal_rank = 0;
        int current_sparse_rank = 0 ;
        int prevScore = Integer.MAX_VALUE ;

        for (Map.Entry<String, Integer> entry : sortedByScore.entrySet()) {
            current_normal_rank++ ;
            if(entry.getValue() != prevScore){
                prevScore = entry.getValue();
                current_sparse_rank = current_normal_rank ;
            }

            System.out.println(entry.getKey() +  " : " +  current_sparse_rank);

        }


    }

    public static void main(String[] args) {

        String[] studentsarr = {"Fahmid" , "Cesc" , "Henry", "Fahmid", "Cesc", "Henry","Cesc"} ;
        Integer[] marksarr = {80,50,60,90,70,80,100} ;
        solve(studentsarr,marksarr);
        
    }
}
