package com.quintatecnica.pokedex.helper

import org.junit.Assert
import org.junit.Test

class NumberFormatHelperTest {
    @Test
    fun should_Return003_WhenCallFormatNumberWith3() {
        Assert.assertEquals("003", NumberFormatHelper().formatNumberWith3Digits(3))
    }

    @Test
    fun should_Return010_WhenCallFormatNumberWith10() {
        Assert.assertEquals("010", NumberFormatHelper().formatNumberWith3Digits(10))
    }

    @Test
    fun should_Return200_WhenCallFormatNumberWith200() {
        Assert.assertEquals("200", NumberFormatHelper().formatNumberWith3Digits(200))
    }
}