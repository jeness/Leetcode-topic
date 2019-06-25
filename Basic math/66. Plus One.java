class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length == 0) return digits;
        for(int i = digits.length-1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length+1]; // digits进位到头了，要加一位出来
        res[0] = 1;
        return res;
    }
}