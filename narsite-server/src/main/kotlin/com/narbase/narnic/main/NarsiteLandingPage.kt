package com.narbase.narnic.main

import com.narbase.bos.common.data.AppColors
import com.narbase.bos.common.one.NarsitePageRef
import com.narbase.kunafa.core.components.*
import com.narbase.kunafa.core.components.layout.LinearLayout
import com.narbase.kunafa.core.css.*
import com.narbase.kunafa.core.dimensions.dependent.matchParent
import com.narbase.kunafa.core.dimensions.dependent.weightOf
import com.narbase.kunafa.core.dimensions.percent
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
import com.narbase.narnic.main.utils.verticalFiller
import javax.sound.sampled.Line

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
            width = 100.vw
        }


//        keyframes(page, "right-slow") {
//            from {
//                backgroundPosition = 0.vw.toString()
//            }
//            to {
//                backgroundPosition = 100.vw.toString()
//            }
//        }

        keyframes(page, "up_down") {
            addKeyframeRule("0%") {
                transform = "translate(0px, 0px)"
            }

            addKeyframeRule("50%") {
                transform = "translate(0px, 5px)"
            }

            addKeyframeRule("100%") {
                transform = "translate(0px, 0px)"
            }
        }
        verticalLayout {
            verticalLayout {
                style {
                    width = 100.vw
                    background = "linear-gradient(to bottom, rgba(48,48,48,1), rgba(16,16,16,1), rgba(0,0,0,1));"
                }

                ref.headerView = landingPageHeader()

                verticalLayout {
                    style {
                        width = 100.percent
                        alignItems = Alignment.Center
                        background = "linear-gradient(to bottom, rgba(48,48,48,1), rgba(16,16,16,1), rgba(0,0,0,1));"
                        smallScreen {
                            marginTop = 32.px
                        }
                    }

                    topSection(ref)
                }

                newLevelSection()
                landingPageFooter()
            }

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
                    fontWeight = "bold"
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
        verticalFiller(100.px)

        horizontalLayout {
            textView {
                style {
                    color = AppColors.white
                    fontWeight = "300"
                    fontSize = 48.px
                }
                text = "TO A WHOLE"
            }
            horizontalFiller(8.px)
            textView {
                style {
                    color = AppColors.white
                    fontSize = 48.px
                    fontWeight = "bold"
                }
                text = "NEW"
            }
            horizontalFiller(8.px)
            textView {
                style {
                    color = AppColors.white
                    fontSize = 48.px
                    fontWeight = "300"
                }
                text = "LEVEL"
            }
        }
        verticalFiller(16.px)
    }

    private fun LinearLayout.newLevelSection() = verticalLayout {

        style {
            backgroundColor = AppColors.black
            padding = 32.px
            width = 100.vw
            alignItems = Alignment.Center
            justifyContent = JustifyContent.Center
        }

        view {
            style {
                width = 1.px
                height = 200.px
                backgroundColor = AppColors.textDarkerGrey
            }
        }
        verticalFiller(32.px)
        horizontalLayout {
            leftNewLevelView()
            imageView {
                style {
                    height = 300.px
                }
                attributes["src"] = "/public/img/laptop-semi-open.jpg"
            }
            rightNewLevelView()
        }

    }

    private fun LinearLayout.rightNewLevelView() = verticalLayout {
        textWithGreyBackground("Pay as you need")
        verticalFiller(24.px)
        imageView {
            style {
                width = 48.px
                opacity = 0.4
                animation = "up_down 5s linear infinite"
            }
            attributes["src"] = "/public/img/ux-icon.png"
        }
        verticalFiller(24.px)
        textWithGreyBackground("Consultancy")
        verticalFiller(24.px)
        imageView {
            style {
                width = 48.px
                alignSelf = Alignment.End
                opacity = 0.4
                animation = "up_down 5s linear infinite"
            }
            attributes["src"] = "/public/img/terminal-icon.png"
        }
        verticalFiller(12.px)
    }


    private fun LinearLayout.leftNewLevelView() = verticalLayout {
        textWithGreyBackground("UI/UX").style { alignSelf = Alignment.End }
        verticalFiller(24.px)
        imageView {
            style {
                width = 48.px
                alignSelf = Alignment.End
                opacity = 0.4
                marginEnd = 32.px
                animation = "up_down 5s linear infinite"
            }
            attributes["src"] = "/public/img/ui-icon.png"
        }
        verticalFiller(24.px)
        textWithGreyBackground("Software Development").style {
            alignSelf = Alignment.End
            animation = "up_down 5s linear infinite"
        }
        verticalFiller(24.px)
        imageView {
            style {
                width = 48.px
                alignSelf = Alignment.End
                opacity = 0.4
                marginEnd = 32.px
                animation = "up_down 4s linear infinite"
            }
            attributes["src"] = "/public/img/code-icon.png"
        }
    }

    private fun LinearLayout.textWithGreyBackground(content: String) = textView {
        style {
            backgroundColor = AppColors.textDarkerGrey
            color = AppColors.white
            paddingLeft = 24.px
            paddingRight = 24.px
            paddingBottom = 8.px
            paddingTop = 8.px
            borderRadius = 12.px
            animation = "up_down 3s linear infinite"
        }
        text = content
    }
}