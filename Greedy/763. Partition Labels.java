class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for(int i = 0; i < S.length(); i++){
            last[S.charAt(i) - 'a'] = i;
        }
        int right = 0;
        int left = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < S.length(); i++){
            right = Math.max(right, last[S.charAt(i) - 'a']);
            if(right == i){
                list.add(right - left + 1); //子串长度
                left = i + 1;
            }
        }
        return list;
    }
}