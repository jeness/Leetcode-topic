class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        //dfs + backtracking
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        
        if(sum % k != 0){
            return false;
        }
        
        boolean[] visited = new boolean[nums.length];
        return helper(nums, k, 0, visited, sum / k, 0);
    }
    
    private boolean helper(int[] nums, int k, int start, boolean[] visited, int target, int subSum){
        if(k == 1){
            return true;
        }
        
        if(subSum == target){
            return helper(nums, k-1, 0, visited, target, 0);
        };
        
        for(int i = start; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(helper(nums, k, i + 1, visited, target, subSum + nums[i])){
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}