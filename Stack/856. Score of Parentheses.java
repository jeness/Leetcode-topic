class Solution {
    public int scoreOfParentheses(String S) {
        char[] ch = S.toCharArray();
        Stack<Integer> st = new Stack<>(); //score at current position
        
        st.push(0);//score of the current frame
        for(int i = 0; i < S.length(); i++){
            if(ch[i] == '('){
                st.push(0);
            }
            else{
                int v = st.pop(); //depth of previous part
                int w = st.pop(); // (previous part)
                st.push(w + Math.max(v * 2, 1));
                
            }
        }
        return st.pop();
    }
}