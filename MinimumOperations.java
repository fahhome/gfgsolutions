package gfg;

// Given a number N.Find the minimum number of operations required to reach N starting from 0. You have 2 operations available:

// Double the number Add one to the number

// Example 1:

// Input:N=8 Output:4 Explanation:0+1=1,1+1=2,2*2=4,4*2=8

public class MinimumOperations {

    public static void solve(int n){
        int dp[] = new int[1000001];

        dp[0] = 0 ;
        dp[1] = 1 ;

        for(int i = 2 ; i <=n ; i++){
            if(i%2 == 0){
                dp[i] = Math.min(1 + dp[i-1], 1 + dp[i/2]);
            }else{
                dp[i] = 1 + dp[i-1];
            }

        }

        System.out.println(dp[n]);

    }
    public static void main(String[] args) {
        solve(7);
    }
}
