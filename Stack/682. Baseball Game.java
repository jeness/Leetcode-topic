class Solution {
    public int calPoints(String[] ops) {
        //因为要look back，所以用stack
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < ops.length; i++){
            String cur = ops[i];
            int intCur = 0;
            if(cur.equals("+")){
                int one = st.pop();
                int two = st.pop();
                st.push(two);
                st.push(one);
                intCur = one + two;
                st.push(intCur);
            }
            else if (cur.equals("C")){
                st.pop();
            }
            else if(cur.equals("D")){ // get the last valid score
                int validScore = st.peek();
                intCur = validScore * 2;
                st.push(intCur);
            }
            else{
                intCur = Integer.parseInt(cur);
                st.push(intCur);
            }
        }
        while(!st.isEmpty()){
            int item = st.pop();
            // System.out.println(item);
            ans += item;
        }
        return ans;
    }
}