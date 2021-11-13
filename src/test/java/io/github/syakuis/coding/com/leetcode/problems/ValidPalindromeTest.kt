package io.github.syakuis.coding.com.leetcode.problems

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import mu.KotlinLogging

/**
 * @author Seok Kyun. Choi.
 * @since 2021-11-13
 */
private val log = KotlinLogging.logger {}

internal class ValidPalindromeTest: BehaviorSpec() {

    init {
        Given("[유효한 팰린드롬] 주어진 문자열이 팰린드롬인지 확인하라. 대소문를 구분하지 않으며 영문자와 숫자만을 대상으로 한다.") {
            val text = "A man, a plan, a canal: Panama"
            When("pure coding") {
                fun isValidPalindrome(): Boolean {
                    val pureText = text.replace("[^a-zA-Z0-9]".toRegex(), "").lowercase()
                    log.debug { pureText }
                    val len = pureText.length

                    for (i in 0 until len) {
                        val now = pureText[i]
                        val last = pureText[len - (i + 1)]
                        log.debug { "$now == $last" }
                        if (now != last) {
                            return false
                        }
                    }

                    return true
                }

                isValidPalindrome() shouldBe true
            }
        }
    }
}