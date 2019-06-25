class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int i = 0, j = s.length()-1;
        char[] ch = s.toCharArray();
        while(i < j){
            if(!set.contains(s.charAt(i))){
                i++;
                continue;
            }
            if(!set.contains(s.charAt(j))){
                j--;
                continue;
            }
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return new String(ch);
    }
}