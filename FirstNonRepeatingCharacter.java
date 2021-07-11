package gfg;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;


//Given a string S consisting of lowercase Latin Letters. Find the first non-repeating character in S.
// Example 1:
// Input:
// S = hello
// Output: h

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        int tc ; 
        Scanner sc = new Scanner(System.in);

        tc = sc.nextInt();

        while(tc-- > 0){
            
            String s = sc.next();
            Map<Character,Integer> freqMap = new LinkedHashMap<>();
            for(int i = 0 ; i<s.length() ; i++){
                if(freqMap.containsKey(s.charAt(i))){
                    freqMap.put(s.charAt(i), freqMap.get(s.charAt(i)) + 1);
                }else{
                    freqMap.put(s.charAt(i), 1);
                }
                
            }

            for(Map.Entry<Character,Integer> entry : freqMap.entrySet()){
                if(freqMap.get(entry.getKey()) == 1){
                    System.out.println(entry.getKey());
                    break;
                }
            }

        }

    }
}
