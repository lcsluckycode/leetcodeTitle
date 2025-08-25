package com.core.leetcode.dynamicpro;

/**
 * 给定一个 m x n 的整数数组 grid。一个机器人初始位于 左上角（即 grid[0][0]）。机器人尝试移动到 右下角（即 grid[m - 1][n - 1]）。
 * 机器人每次只能向下或者向右移动一步。
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。
 * <p>
 * 返回机器人能够到达右下角的不同路径数量。
 * <p>
 * 测试用例保证答案小于等于 2 * 10^9。
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // dp[i][j] 表示到达i，j位置的总路径个数
        int[][] dp = new int[m][n];
        // 初始化
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] > 0) {
                break;
            }
            dp[0][i] = 1;
        }
        for (int j = 0; j < m; j++) {
            if (obstacleGrid[j][0] > 0) {
                break;
            }
            dp[j][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] > 0) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
        int[][] map1 = {{0,0,0},{0,1,0},{0,0,0}};
        // 2
        System.out.println(uniquePathsWithObstacles.uniquePathsWithObstacles(map1));

        int[][] map2 = {{0,1},{0,0}};
        // 1
        System.out.println(uniquePathsWithObstacles.uniquePathsWithObstacles(map2));
    }
}
