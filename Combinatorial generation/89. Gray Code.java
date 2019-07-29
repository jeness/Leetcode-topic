public class Solution {
    /**
     * @param n: a number
     * @return: Gray code
     */
// n = 0时，[0]

// n = 1时，[0,1]

// n = 2时，[00,01,11,10]

// n = 3时，[000,001,011,010,110,111,101,100]
// n 是 n-1时的数前面加0 或是 加1
    public List<Integer> grayCode(int n) {
        // write your code here
        
        if(n == 0){
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }
        
        List<Integer> result = grayCode(n - 1);
        
        int resultSize = result.size();
        int diff = 1 << (n - 1);
        for(int i = resultSize-1; i >= 0; i--){
            result.add(result.get(i) + diff);
        }
        
        return result;
    }
}

