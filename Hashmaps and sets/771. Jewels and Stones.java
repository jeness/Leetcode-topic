class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> set = new HashSet<>();
        for(char c : J.toCharArray()){
            set.add(c);
        }
        int count = 0;
        for(int i = 0; i < S.length(); i++){
            if(set.contains(S.charAt(i))){
                count++;
            }
        }
        return count;
    }
}