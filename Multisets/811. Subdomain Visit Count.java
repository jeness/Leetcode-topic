class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : cpdomains){
            String[] str = s.split("\\s+");
            int count = Integer.parseInt(str[0]);
            String[] domains = str[1].split("\\.");
            String cur = "";
            for(int i = domains.length - 1; i >= 0; --i){
                cur = domains[i] + (i < domains.length - 1 ? "." : "") + cur;  //important!!!
                map.put(cur, map.getOrDefault(cur, 0) + count);
            }
        }
        
        for(String key : map.keySet()){
            ans.add(new String(map.get(key) + " " + key));
        }
        return ans;
    }
}