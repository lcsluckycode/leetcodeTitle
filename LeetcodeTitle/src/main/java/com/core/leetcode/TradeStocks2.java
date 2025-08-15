package com.core.leetcode;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 */

public class TradeStocks2 {

    public int maxProfit(int[] prices) {
        int size = prices.length;
        int start = prices[0];
        int sum = 0;
        int max = 0;
        for (int i = 1; i < size; i++) {
            // 当卖出的价格比历史价格高的时候，则持续持有股票
            if (prices[i] - start > max) {
                max = prices[i] - start;
            }else {
                // 当卖出的价格比前一天的价格，则卖出股票，并再当天买入股票，并将股票收益置为0
                start = prices[i];
                sum += max;
                max = 0;
            }
        }
        return sum + max;
    }

    // [7,1,5,3,6,4]
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        TradeStocks2 tradeStocks = new TradeStocks2();
        // 7
        System.out.println(tradeStocks.maxProfit(prices));

        int[] prices2 = {1,2,3,4,5};
        // 4
        System.out.println(tradeStocks.maxProfit(prices2));
    }
}
