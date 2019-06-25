class Solution {
    public int[] sortArrayByParity(int[] A) {
        if(A == null || A.length == 0){
            return A;
        }
        //in-place 解法，双指针，left 是偶数，right是奇数
        int left = 0; 
        int right = A.length - 1;
        while(left < right){
            if(A[left] % 2 > A[right] % 2){ //左边是奇数，右边是偶数的话，左右交换
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }
            if(A[left] % 2 == 0) left++;
            if(A[right] % 2 == 1) right--;
        }
        return A;
    }
}