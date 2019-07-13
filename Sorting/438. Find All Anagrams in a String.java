class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //sliding window, 时间复杂度：O(n * 256),深入理解sliding window，right先扩大到windown size，left再和right同步增大，同步滑动
        List<Integer> ans = new ArrayList<>();
        int left = 0, right = 0;
        int[] map = new int[256];
        for(char c : p.toCharArray()){
            map[c]++;
        }
        int count = p.length(); //window中不在p中的字母数量，如果count == 0, 说明找到了target string
        char[] sc = s.toCharArray();
        while(right < s.length()){
            if(map[sc[right++]]-- >= 1){
                count--;
            }
            if(count == 0){
                ans.add(left);
            }
            if(right - left == p.length() && map[sc[left++]]++ >= 0){
                count++;
            }
        }
        return ans;
        
    }
}