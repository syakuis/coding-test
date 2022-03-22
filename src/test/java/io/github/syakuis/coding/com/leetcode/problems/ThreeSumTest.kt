package io.github.syakuis.coding.com.leetcode.problems

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe

/**
 * @author Seok Kyun. Choi.
 * @since 2022-03-22
 */
internal class ThreeSumTest: BehaviorSpec() {
    init {
        Given("배열을 입력받아 합으로 0을 만들 수 있는 3개의 엘리먼트를 출력하라") {
            val nums: IntArray = intArrayOf(-1, 0, 1, 2, -1, -4)
            val expected: List<List<Int>> = listOf(listOf(-1, 0, 1), listOf(-1, -1, 2))

            When("브루트 포스로 계산") {
                fun threeSum(nums: IntArray): List<List<Int>> {
                    if (nums.isEmpty()) {
                        return listOf()
                    }

                    if (nums.size < 3) {
                        return listOf()
                    }

                    nums.sort()
                    val result = mutableListOf<MutableList<Int>>()

                    fun duplicated(current: Int, next: Int): Boolean = current > next && nums[current] == nums[current - 1]

                    for (i in 0 until nums.size - 2) {
                        if (duplicated(i, 0)) continue
                        for (j in i + 1 until nums.size - 1) {
                            if (duplicated(j, i + 1)) continue
                            for (k in j + 1 until nums.size) {
                                if (duplicated(k, j + 1)) continue

                                if (nums[i] + nums[j] + nums[k] == 0) {
                                    result.add(mutableListOf(nums[i], nums[j], nums[k]))
                                }
                            }
                        }
                    }

                    return result
                }

                threeSum(nums) shouldContainAll expected
                threeSum(intArrayOf(0,0,0,0)) shouldBe listOf(listOf(0,0,0))
                threeSum(intArrayOf(0,0,0)) shouldBe listOf(listOf(0,0,0))
                threeSum(intArrayOf(0)) shouldBe listOf()
            }
        }
    }
}