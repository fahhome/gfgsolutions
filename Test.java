package gfg;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// LinkedHashSet also have unique List<Integer>
public class Test {
    public static void main(String[] args) {
        // List<List<Integer>> lists = new LinkedList<>();
        // for(int i=0; i<10 ; i=i++){ // Try with preincrement then you get 5 times
        //     i += 1 ;
        //     System.out.println(i + " Hello Fahmid");
        // }

        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(9);
        list.add(5);

        Set<List<Integer>> set = new LinkedHashSet<>();
        set.add(list);
        set.add(list);
        System.out.println(set.size());

    }
}
