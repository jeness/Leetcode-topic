class Solution {
    //字符串处理 + 递归recursion 调用
    private int i; //全局变量，所有函数共用
    public String countOfAtoms(String formula) {
        StringBuilder sb = new StringBuilder();
        i = 0;
        Map<String, Integer> counts = getAtoms(formula.toCharArray());
        for(String atom : counts.keySet()){
            sb.append(atom);
            int num = counts.get(atom);
            if(num > 1){
                sb.append("" + num);
            }
        }
        return sb.toString();
    }
    
    private Map<String, Integer> getAtoms(char[] f){
        Map<String, Integer> ans = new TreeMap<String, Integer>();
        while(i != f.length){
            if(f[i] == '('){
                i++;
                Map<String, Integer> temp = getAtoms(f); //递归调用
                int count = getCount(f);
                for(Map.Entry<String, Integer> entry : temp.entrySet()){
                    ans.put(entry.getKey(), ans.getOrDefault(entry.getKey(), 0) + entry.getValue() * count);
                }
            }
            else if(f[i] == ')'){
                i++; //跳过 ')', 返回ans
                return ans;
            }
            else{
                String name = getName(f);
                ans.put(name, ans.getOrDefault(name, 0) + getCount(f));
            }
        }
        return ans;
    }
    
    private String getName(char[] f){
        String name = ""+f[i++];
        while(i < f.length && f[i] >= 'a' && f[i] <= 'z') {
            name += f[i++];
        }
        return name;
    }
    
    private int getCount(char[] f){
        int count = 0;
        while(i < f.length && f[i] >= '0' && f[i] <= '9'){
            count = count * 10 + f[i] - '0';
            i++;
        }
        return count == 0 ? 1 : count;
    }
    
}