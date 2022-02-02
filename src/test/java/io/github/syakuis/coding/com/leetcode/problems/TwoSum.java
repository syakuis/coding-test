package io.github.syakuis.coding.com.leetcode.problems;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int count = nums.length;
        int end = count-1;
        for(int i = 0; i < end; i++) {
            for(int x = i + 1; x < count; x++) {
                int sum = nums[i] + nums[x];
                if (sum == target) {
                    return new int[]{i,x};
                }
            }    
        }
        
        return null;
    }
}
