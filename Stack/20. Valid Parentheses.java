class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> st = new Stack<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        //if(map.containsKey(c)) st.push(c);
        //!st.isEmpty() && map.get(st.peek()) == null => return false; 
        // !st.isEmpty() && map.get(st.peek()) == c => st.pop();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){ //过滤掉其他字符（数字或者字母）
                st.push(c);
            }
            else if(map.containsValue(c)){ //过滤掉其他字符（数字或者字母）
                 if(!st.isEmpty() && map.get(st.peek()) == c){
                    st.pop();
                }
                else{
                    return false;
                }
            } 
               
            
        }
        return st.isEmpty();
    }
}