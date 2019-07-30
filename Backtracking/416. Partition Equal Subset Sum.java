class Solution {
    public boolean canPartition(int[] nums) {
       //dp[i][j]的定义是，使用前i个数字（不是使用i个数字）是否能够构成j，这样每个数字最多只能被使用一次。
        
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 == 1 ){
            return false;
        }
         int[] dp = new int[sum+1];  
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for(int num : nums){//滚动数组，j在外层循环
            for(int i = sum; i >= 0; i--){ //从后面开始遍历，是为了避免重复判断
                if(dp[i] == 1){
                    dp[i + num] = 1;
                }
                if(dp[sum/2] == 1) {
                    // System.out.println(sum);
                    return true;
                }
            }
        }
        return false;
    }
}