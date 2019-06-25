class Solution {
    public int singleNumber(int[] nums) {
        //异或：相同得0，不同得1
        //相同的元素被bit multiplation 抵消，那么没抵消的就是那个出现1次的元素
        int a = 0;
        for(int num : nums){
            a = a ^ num;
        }
        return a;
    }
}