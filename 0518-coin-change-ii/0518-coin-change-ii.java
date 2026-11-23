class Solution {
    public int change(int amount, int[] coins) {
     int[][] dp=new int[coins.length][amount + 1];
        int ans=solve(amount,coins,dp);
        return ans;
    }
    int solve(int amount,int[] coins,int[][] dp) {
        for(int i=0;i<coins.length;i++){
            dp[i][0]=1;
        }
        for(int j=1;j<=amount;j++){
            if(j%coins[0]==0) {
                dp[0][j]=1;
            } 
            else{
                dp[0][j]=0;
            }
        }
        for(int i=1;i<coins.length;i++){
            for(int j=1;j<=amount;j++){
                int skip=dp[i-1][j];
                int take=0;
                if(coins[i]<=j&& dp[i][j-coins[i]]!=0){
                    take=dp[i][j-coins[i]];
                }
                dp[i][j]=take+skip;
            }
        }
        return dp[coins.length-1][amount];
    }
}