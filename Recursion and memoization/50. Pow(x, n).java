class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        if(n == -1){
            return 1/x;
        }
        
        double half_pow = myPow(x, n / 2);
        if(n % 2 == 0){
            return half_pow * half_pow;
        }
        else{
            if(n > 0){
                return x * half_pow * half_pow;
            }
            else{
                return 1 / x * half_pow * half_pow;
            }
        }
    }
}