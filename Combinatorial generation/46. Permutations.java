class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, ans, 0, new ArrayList<Integer>(), visited);
        return ans;
    }
    
    public void backtrack(int[] nums, List<List<Integer>> ans, int pos, List<Integer> s, boolean[] visited){
        if(pos == nums.length){
            ans.add(new ArrayList<Integer> (s));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            s.add(nums[i]);
            visited[i] = true;
            backtrack(nums, ans, pos+1, s, visited);
            s.remove(s.size()-1);
            visited[i] = false;
           
        }
    }
}