class Solution {
    public int arrayPairSum(int[] nums) {
       Arrays.sort(nums);
        //1 2 3 4
        int sum = 0;
        for(int i = 0; i < nums.length; i += 2){
            sum += nums[i];
        }
        return sum;
    }
}