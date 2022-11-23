package com.narbase.narnic.main.one

import com.narbase.bos.common.Constants
import com.narbase.bos.common.data.AppColors
import com.narbase.bos.common.one.NarsitePageRef
import com.narbase.kunafa.core.components.*
import com.narbase.kunafa.core.components.layout.LinearLayout
import com.narbase.kunafa.core.css.*
import com.narbase.kunafa.core.dimensions.dependent.matchParent
import com.narbase.kunafa.core.dimensions.dependent.weightOf
import com.narbase.kunafa.core.dimensions.percent
import com.narbase.kunafa.core.dimensions.px
import com.narbase.kunafa.core.drawable.Color
import com.narbase.narnic.main.utils.centerVertical
import com.narbase.narnic.main.utils.smallScreen
import java.util.*

/*
 * NARBASE TECHNOLOGIES CONFIDENTIAL
 * ______________________________
 * [2017] -[2019] Narbase Technologies
 * All Rights Reserved.
 * Created by islam
 * On: 2022/01/27.
 */

fun View.landingPageFooter() {
    footer() withVerticalLayout  {
        style {
            width = matchParent
            backgroundColor = AppColors.extraLightBackground
        }
        centerVertical {

            verticalLayout {
                style {
                    width = matchParent
                    paddingTop = 16.px
                    backgroundColor = AppColors.extraLightBackground
                }

                horizontalLayout {
                    style {
                        width = matchParent
                        padding = 16.px
                        flexWrap = "wrap"
                    }

                    verticalLayout {
                        style {
                            width = weightOf(2)
                            minWidth = 240.px
                            padding = 16.px
                            smallScreen {
                                alignItems = Alignment.Center
                            }
                        }

                        imageView {
                            style {
                                width = 240.px
                                attributes["src"] = "/public/img/balsam-one.png"
                            }
                        }

                    }

                    column(
                        "Company", listOf(
                            "Narbase Technologies" to "https://narbase.com",
                            "Balsam One" to "https://balsam.narbase.com",
                            "Balsam Consultations" to "https://app.balsam.narbase.com",
                        )
                    )
                    column(
                        "Resources", listOf(
                            "Free trial" to Constants.GETTING_STARTED_LINK,
                            "Contact Us" to "mailto:info@narbase.com",
                            "Blog" to "https://narbase.com/blog-2/",
                        )
                    )
                }


                view {
                    style {
                        width = matchParent
                        height = 1.px
                        marginTop = 16.px
                        backgroundColor = AppColors.textInputBorderColor
                    }
                }
                textView {
                    text = "© ${
                        Calendar.getInstance().get(Calendar.YEAR)
                    } Narbase Technologies - Made with love by Narbase Technologies."
                    style {
                        fontSize = 14.px
                        color = AppColors.text
                        padding = 16.px
                        alignSelf = Alignment.Center
                        textAlign = TextAlign.Center
                    }
                }
            }
        }
    }
}

private fun LinearLayout.column(
    columnTitle: String,
    columnLinks: List<Pair<String, String>>
) {
    view {
        style {
            width = 0.px
            smallScreen {
                width = 100.percent
            }
        }
    }
    verticalLayout {
        style {
            width = weightOf(1)
            padding = 4.px
            smallScreen {
                alignItems = Alignment.Center
            }
        }

        h6 {
            text = columnTitle
            style {
                fontSize = 16.px
                fontWeight = "bold"
                paddingTop = 8.px
                paddingBottom = 8.px
            }
        }

        columnLinks.forEach {
            footerLink(it.first, it.second)
        }

    }

}

private fun View.footerLink(title: String, hrefLink: String) = a {
    style {
        textDecoration = "none"
    }
    href = hrefLink
    textView {
        text = title
        style {
            paddingTop = 8.px
            paddingBottom = 8.px
            fontSize = 14.px
            cursor = "pointer"
            color = Color.black
            hover {
//                backgroundColor = AppColors.extraLightBackground
                textDecoration = "underline"
            }
        }
    }
}
