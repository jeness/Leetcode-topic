class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        //in-place, xor异或1运算，1^1 = 0, 0^1 = 1,异或1可以让0变1,1变0
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < (A[0].length + 1)/2; j++){ 
                //j < (len+1)/2 可以取到中点值，使得中点也被异或效果覆盖到
                int temp = A[i][j];
                A[i][j] = A[i][A[0].length-1-j] ^ 1;
                A[i][A[0].length-1-j] = temp ^ 1;
            }
        }
        return A;
    }
    // j = 0; j < (A[0].length + 1) / 2; j++

//0 1 2 3 4 (len+1)/2 = 3   j = 0 -> 2
//0 1 2 3 (len+1)/2 = 2 j = 0 -> 1
}