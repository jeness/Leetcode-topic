public class Solution {
    /**
     * @param bills: the Bill
     * @return: Return true if and only if you can provide every customer with correct change.
     */
    public boolean lemonadeChange(List<Integer> bills) {
            //如果是5元，直接收下
        //如果是10元，找钱5元
        //如果是20元，优先找钱10+5的组合，再找钱5+5+5的组合，因为3个5块比较难得一些
        int five = 0, ten = 0;
        for(int i : bills){
            if(i == 5){
                five++;
            }
            else if (i == 10){
                ten++;
                five--;
            }
            else if(i == 20){
                if(ten > 0){
                    ten--;
                    five--;
                }
                else{
                    five = five - 3;
                }
            }
            if(five < 0){
                return false;
            }
        }
        return true;
    }
}