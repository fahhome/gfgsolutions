package gfg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


//Input:
//S=pqr.mno Output:mno.pqr


// Notice in the solution that how Reversing the list actually reverses the array 
public class ReverseWordsOfString {

    public static void main(String[] args) {

        int tc ; 
        Scanner sc = new Scanner(System.in);

        tc = sc.nextInt();

        while(tc-- > 0){

            String s = sc.next();
            String splitarr[] = s.split("\\.");
            Collections.reverse(Arrays.asList(splitarr));
            
            for(int i = 0 ; i<splitarr.length ; i++){
                if(i == 0){
                    System.out.print(splitarr[i]);
                }else{
                    System.out.print("."+ splitarr[i]);
                }
            }
            

        }
        
    }
}
