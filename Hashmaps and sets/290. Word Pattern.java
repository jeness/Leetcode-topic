class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if(pattern.length() != arr.length){
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        char[] ch = pattern.toCharArray();
        for(int i = 0; i < pattern.length(); i++){
            if(map.containsKey(ch[i])){
                if(!map.get(ch[i]).equals(arr[i])){
                    // System.out.println(i+"hihi");
                    return false;
                }
            }
            else{
                if(map.containsValue(arr[i])){
                    return false;
                }
                map.put(ch[i], arr[i]);
            }
        }
        // System.out.println("hihihihi");
        return true;
    }
}