class Solution {
    public int binaryGap(int N) {
// One pass on N in binary from right to left.
// d means the distance from the last 1 position.
// d is initial to a small enough value -32
        int res = 0;
        for(int d = -32; N > 0 ; d++, N = N / 2){
            if(N % 2 == 1){
                res = Math.max(res, d);
                d = 0;  //distance d清零，有dp的味道
            }
        }
        return res;
    }
}