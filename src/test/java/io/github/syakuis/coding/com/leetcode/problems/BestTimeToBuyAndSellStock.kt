package io.github.syakuis.coding.com.leetcode.problems

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

/**
 * @author Seok Kyun. Choi.
 * @since 2022-04-11
 */
class BestTimeToBuyAndSellStock: DescribeSpec({
    describe("주식을 사고팔기 가장 좋은 시점") {
        describe("한 번의 거래로 낼 수 있는 최대 이익을 산출하라.") {
            val nums = intArrayOf(7, 1, 5, 3, 6, 4)

            it ("저점과 현재 값과의 차이 계산") {
                fun solution(nums: IntArray): Int {
                    var profit = 0
                    var minPrice = Int.MAX_VALUE

                    for (num in nums) {
                        minPrice = minOf(minPrice, num)
                        profit = maxOf(profit, num - minPrice)
                    }

                    return profit
                }

                solution(nums) shouldBe 5
            }
        }
    }
})