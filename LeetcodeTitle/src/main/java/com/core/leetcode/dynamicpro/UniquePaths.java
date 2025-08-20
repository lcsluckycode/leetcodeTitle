package com.core.leetcode.dynamicpro;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // dp[i][j] 表示能到达点 i，j 位置的总次数
        int[][] dp = new int[m][n];

        // 边界值 i=0 或者 j=0 的时候，路径=1
        // dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j== 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        // m = 3, n = 7
        int m = 3;
        int n = 7;
        UniquePaths uniquePaths = new UniquePaths();
        // 28
        System.out.println(uniquePaths.uniquePaths(m, n));

        // m = 3, n = 2
        int m2 = 3;
        int n2 = 2;
        // 3
        System.out.println(uniquePaths.uniquePaths(m2, n2));
    }
}
