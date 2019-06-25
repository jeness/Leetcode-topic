class Solution {
    public boolean detectCapitalUse(String word) {
        if(word == null || word.length() == 0 || word.length() == 1) return true;
        if(word.charAt(0) >= 'a' && word.charAt(0) <= 'z'){ 
            //leetcode, non-cap, case 2
            for(int i = 1; i < word.length(); i++){
                if(!(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')){
                    return false;
                }
            }
        }
        else if (word.charAt(1) >= 'A' && word.charAt(1) <= 'Z'){
            if(word.length() == 2) return true; // len = 2, both are cap
            // if(word.charAt(2) >= 'A' && word.charAt(2) <= 'Z'){ // word[2] is cap too
                for(int i = 2; i < word.length(); i++){
                    if(!(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')){  
                        //make all cap return true
                        return false;
                    }
                }
            // }
        }
        else if (word.charAt(1) >= 'a' && word.charAt(1) <= 'z') {
            //用来排除FlaG和确保Leetcode正确，word[0] = 大写， word[1] = 小写
            for(int i = 2; i < word.length(); i++){
                if(!(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')){
                    return false;
                }
            }
        }
        return true;
    }
}