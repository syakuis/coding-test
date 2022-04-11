package io.github.syakuis.coding.com.leetcode.problems

import io.kotest.core.spec.style.BehaviorSpec

/**
 * @author Seok Kyun. Choi.
 * @since 2022-04-05
 */
class ProductOfArrayExceptSelf: BehaviorSpec({
    Given("배열을 입력받아 output[i]가 자신을 제외한 나머지 모든 요소의 곱셈 결과가 되도록 출력하라.") {
        val nums = intArrayOf(-1,1,0,-3,3)

        When("왼쪽 곱셈 결과에 오른쪽 값을 차례대로 곱셈") {

            fun solution(nums: IntArray): IntArray {
                val result = IntArray(nums.size)
                for (i in nums.indices) {
                    var s = 1
                    for (x in nums.indices) {
                        if (i == x) continue
                        s *= nums[x]
                    }
                    result[i] = s
                }

                return result
            }

            solution(nums).forEach { println(it) }
        }
    }
})