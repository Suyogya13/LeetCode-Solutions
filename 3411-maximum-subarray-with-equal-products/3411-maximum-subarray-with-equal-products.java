class Solution {
    public int maxLength(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            int gcd=nums[i];
            int lcm=nums[i];
            int pro=1;
            for(int j=i;j<n;j++){
                pro*=nums[j];
                gcd=gcd(gcd,nums[j]);
                lcm=(lcm/gcd(lcm,nums[j]))*nums[j];
                if(pro==gcd*lcm){
                    ans=Math.max(ans,j-i+1);
                }
                if(pro>gcd*lcm){
                    break;
                }
            }
        }
        return ans;
    }
    int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}