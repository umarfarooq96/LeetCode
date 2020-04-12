public class BuyAndSellStocksMultipleTransactions {

    public static void main(String[] args) {
        int[] x = { 10, 12, 11, 30 };
        System.out.println(maxProfit(x));
        System.out.println(x.length);
    }

    public static int test(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += (prices[i] > prices[i - 1])
                      ? prices[i] - prices[i - 1]
                      : 0;
        }

        return profit;
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = helper(prices);
        return maxProfit;
    }

    public static int helper(int[] prices) {
        if (prices.length == 0) return 0;

        int max       = Integer.MIN_VALUE;
        int max_index = -1;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
                max_index = i;
            }
        }
        int cur_profit = 0;
        for (int j = 0; j < max_index; j++) {
            cur_profit += max - prices[j];
        }

        int[] remaining_days = new int[prices.length - (max_index + 1)];
        for (int k = max_index + 1; k < prices.length; k++) {
            remaining_days[k - (max_index + 1)] = prices[k];
        }

        return cur_profit + helper(remaining_days);
    }
}
