class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit= 0;

        int left=0;
        int right = 0;

        while(left <= right && right <prices.length){
            if(prices[right]>prices[left]){
                maxProfit = Math.max(maxProfit, prices[right]-prices[left]);
                right++;
            }else{
                left = right;
                right++;
            }
        }

        return maxProfit;
    }
}
