package io.github.syakuis.coding.com.leetcode.problems

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

/**
 * @author Seok Kyun. Choi.
 * @since 2022-06-07
 */
class TwoSumTestKt : BehaviorSpec() {
    init {
        Given("두 수의 합") {
            val nums = listOf(2, 7, 11, 15)
            val target = 9
            val expected = listOf(0, 1)

            When("브루트포스로 계산") {
                fun obtain(nums: List<Int>, target: Int): List<Int> {
                    for (i: Int in 0..nums.size) {
                        for (j: Int in 1..nums.size) {
                            if (nums[i] + nums[j] == target) {
                                return listOf(i, j)
                            }
                        }
                    }

                    return listOf()
                }

                val actual = obtain(nums, target)

                Then("0과 1을 반환한다.") {
                    0 shouldNotBe actual.size
                    2 shouldBe actual.size
                    expected shouldBe actual
                }
            }

            When("in을 이용한 탐색") {
                fun obtain(): List<Int> {
                    for (i in nums.indices) {
                        val num = target - nums[i]

                        if (nums.drop(i + 1).contains(num)) {
                            return listOf(i, nums.indexOf(num))
                        }
                    }

                    return listOf()
                }

                val actual = obtain()

                Then("0과 1을 반환한다.") {
                    0 shouldNotBe actual.size
                    2 shouldBe actual.size
                    expected shouldBe actual
                }
            }
        }
    }
}