class Solution1 {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] p = paragraph.toLowerCase().split("[ !?',;.]+");
        HashMap<String,Integer> map = new HashMap<>();
        for(String s : p){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        HashSet<String> set = new HashSet<>();
        for(String b : banned){
            set.add(b);
        }
        
        String res = new String();
        for(String s : map.keySet()){
            if(res.length() == 0 || map.get(res) < map.get(s)){
                if(!set.contains(s)){
                    res = s;
                }
            }
        }
        return res;
    }
}

class Solution2 {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] p = paragraph.toLowerCase().split("[ !?',;.]+");
        HashMap<String,Integer> map = new HashMap<>();
        for(String word:p){
            // System.out.println(word);
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for(String ban: banned) {
            if(map.containsKey(ban)) {
                map.remove(ban);
            }
        }
        String res= null;
        for(String word: map.keySet()){
            if(res==null||map.get(word)>map.get(res)){
                res = word;
            }
        }
        return res;
        
    }
}