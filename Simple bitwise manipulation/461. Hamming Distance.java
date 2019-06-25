class Solution1 {
    public int hammingDistance(int x, int y) {
        return countOne(x ^ y);
    }
    
    private int countOne(int num){
        int count = 0;
        while(num != 0){
            num = num & (num - 1);
            count++;
        }
        return count;
    }
    
}

class Solution2 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}