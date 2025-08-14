package com.core.leetcode;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */

public class TradeStocks {

    public int maxProfit(int[] prices) {
        int size = prices.length;
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < size; i++) {
            // 选出最大的利益
            max = prices[i] - min > max ? prices[i] - min : max;
            if (min > prices[i]) {
                // 刷新买入的最低点
                min = prices[i];
            }
        }
        return max;
    }

    // [7,1,5,3,6,4]
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        TradeStocks tradeStocks = new TradeStocks();
        System.out.println(tradeStocks.maxProfit(prices));
    }
}
