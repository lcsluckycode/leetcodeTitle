package com.core.leetcode.dynamicpro;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        // 先获取最大的元素
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        // 转换为得分数组，并赋值能获取的分数
        int[] scopes = new int[max + 1];
        for (int num : nums) {
            scopes[num] += num;
        }
        // 此时转为打劫舍的思路
        Rob rob = new Rob();
        return rob.rob(scopes);
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 2};
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        // 6
        System.out.println(deleteAndEarn.deleteAndEarn(nums));

        int[] nums2 = {2, 2, 3, 3, 3, 4};
        // 9
        System.out.println(deleteAndEarn.deleteAndEarn(nums2));
    }
}
