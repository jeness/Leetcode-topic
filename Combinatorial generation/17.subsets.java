class Solution1 {
    public List<List<Integer>> subsets(int[] nums) {
        //List vs ArrayList
        // the main difference between List and ArrayList is that List is an interface while ArrayList is a class. Most importantly, ArrayList implements the List interface, which also means that ArrayList is a subtype of List interface. 
       //dfs 递归
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null){
            return result;
        }
        if(nums.length == 0){
            result.add(new ArrayList<Integer>());
            return result;
        }
        Arrays.sort(nums);
        helper(nums, 0, result, new ArrayList<Integer>());
        return result;
    }
    
    private void helper(int[] nums, int startIndex, List<List<Integer>> result, List<Integer> subset){
        result.add(new ArrayList<Integer>(subset)); //deep copy，new一个arraylist出来
        //[1]
        for(int i = startIndex; i < nums.length; i++){ //取得所有以1开头的subset, 用startIndex控制return位置
            subset.add(nums[i]); //[1,2]
            helper(nums, i+1, result, subset); //扔进result
            subset.remove(subset.size() - 1); //回溯
        }
    }
}

class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        //List vs ArrayList
        // the main difference between List and ArrayList is that List is an interface while ArrayList is a class. Most importantly, ArrayList implements the List interface, which also means that ArrayList is a subtype of List interface. 
        //bfs
        // []
        // [1]             [2]    [3]
        // [1, 2] [1, 3] [2, 3]
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums); //确定顺序
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(new ArrayList<Integer>());
        while(!q.isEmpty()){
            List<Integer> subset = q.poll(); // 当前level被poll出来，在下面的for loop中，subset每次loop都被赋初值给nextSubset
            res.add(subset);
            for(int i = 0; i < nums.length; i++){
                List<Integer> nextSubset = new ArrayList<Integer>(subset); //每一个nextSubset都被赋初值为subset的值
                if(subset.size() == 0 || nums[i] > subset.get(subset.size() - 1)){
                    nextSubset.add(nums[i]);
                    q.offer(nextSubset);
                }
            }
            
        }
        return res;
    }
}