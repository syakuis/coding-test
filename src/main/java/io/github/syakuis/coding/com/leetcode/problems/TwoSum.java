package io.github.syakuis.coding.com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-02-07
 */
public class TwoSum {
    /**
     * 일반적인 구현 : 가장 느림
     * @param nums
     * @param target
     * @return
     */
    public int[] basic(int[] nums, int target) {
        int count = nums.length;
        for(int i = 0; i < count; i++) {
            for(int x = i + 1; x < count; x++) {
                int sum = nums[i] + nums[x];
                if (sum == target) {
                    return new int[]{i,x};
                }
            }
        }

        return null;
    }

    public int[] map(int[] nums, int target) {
        Map<Integer, Integer> store = new HashMap<>();

        int count = nums.length;
        for(int i = 0; i < count; i++) {

            if (store.containsKey(nums[i])) {
                return new int[]{store.get(nums[i]), i};
            } else {
                store.put(target - nums[i], i);
            }
        }

        return null;
    }
}
