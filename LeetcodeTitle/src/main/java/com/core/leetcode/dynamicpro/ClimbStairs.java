package com.core.leetcode.dynamicpro;

import java.util.List;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        // dp[i] 表示抵达第i个阶梯的最大方法数量
        int[] dh = new int[n];
        dh[0] = 1;
        dh[1] = 2;
        for (int i = 2; i < n; i++) {
            dh[i] = dh[i - 2] + dh[i - 1];
        }
        return dh[n - 1];
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(5));
    }
}
