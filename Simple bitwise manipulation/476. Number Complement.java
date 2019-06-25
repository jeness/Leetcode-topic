class Solution {
    // https://zxi.mytechroad.com/blog/bit/476-number-complement/
    public int findComplement(int num) {//补码运算不是可逆的，5的补码是2， 2的补码是1
        int mask = ~0;
        while((mask & num) != 0) {
            mask = mask << 1;
        }
        return ~num^mask; //异或规律：相同元素得0， 不同元素得1
    }
}