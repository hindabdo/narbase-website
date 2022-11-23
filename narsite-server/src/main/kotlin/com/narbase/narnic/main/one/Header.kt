package com.narbase.narnic.main.one

import com.narbase.bos.common.Constants
import com.narbase.bos.common.data.AppColors
import com.narbase.bos.common.one.NarsitePageRef
import com.narbase.kunafa.core.components.*
import com.narbase.kunafa.core.css.*
import com.narbase.kunafa.core.dimensions.dependent.matchParent
import com.narbase.kunafa.core.dimensions.dependent.weightOf
import com.narbase.kunafa.core.dimensions.px
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

fun View.landingPageHeader() =
    header() withVerticalLayout {
        style {
            width = matchParent
            alignItems = Alignment.Center
            position = "sticky"
            top = 0.px
            backgroundColor = Color.white
            zIndex = 100
        }

        conferenceHeader()

        horizontalLayout {
            style {
                width = matchParent
                padding = 8.px
                alignItems = Alignment.Center
                backgroundColor = Color.white
                zIndex = 100
                flexWrap = "wrap"
            }

            horizontalLayout {
                style {
                    width = weightOf(1)
                    paddingStart = 8.px
                    smallScreen {
                        alignItems = Alignment.Center
                        justifyContent = JustifyContent.Center
                    }
                }
                a {
                    href = "/"
                    imageView {
                        style {
                            height = 56.px
                            mediumScreen {
                                height = 46.px
                            }
                            smallScreen {
                                height = 32.px
                            }
                        }
                        attributes["src"] = "/public/img/balsam-one.png"
                    }
                }
            }

            smallScreenDivider()

            nav() withHorizontalLayout {
                style {
                    smallScreen {
                        width = weightOf(1)
                        alignItems = Alignment.Center
                        justifyContent = JustifyContent.Center
                    }
                }

                horizontalFiller(8)
                a {
                    style {
                        mediumScreen {
                            display = "none"
                        }
                    }
                    button {
                        text = "GET STARTED"
                        style {
                            backgroundColor = AppColors.balsamColor
                            borderRadius = 6.px
                            paddingRight = 24.px
                            paddingLeft = 24.px
                            paddingTop = 12.px
                            paddingBottom = 12.px
                            border = "none"
                            color = AppColors.white
                            borderColor = AppColors.balsamColor
                            boxShadow = "none"
                            fontSize = 14.px
                            cursor = "pointer"
                        }
                    }
                    href = Constants.GETTING_STARTED_LINK
                }

            }
        }
    }

private fun CustomView.conferenceHeader() {
    val conferenceDate = SimpleDateFormat("dd/MM/yyyy").parse("16/12/2022")
    if (Date().after(conferenceDate)) return
    horizontalLayout {
        style {
            width = matchParent
            padding = 8.px
            alignItems = Alignment.Center
            justifyContent = JustifyContent.Center
            backgroundColor = AppColors.balsamColor
            zIndex = 100
            flexWrap = "wrap"
        }
    }
}

