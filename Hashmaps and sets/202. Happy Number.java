class Solution {
    public boolean isHappy(int n) {
        // 快慢指针
        // if fast == slow, break, see wheather fast == slow == 1
        // if == 1, then return true;
        // if != 1, then return false;
        int fast = n;
        int slow = n;
        while(true){
            slow = findNext(slow);
            fast = findNext(fast);
            fast = findNext(fast);
            if(slow == fast){
                break;
            }
        }
        return slow == 1;
    }
    
    private int findNext(int n){
        int res = 0;
        while(n != 0){
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }
}

class Solution {
    public boolean isHappy2(int n) {
         //see n = 11, we can know number 4 repeat two times.
        // 1^2 + 1^2 = 2
        // 2^2 = 4
        // 4^2 = 16
        // 1^2 + 6^2 = 37
        // 3^2 + 7^2 = 58
        // 5^2 + 8^2 = 89
        // 8^2 + 9^2 = 145
        // 1^2 + 4^2 + 5^2 = 42
        // 4^2 + 2^2 = 20
        // 2^2 + 0^2 = 4
        //square sum result will repeat when the n is not happy number
        //so we can have a set, if set contians n, then break, then validate whether it is 1 or not,
        //if n == 1, return true;
        //if n != 1, return false;
        Set<Integer> set = new HashSet<>();

        while(n != 1){
            int sum = 0;
             while(n != 0){
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if(set.contains(sum)){
                return false;
            }
            n = sum;
            set.add(n);
        }
        return true;
       
    }
}