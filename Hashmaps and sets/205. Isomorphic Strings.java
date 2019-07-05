class Solution1 {
    public boolean isIsomorphic(String s, String t) {
        //hash思想，非常灵活啊
        if(s.length() != t.length()){
            return false;
        }
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(mapS[sc[i]] != mapT[tc[i]]){
                return false;
            }
            mapS[sc[i]] = i + 1;
            mapT[tc[i]] = i + 1;
        }
        return true;
    }
}
class Solution2 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(!map.containsKey(a) && !map.containsValue(b)){
                map.put(a, b);
            }
            else {
                if(map.containsKey(a) && map.get(a) != b){
                    return false;
                }
                if(map.containsValue(b) && (map.get(a) == null || map.get(a) != b)){
                    return false;
                }
            }
        }
        return true;
    }
}