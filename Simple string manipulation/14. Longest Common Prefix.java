class Solution {
    public String longestCommonPrefix(String[] strs) {
        //双指针
        //i 循环每个string，j循环string中的字符
        //用prefix设置初值
        if(strs == null) return "";
        if(strs.length == 0) return "";

        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            int j = 0;
            while(j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)){
                j++;
            }
            if(j == 0){
                return "";
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
}