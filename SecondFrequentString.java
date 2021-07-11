package gfg;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SecondFrequentString {

    String secFrequent(String arr[], int N) {
        // your code here
        String ans = null;
        Map<String, Integer> freqMap = new LinkedHashMap<>();

        for (int i = 0; i < N; i++) {
            if (freqMap.containsKey(arr[i])) {
                freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
            } else {
                freqMap.put(arr[i], 1);
            }
        }

        Map<String, Integer> lhp = new LinkedHashMap<>();

        freqMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> lhp.put(x.getKey(), x.getValue()));

        List<String> liststr = new ArrayList<>(lhp.keySet());
        ans = liststr.get(1);

        return ans;

    }

    public static void main(String[] args) {
        
    }
}
