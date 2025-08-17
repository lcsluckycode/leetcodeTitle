package com.core.leetcode;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int size = nums.length;
        // 记录最远跳跃距离
        int maxJump = 0;
        for (int i = 0; i < size; i++) {
            // 假如后续节点无法到达，直接跳出遍历，剪枝
            if (maxJump < i) {
                break;
            }
            // 刷新最远跳跃距离
            maxJump = Math.max(nums[i] + i, maxJump);
            // 假如能抵达最后一个节点，则返回
            if (maxJump >= size - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[] jumpArrays = {2,3,1,1,4};
        System.out.println(jumpGame.canJump(jumpArrays));

        int[] jumpArrays2 = {3,2,1,0,4};
        System.out.println(jumpGame.canJump(jumpArrays2));
    }
}
