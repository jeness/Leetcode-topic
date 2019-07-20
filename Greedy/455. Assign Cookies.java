class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);//children
        Arrays.sort(s);//cookies
        int i, j;
        for(i = j = 0; i < g.length && j < s.length; j++){
            if(g[i] <= s[j]){
                i++;
            }
        }
        return i;
    }
}