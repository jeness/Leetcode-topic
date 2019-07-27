class Solution {
    
    //因为nums1是nums2的subset，所以用map存储在nums2中的数的next_greater_number<num2, next_greater_num>
    //用单调栈stack去求next_greater_num
    
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] res = new int[nums1.length];
        if(nums1 == null || nums1.length == 0) {
            return res;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>(); // <nums2, next_greater_num>
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < nums2.length; i++){
            while(!st.isEmpty() && st.peek() < nums2[i]){
                map.put(st.pop(), nums2[i]); // st.pop() important！！！
            }
            st.push(nums2[i]);
        }
        
        
        for(int i = 0; i < res.length; i++){
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
    
    
}