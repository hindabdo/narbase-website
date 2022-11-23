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
import com.narbase.narnic.main.one.landingPageFooter
import com.narbase.narnic.main.one.landingPageHeader
import com.narbase.narnic.main.utils.centerVertical
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


        keyframes(page, "right-slow") {
            from {
                backgroundPosition = 0.vw.toString()
            }
            to {
                backgroundPosition = 100.vw.toString()
            }
        }

        ref.headerView = landingPageHeader()

        centerVertical {
            verticalLayout {
                style {
                    width = matchParent
                    alignItems = Alignment.Center
                    marginTop = 72.px
                    smallScreen {
                        marginTop = 32.px
                    }
                }

                headerSection(ref)
            }
        }
        centerVertical {

        }

        landingPageFooter()

    }

    private fun LinearLayout.headerSection(ref: NarsitePageRef) {
        h1 {
            style {
                textAlign = TextAlign.Center
                fontSize = 48.px
                color = Color.black
                fontStyle = "bold"
                fontWeight = "700"
                padding = 16.px
                smallScreen {
                    padding = 24.px
                    textAlign = TextAlign.Left
                }
            }
            text = "Narbase"
        }

        textView {
            style {
                maxWidth = 620.px
                marginTop = 32.px
                fontSize = 18.px
                fontWeight = "300"
                lineHeight = "1.5"
                color = AppColors.textDarkerGrey
                textAlign = TextAlign.Center
                padding = 16.px
                smallScreen {
                    maxWidth = 100.vw
                    padding = 24.px
                    textAlign = TextAlign.Left
                    marginTop = 12.px
                }
            }
            text =
                ""
        }

        a {
            ref.getStartedButton = button {
                style {
                    backgroundColor = AppColors.balsamColor
                    marginTop = 32.px
                    borderRadius = 6.px
                    paddingRight = 24.px
                    paddingLeft = 24.px
                    paddingTop = 12.px
                    paddingBottom = 12.px
                    text = "Get in touch"
                    border = "none"
                    color = AppColors.white
                    borderColor = AppColors.balsamColor
                    boxShadow = "none"
                    fontSize = 16.px
                    cursor = "pointer"
                }
            }
            fbqTrack("Lead")
        }
    }


}