package io.github.syakuis.coding.com.leetcode.problems

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import kotlin.math.max
import kotlin.math.min

/**
 * @author Seok Kyun. Choi.
 * @since 2022-04-11
 */
class BestTimeToBuyAndSellStock: DescribeSpec({
    describe("주식을 사고팔기 가장 좋은 시점") {
        describe("한 번의 거래로 낼 수 있는 최대 이익을 산출하라.") {
            val nums = intArrayOf(1, 2, 3, 0, 2)

            it ("저점과 현재 값과의 차이 계산") {
                fun solution(nums: IntArray): Int {
                    var profit = 0
                    var minPrice = Int.MAX_VALUE

                    for (num in nums) {
                        minPrice = min(minPrice, num)
                        profit = max(profit, num - minPrice)
                        println("$num $minPrice $profit")
                    }

                    return profit
                }

                solution(nums) shouldBe 3
            }
        }
    }
})