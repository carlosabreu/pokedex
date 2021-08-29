package com.quintatecnica.pokedex.helper

class NumberFormatHelper {

    fun formatNumberWith3Digits(value: Int): String {
        return value.toString().padStart(3, '0')
    }
}