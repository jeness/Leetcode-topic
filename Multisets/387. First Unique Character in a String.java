class Solution {
    public int firstUniqChar(String s) {
        // time complexity: O(2N), N = s.length()
        char[] ch = s.toCharArray();
        int[] dict = new int[26]; // space complexity : 26, O(26)
        for(int i = 0; i < ch.length; i++){
            dict[ch[i] - 'a']++;
        }
        
        for(int i = 0; i < ch.length; i++){
            if(dict[ch[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}