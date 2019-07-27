class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, 1, n, k, new ArrayList<Integer>());
        return res;
    }
    
    private void helper(List<List<Integer>> res, int start, int n, int k, List<Integer> s){
        if(s.size() == k){
            res.add(new ArrayList<Integer>(s));
            return;
        }
        for(int i = start; i <= n; i++){ //从start开始，为了去掉重复的k元组
            s.add(i);
            helper(res, i + 1, n, k, s);
            s.remove(s.size() - 1);
        }
    }
}