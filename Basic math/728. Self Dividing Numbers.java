class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for(int i = left; i <= right; i++){
            if(isSelfDivide(i)){
                ans.add(i);
            }
        }
        // System.out.println(isSelfDivide(128));
        return ans;
    }
    
    private boolean isSelfDivide(int num){
        int copy = num;
        while(num > 0){
            // System.out.println(num);
            if(num % 10 == 0 || copy % (num % 10) != 0) { 
                //注意判断num%10 == 0的情况，会在后面出现除以0，所以先return false
                return false;
            }
            num = num / 10;
        }
        return true;
    }
}