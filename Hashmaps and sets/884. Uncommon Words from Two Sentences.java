class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        String[] Aarr = A.split(" ");
        String[] Barr = B.split(" ");
        for(String s : Aarr){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for(String s : Barr){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for(String str : map.keySet()){
            if(map.get(str) == 1){
                ans.add(str);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}