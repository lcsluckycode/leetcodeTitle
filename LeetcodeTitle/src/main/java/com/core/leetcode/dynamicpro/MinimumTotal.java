package com.core.leetcode.dynamicpro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size <= 0) {
            return 0;
        }

        // dp[i][j] 表示抵达当前位置的最小路径和
        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                int num = triangle.get(i).get(j);
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + num;
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][i - 1] + num;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + num, dp[i - 1][j - 1] + num);
                }
            }
        }
        int min = dp[size - 1][0];
        for (int k = 1; k < size; k++) {
            min = Math.min(dp[size - 1][k], min);
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumTotal minimumTotal = new MinimumTotal();
        List<List<Integer>> triangle1 = new ArrayList<>();
        // triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
        triangle1.add(Arrays.asList(2));
        triangle1.add(Arrays.asList(3, 4));
        triangle1.add(Arrays.asList(6, 5, 7));
        triangle1.add(Arrays.asList(4, 1, 8, 3));
        // 11
        System.out.println(minimumTotal.minimumTotal(triangle1));

        // -10
        List<List<Integer>> triangle2 = new ArrayList<>();
        triangle2.add(Arrays.asList(-10));
        System.out.println(minimumTotal.minimumTotal(triangle2));

        // [[-7],[-2,1],[-5,-5,9],[-4,-5,4,4],[-6,-6,2,-1,-5],[3,7,8,-3,7,-9],[-9,-1,-9,6,9,0,7],[-7,0,-6,-8,7,1,-4,9],[-3,2,-6,-9,-7,-6,-9,4,0]
        // ,[-8,-6,-3,-9,-2,-6,7,-5,0,7],[-9,-1,-2,4,-2,4,4,-1,2,-5,5],[1,1,-6,1,-2,-4,4,-2,6,-6,0,6],[-3,-3,-6,-2,-6,-2,7,-9,-5,-7,-5,5,1]]
        List<List<Integer>> triangle3 = new ArrayList<>();
        triangle3.add(Arrays.asList(-7));
        triangle3.add(Arrays.asList(-2,1));
        triangle3.add(Arrays.asList(-5,-5,9));
        triangle3.add(Arrays.asList(-4,-5,4,4));
        triangle3.add(Arrays.asList(-6,-6,2,-1,-5));
        triangle3.add(Arrays.asList(3,7,8,-3,7,-9));
        triangle3.add(Arrays.asList(-9,-1,-9,6,9,0,7));
        triangle3.add(Arrays.asList(-7,0,-6,-8,7,1,-4,9));
        triangle3.add(Arrays.asList(-3,2,-6,-9,-7,-6,-9,4,0));
        triangle3.add(Arrays.asList(-8,-6,-3,-9,-2,-6,7,-5,0,7));
        triangle3.add(Arrays.asList(-9,-1,-2,4,-2,4,4,-1,2,-5,5));
        triangle3.add(Arrays.asList(1,1,-6,1,-2,-4,4,-2,6,-6,0,6));
        triangle3.add(Arrays.asList(-3,-3,-6,-2,-6,-2,7,-9,-5,-7,-5,5,1));
        System.out.println(minimumTotal.minimumTotal(triangle3
        ));
    }
}
