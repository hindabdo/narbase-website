package com.narbase.narnic.main.utils

import com.narbase.kunafa.core.components.View
import com.narbase.kunafa.core.components.layout.LinearLayout
import com.narbase.kunafa.core.components.view
import com.narbase.kunafa.core.css.RuleSet
import com.narbase.kunafa.core.css.media
import com.narbase.kunafa.core.css.width
import com.narbase.kunafa.core.dimensions.percent
import com.narbase.kunafa.core.dimensions.px

/*
 * NARBASE TECHNOLOGIES CONFIDENTIAL
 * ______________________________
 * [2017] -[2019] Narbase Technologies
 * All Rights Reserved.
 * Created by islam
 * On: 2022/01/25.
 */

fun RuleSet.smallScreen(rules: RuleSet.() -> Unit) {
    media(MEDIA_WIDTH_SMALL, rules)
}

fun RuleSet.bigScreen(rules: RuleSet.() -> Unit) {
    media(MEDIA_WIDTH_BIG, rules)
}

fun RuleSet.mediumScreen(rules: RuleSet.() -> Unit) {
    media(MEDIA_WIDTH_MEDIUM, rules)
}

fun RuleSet.biggerThanMediumScreen(rules: RuleSet.() -> Unit) {
    media(MEDIA_BIGGER_THAN_WIDTH_MEDIUM, rules)
}

fun RuleSet.biggerThanSmallScreen(rules: RuleSet.() -> Unit) {
    media(MEDIA_BIGGER_THAN_SMALL_MEDIUM, rules)
}


fun View.smallScreenDivider() {
    view {
        style {
            width = 0.px
            smallScreen {
                width = 100.percent
            }
        }
    }
}
fun View.mediumScreenDivider() {
    view {
        style {
            width = 0.px
            mediumScreen {
                width = 100.percent
            }
        }
    }
}
