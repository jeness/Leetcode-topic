class Solution {
    public int titleToNumber1(String s) {
        int ans = 0;
        for(int i = s.length()-1; i >= 0; i--){
            char c = s.charAt(i);
            int num = c - 'A'+1;
            ans = ans + num * pow(26, s.length()-1-i);
        }
        return ans;
    }
    
    private int pow(int down, int up){
        int ans = 1;
        while(up > 0){
            ans = ans * down;
            up--;
        }
        return ans;
    }
}

class Solution2 {
    public int titleToNumber(String s) {
        int ans = 0;
        for(int i = s.length()-1; i >= 0; i--){
            char c = s.charAt(i);
            int num = c - 'A'+1;
            // ans = ans + num * pow(26, s.length()-1-i);  
            ans = ans + num * (int)Math.pow(26, s.length()-1-i); //也可以用Math自带的pow,只是记得类型从double转到int
        }
        return ans;
    }
    
}