class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for(int num : nums1){
            set1.add(num);
        }
        HashSet<Integer> both = new HashSet<>();
        for(int num : nums2){
            if(set1.contains(num)){
                both.add(num);
            }
        }
        int[] ans = new int[both.size()];
        int i = 0;
        for(int n : both){
            ans[i] = n;
            i++;
        }
        return ans;
    }
}