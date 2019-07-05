class Solution {
    //in-place原地解法
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for(int num : nums){
            if(nums[Math.abs(num) - 1] < 0){
                res[0] = Math.abs(num);
            }
            else{
                nums[Math.abs(num) - 1] = nums[Math.abs(num) - 1] * (-1);
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                res[1] = i + 1;
            }
        }
        return res;
    }
}