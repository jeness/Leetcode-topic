class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //看见top k 就要想min heap，最小在pq顶端，最大在pq尾部
        Map<Integer, Integer> map = new HashMap<>(); // <num, count>
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k){
                pq.poll(); // 如果size大于k， 把最小的poll出来
            }
            
        }
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll().getKey());
        }
        return res;
    }
}