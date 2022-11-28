package com.narbase.narnic.main

import com.narbase.bos.common.data.AppColors
import com.narbase.bos.common.one.NarsitePageRef
import com.narbase.kunafa.core.components.*
import com.narbase.kunafa.core.components.layout.LinearLayout
import com.narbase.kunafa.core.css.*
import com.narbase.kunafa.core.dimensions.dependent.matchParent
import com.narbase.kunafa.core.dimensions.px
import com.narbase.kunafa.core.dimensions.vw
import com.narbase.kunafa.core.drawable.Color
import com.narbase.narnic.main.common.commonPageHead
import com.narbase.narnic.main.common.fbqTrack
import com.narbase.narnic.main.common.smoothPageScroll
import com.narbase.narnic.main.narsite.landingPageFooter
import com.narbase.narnic.main.narsite.landingPageHeader
import com.narbase.narnic.main.utils.centerVertical
import com.narbase.narnic.main.utils.horizontalFiller
import com.narbase.narnic.main.utils.smallScreen

/*
 * NARBASE TECHNOLOGIES CONFIDENTIAL
 * ______________________________
 * [2017] -[2019] Narbase Technologies
 * All Rights Reserved.
 * Created by islam
 * On: 2022/01/31.
 */
class NarsiteLandingPage {

    fun get() = page(NarsitePageRef()) { ref ->

        head {
            commonPageHead()
            smoothPageScroll()

            title {
                text = "Narbase technologies"
            }
            meta {
                attributes["content"] =
                    "Your trusted software provider!"
                attributes["name"] = "description"
            }


        }
        style {
            background = "linear-gradient(to bottom, rgba(48,48,48,1), rgba(16,16,16,1));"
        }


//        keyframes(page, "right-slow") {
//            from {
//                backgroundPosition = 0.vw.toString()
//            }
//            to {
//                backgroundPosition = 100.vw.toString()
//            }
//        }
        verticalLayout {
            style {
                width = 100.vw
                background = "linear-gradient(to bottom, rgba(48,48,48,1), rgba(16,16,16,1));"
            }

            ref.headerView = landingPageHeader()

            centerVertical {

                verticalLayout {
                    style {
                        width = matchParent
                        alignItems = Alignment.Center
                        smallScreen {
                            marginTop = 32.px
                        }
                    }

                    topSection(ref)
                }
            }

            landingPageFooter()
        }

    }

    private fun LinearLayout.topSection(ref: NarsitePageRef) {
        textView {
            style {
                marginTop = 100.px
                textAlign = TextAlign.Center
                fontSize = 18.px
                color = Color.white
                fontWeight = "300"
                opacity = 0.7
                smallScreen {
                    padding = 8.px
                    textAlign = TextAlign.Left
                }
            }
            text = "SEARCHING FOR A"
        }
        horizontalLayout {
            textView {
                style {
                    color = AppColors.narbaseRedColor
                    fontWeight = "bold"
                    fontSize = 48.px
                }
                text = "GREAT"
            }
            horizontalFiller(8.px)
            textView {
                style {
                    color = AppColors.white
                    fontSize = 48.px
                }
                text = "SOFTWARE"
            }
        }
        textView {
            style {
                textAlign = TextAlign.Center
                fontSize = 24.px
                color = Color.white
                fontWeight = "300"
                padding = 8.px
                smallScreen {
                    padding = 8.px
                    textAlign = TextAlign.Left
                }
            }
            text = "THAT TAKES YOUR BUSINESS"
        }

        imageView {
            style {
                maxWidth = 50.vw
            }
            attributes["src"] = "/public/img/top-laptop.png"
        }
        a {
            ref.getStartedButton = button {
                style {
                    backgroundColor = AppColors.narbaseRedColor
                    marginTop = 32.px
                    borderRadius = 6.px
                    paddingRight = 24.px
                    paddingLeft = 24.px
                    paddingTop = 12.px
                    paddingBottom = 12.px
                    text = "Get in touch"
                    border = "none"
                    color = AppColors.white
                    borderColor = AppColors.narbaseRedColor
                    boxShadow = "none"
                    fontSize = 16.px
                    cursor = "pointer"
                }
            }
            fbqTrack("Lead")
        }
    }

    private fun LinearLayout.topTabsView() = horizontalLayout {
        style {
            width = matchParent
        }
        imageView {
            style {
                height = 50.px
            }
            attributes["src"] = "/public/img/narbase-logo.svg"
        }
        horizontalFiller()
        textView {

        }
    }

}