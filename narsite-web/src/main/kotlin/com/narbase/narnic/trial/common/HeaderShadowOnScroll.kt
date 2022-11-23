package com.narbase.narnic.trial.common

import com.narbase.kunafa.core.components.View
import kotlinx.browser.window

/*
 * NARBASE TECHNOLOGIES CONFIDENTIAL
 * ______________________________
 * [2017] -[2019] Narbase Technologies
 * All Rights Reserved.
 * Created by islam
 * On: 2022/03/03.
 */

fun headerShadowOnScroll(header: View?) {
    window.addEventListener("scroll", {
        val currentScroll = window.pageYOffset
        when {
            currentScroll <= 0.0 -> header?.element?.style?.boxShadow = "unset"
            currentScroll > 0.0 && currentScroll <= 100.0 -> header?.element?.style?.boxShadow =
                "0px 6px 8px 1px rgb(0 0 0 / ${currentScroll / 10.0}%)"
            else -> header?.element?.style?.boxShadow = "0px 6px 8px 1px rgb(0 0 0 / 10%)"
        }
    })


}
