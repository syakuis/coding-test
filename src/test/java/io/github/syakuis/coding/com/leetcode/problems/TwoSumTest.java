package io.github.syakuis.coding.com.leetcode.problems;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TwoSumTest {
    private final TwoSum twoSum = new TwoSum();

    private final int[] nums = new int[]{2,7,11,15};
    private final int[] nums2 = new int[]{3,2,3};

    @Order(0)
    @Test
    void init() {
    }

    @Order(1)
    @Test
    void basic() {
        assertArrayEquals(new int[]{0,1}, twoSum.basic(nums, 9));
        assertArrayEquals(new int[]{0,2}, twoSum.basic(nums2, 6));
    }

    @Order(2)
    @Test
    void map() {
        assertArrayEquals(new int[]{0,1}, twoSum.map(nums, 9));
        assertArrayEquals(new int[]{0, 2}, twoSum.map(nums2, 6));
    }
}
