class Solution {
    public int peakIndexInMountainArray(int[] A) {
        if(A == null || A.length < 3) return -1;
        int start = 0, end = A.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(A[mid - 1] < A[mid] && A[mid] > A[mid + 1]){
                return mid;
            }
            else if (A[mid - 1] < A[mid]){ // A[mid - 1] < A[mid]&& A[mid] <= A[mid + 1], mid处于上升趋势
                start = mid; //start更新，往后看
            }
            else{ //A[mid - 1] >= A[mid] && A[mid] > A[mid + 1]，mid处于下降趋势
                end = mid; //end 更新，往前看
            }
         }
        if(A[start] > A[end]){
            return start;
        }
        else{
            return end;
        }
    }
}