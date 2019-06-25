class Solution1 {
    //iteration
    public void reverseString(char[] s) {
        if(s == null || s.length == 0) return;
        int start = 0, end = s.length-1;
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    
    }
}

class Solution2 {
    //recursive
    public void reverseString(char[] s) {
        if(s == null || s.length == 0) return;
        helper(0, s.length-1, s);
    }
    
    private void helper(int start, int end, char[] s){
        if(start < end){
            char c = s[start];
            s[start] = s[end];
            s[end] = c;
        }
        else{
            return;
        }
        helper(start+1, end-1, s);
    }
}