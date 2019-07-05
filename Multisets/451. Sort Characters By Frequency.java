class Solution {
    public String frequencySort(String s) {
        // max heap, pq 相反value
        if(s == null || s.length() == 0) return s;
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        char[] ch = s.toCharArray();
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < ch.length; i++){
            if(map.containsKey(ch[i])){
                map.put(ch[i], map.get(ch[i]) + 1);
            }
            else{
                map.put(ch[i], 1);
            }
        }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.offer(entry);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> entry = pq.poll();
            int times = entry.getValue();
            while(times != 0){
                 sb.append(entry.getKey());
                 times--;
            }
           
        }
        return sb.toString();
    }
}