class Solution {
    public int[] twoSum(int[] nums, int target) {
        //map: target-nums[i] to index i
        //if map contains nums[i], then return i, map.get(nums[i])
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{i, map.get(nums[i])};
            }
            map.put(target-nums[i], i);
        }
        return new int[2];
    }
}