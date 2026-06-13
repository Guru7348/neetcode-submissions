class Solution {
    public int maxProfit(int[] prices) {
        int prefixSum = 0;
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            prefixSum += prices[i] - prices[i-1];
            if(prefixSum<0){
                prefixSum=0;
            }
            profit = Math.max(profit,prefixSum);
        }
        return profit;
    }
}
