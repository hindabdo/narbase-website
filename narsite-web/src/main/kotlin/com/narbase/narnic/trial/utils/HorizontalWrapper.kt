package com.narbase.narnic.trial.utils

import com.narbase.kunafa.core.components.View
import com.narbase.kunafa.core.components.horizontalLayout
import com.narbase.kunafa.core.components.layout.LinearLayout
import com.narbase.kunafa.core.css.*
import com.narbase.kunafa.core.dimensions.LinearDimension
import com.narbase.kunafa.core.dimensions.dependent.matchParent
import com.narbase.kunafa.core.dimensions.dependent.weightOf
import com.narbase.kunafa.core.dimensions.dependent.wrapContent
import com.narbase.kunafa.core.dimensions.px

/*
 * NARBASE TECHNOLOGIES CONFIDENTIAL
 * ______________________________
 * [2017] -[2019] Narbase Technologies
 * All Rights Reserved.
 * Created by islam
 * On: 2022/01/25.
 */

const val MEDIA_WIDTH_BIG = "(min-width: 760px)"
const val MEDIA_WIDTH_SMALL = "(max-width: 760px)"
const val MEDIA_WIDTH_MEDIUM = "(max-width: 1000px)"
const val MEDIA_BIGGER_THAN_WIDTH_MEDIUM = "(min-width: 1000px)"
const val MEDIA_BIGGER_THAN_SMALL_MEDIUM = "(min-width: 760px)"
val PAGE_MAX_WIDTH = 1400.px

fun View.horizontalWrapper(block: LinearLayout.() -> Unit) =
    horizontalLayout {
        style {
            width = matchParent
            justifyContent = JustifyContent.Center
        }
        block()
    }

fun View?.centerVertical(maxWidth: LinearDimension? = null, block: LinearLayout.() -> Unit) =
    horizontalLayout {
        style {
            width = matchParent
            height = wrapContent
            justifyContent = JustifyContent.Center
        }
        horizontalLayout {
            style {
                width = weightOf(0, maxWidth ?: PAGE_MAX_WIDTH)
                flexShrink = "1"
                height = wrapContent
            }

            block()
        }
    }

