class Solution {
    public boolean isPalindrome(String s) {
        char[] ch = s.replaceAll("[^0-9a-zA-Z]", "").trim().toLowerCase().toCharArray();
        int start = 0, end = ch.length-1;
        while(start < end){
            if(ch[start] != ch[end]){
                // System.out.println(ch[start] + " " + ch[end]);
                return false;
            }
            else{
                start++;
                end--;
            }
        }
        return true;
    }
}