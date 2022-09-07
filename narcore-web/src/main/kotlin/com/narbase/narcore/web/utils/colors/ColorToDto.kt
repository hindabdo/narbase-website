package com.narbase.narcore.web.utils.colors

import com.narbase.kunafa.core.drawable.Color

/**
 * NARBASE TECHNOLOGIES CONFIDENTIAL
 * ______________________________
 * [2017] -[2019] Narbase Technologies
 * All Rights Reserved.
 * Created by islam
 * On: 2020/03/07.
 */


fun Color.toDto(): String {
    try {
        val rowColor = toCss()
        return if (rowColor.startsWith('#')) {
            rowColor.trimStart('#')
        } else {
            val regex = """rgba\((.*),\s*(.*),\s*(.*),\s*.*\)""".toRegex()
            val results = regex.matchEntire(rowColor)
            val (r, g, b) = (results?.groupValues?.slice(1..3)
                ?: listOf("255", "255", "255"))
                .map {
                    it.toInt().toString(16)
                        .let { if (it.length == 1) "0$it" else it }
                }
            "${r}${g}${b}"
        }
    } catch (e: Throwable) {
        console.log(e)
    }
    return "33CCCC"
}
