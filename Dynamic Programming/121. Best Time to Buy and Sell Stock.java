class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int profit = 0, min = Integer.MAX_VALUE;
        for(int i : prices){
            min = Math.min(min, i);
            profit = Math.max(profit, i - min);
        }
        return profit;
    }
}