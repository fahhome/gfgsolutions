package gfg;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class PairsWithGivenSum {

    public static int getPairsCount(int[] arr, int n, int k) {
        // code here
        Integer ans = 0;
        Arrays.sort(arr);

        Map<Integer,Integer>  freqMap = new LinkedHashMap<>();

        for(int i = 0 ; i < n ; i++){
            if (freqMap.containsKey(arr[i])) {
                freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
            } else {
                freqMap.put(arr[i], 1);
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(freqMap.containsKey(k-arr[i])){
                freqMap.put(arr[i], freqMap.get(arr[i]) - 1); // This element should not be used for further pairings
                ans += freqMap.get(k-arr[i]);               
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int arr[] = {1, 5, 1, 7};
        int n = 4 ;
        int k = 6;
        System.out.println(getPairsCount(arr, n, k));
        
    }
}
