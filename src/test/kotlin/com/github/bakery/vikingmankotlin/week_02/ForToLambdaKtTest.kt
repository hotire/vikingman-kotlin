package com.github.bakery.vikingmankotlin.week_02

import com.github.bakery.vikingmankotlin.week_02.answer.lambda2
import org.junit.jupiter.api.Test

internal class ForToLambdaKtTest {

    @Test
    fun forloop() {
        val s = forloop(listOf("abc", "c"))
        val s2 = lambda2(listOf("abc", "c"))
        println(s)
        println(s2)
    }
}