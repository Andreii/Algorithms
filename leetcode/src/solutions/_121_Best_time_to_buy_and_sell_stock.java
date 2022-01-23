package solutions;

public class _121_Best_time_to_buy_and_sell_stock {
    public int maxProfit(int[] prices) {
        int min = prices[0], max = 0;

        for(int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }
}