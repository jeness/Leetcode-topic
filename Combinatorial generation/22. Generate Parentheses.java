class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans, 0, 0, n, new String());
        return ans;
    }
    
    private void helper(List<String> ans, int open, int close, int max, String str){
        if(str.length() == max * 2){
            ans.add(str);
            // return;
        }
        if(open < max){
            helper(ans, open + 1, close, max, str + "(");
        }
        if(close < open){
            helper(ans, open, close + 1, max, str + ")");
        }
    }
}