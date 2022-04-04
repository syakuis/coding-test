package io.github.syakuis.coding.com.leetcode.problems

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

/**
 * @author Seok Kyun. Choi.
 * @since 2022-04-04
 */

class ArrayPartitionOne: BehaviorSpec({
    Given("[배열파티션I] n개의 페어를 이용한 min(a, b)의 합으로 만들 수 있는 가장 큰 수를 출력하라.") {
        val nums = intArrayOf(1, 4, 3, 2)
        When("오름차순 풀이") {
            fun arrayPartitionOne(nums: IntArray): Int {
                if (nums.isEmpty() || nums.size < 2) {
                    return 0
                }

                var sum = 0
                nums.sort()

                val pair = mutableListOf<Int>();

                for (item in nums) {
                    pair.add(item)

                    if (pair.size == 2) {
                        sum += pair.minOf { it }
                        pair.clear()
                    }
                }

                return sum
            }

            arrayPartitionOne(nums) shouldBe 4
        }

        When("짝수 번째 값 계산") {
            fun arrayPartitionOne(nums: IntArray): Int {
                if (nums.isEmpty() || nums.size < 2) {
                    return 0
                }

                nums.sort()
                var sum = 0
                for (i in nums.indices) {
                    if (i % 2 == 0) {
                        sum += nums[i]
                    }
                }

                return sum
            }

            arrayPartitionOne(nums) shouldBe 4
        }
    }
})