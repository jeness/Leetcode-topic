class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, result, new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> subList, int pos){
        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<Integer>(subList));
            return;
        }
        
        for(int i = pos; i < candidates.length; i++){
            subList.add(candidates[i]);
            helper(candidates, target - candidates[i], result, subList, i);
            subList.remove(subList.size() - 1);  //remove 是根据subList的index来remove
        }
        
    }
}