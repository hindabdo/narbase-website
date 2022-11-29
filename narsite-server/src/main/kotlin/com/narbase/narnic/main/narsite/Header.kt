package com.narbase.narnic.main.narsite

import com.narbase.bos.common.Constants
import com.narbase.bos.common.data.AppColors
import com.narbase.kunafa.core.components.*
import com.narbase.kunafa.core.css.*
import com.narbase.kunafa.core.dimensions.dependent.matchParent
import com.narbase.kunafa.core.dimensions.dependent.weightOf
import com.narbase.kunafa.core.dimensions.px
import com.narbase.kunafa.core.dimensions.vw
import com.narbase.kunafa.core.drawable.Color
import com.narbase.narnic.main.utils.horizontalFiller
import com.narbase.narnic.main.utils.mediumScreen
import com.narbase.narnic.main.utils.smallScreen
import com.narbase.narnic.main.utils.smallScreenDivider
import java.text.SimpleDateFormat
import java.util.*

/*
 * NARBASE TECHNOLOGIES CONFIDENTIAL
 * ______________________________
 * [2017] -[2019] Narbase Technologies
 * All Rights Reserved.
 * Created by islam
 * On: 2022/01/27.
 */

fun View.landingPageHeader() = horizontalLayout {
        style {
            width = 100.vw
            padding = 12.px
            backgroundColor = Color(48,48,48, 0.2)
            alignItems = Alignment.Center
            position = "sticky"
            top = 0.px
            zIndex = 100
        }

        horizontalLayout {
            style {
                width = weightOf(1)
                smallScreen {
                    alignItems = Alignment.Center
                    justifyContent = JustifyContent.Center
                }
            }
            a {
                href = "/"
                imageView {
                    style {
                        height = 32.px
                        mediumScreen {
                            height = 46.px
                        }
                        smallScreen {
                            height = 32.px
                        }
                    }
                    attributes["src"] = "/public/img/narbase-logo.svg"
                }
            }
        }

        smallScreenDivider()

        nav() withHorizontalLayout {
            style {
                alignItems = Alignment.Center
                smallScreen {
                    width = weightOf(1)
                    alignItems = Alignment.Center
                    justifyContent = JustifyContent.Center
                }
            }

            menuLink("Home", "")
            menuLink("Portfolio", "")
            menuLink("Blog", "")
            horizontalFiller(8)
            a {
                style {
                    mediumScreen {
                        display = "none"
                    }
                }
                button {
                    text = "Get in touch"
                    style {
                        backgroundColor = AppColors.narbaseRedColor
                        borderRadius = 6.px
                        paddingRight = 12.px
                        paddingLeft = 12.px
                        paddingTop = 4.px
                        paddingBottom = 4.px
                        border = "none"
                        color = AppColors.white
                        borderColor = AppColors.narnicDarkColor
                        boxShadow = "none"
                        fontSize = 14.px
                        cursor = "pointer"
                    }
                }
//                    href = Constants.GETTING_STARTED_LINK
            }

        }
    }


fun View.menuLink(title: String, hrefLink: String) = a {
    style {
        textDecoration = "none"
    }
    href = hrefLink
    textView {
        text = title
        style {
            padding = 12.px
            fontSize = 14.px
            cursor = "pointer"
            color = Color.white
            hover {
//                backgroundColor = AppColors.extraLightBackground
                textDecoration = "underline"
            }
        }
    }
}
