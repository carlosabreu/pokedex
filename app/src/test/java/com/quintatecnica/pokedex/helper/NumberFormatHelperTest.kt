package com.quintatecnica.pokedex.helper

import org.junit.Assert.assertEquals
import org.junit.Test

class NumberFormatHelperTest {
    @Test
    fun should_Return003_WhenCallFormatNumberWith3() {
        assertEquals("003", NumberFormatHelper().formatNumberWith3Digits(3))
    }

    @Test
    fun should_Return010_WhenCallFormatNumberWith10() {
        assertEquals("010", NumberFormatHelper().formatNumberWith3Digits(10))
    }

    @Test
    fun should_Return200_WhenCallFormatNumberWith200() {
        assertEquals("200", NumberFormatHelper().formatNumberWith3Digits(200))
    }
}