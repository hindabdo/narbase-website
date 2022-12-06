package com.narbase.narnic.main

import com.narbase.bos.common.data.AppColors
import com.narbase.bos.common.one.NarsitePageRef
import com.narbase.kunafa.core.components.*
import com.narbase.kunafa.core.components.layout.LinearLayout
import com.narbase.kunafa.core.css.*
import com.narbase.kunafa.core.dimensions.dependent.matchParent
import com.narbase.kunafa.core.dimensions.dependent.weightOf
import com.narbase.kunafa.core.dimensions.dependent.wrapContent
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
                verticalLayout {
                    style {
                        width = matchParent
                        backgroundColor = AppColors.narbaseGreyColor
                    }
                    aboutSection()
                    verticalFiller(200.px)
                    whatWeDoView()
                }
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

    private fun LinearLayout.aboutSection() = verticalLayout {
        style {
            width = matchParent
            backgroundColor = AppColors.narbaseGreyColor
            alignItems = Alignment.Center
            justifyContent = JustifyContent.Center
            padding = 32.px
        }
        horizontalLayout {
            style {
                width = wrapContent
                alignSelf = Alignment.Center
                borderRadius = 8.px
                margin = 32.px
                padding = 24.px
                background = "linear-gradient(to bottom, #4C4B4B, #453D3F);"
            }
            imageView {
                style {
                    width = 100.px
                    height = 100.px
                    alignSelf = Alignment.Center
                    marginStart = (-50).px
                    border = "5px solid #4C4B4B"
                    borderRadius = 5.px
                }
                attributes["src"] = "/public/img/islam.jpg"
            }

            verticalLayout {
                style {
                    marginStart = 24.px
                }
                textView {
                    style {
                        maxWidth = 40.vw
                        color = AppColors.white
                        fontWeight = "300"
                    }
                    text =
                        "\"Driven by a deep understanding of hardware and a passion for clean code, our expert team is fully capable of building fast, reliable and responsive software that will help grow your business and stay in contol of your brand.\""
                }
                verticalFiller(32.px)
                textView {
                    style {
                        fontSize = 14.px
                        color = AppColors.white
                        fontWeight = "bold"
                    }
                    text = "Islam Abdalla, Managing Partner"
                }

                verticalFiller(16.px)
                imageView {
                    style {
                        height = 24.px
                    }
                    attributes["src"] = "/public/img/narbase-logo.svg"
                }
            }
        }
        clientsView()
    }

    private fun View.clientsView() = horizontalLayout {
        style {
            backgroundColor = AppColors.narbaseGreyColor
            alignSelf = Alignment.Center
            opacity = 0.5
        }
        imageView {
            style {
                height = 64.px
            }
            attributes["src"] = "/public/img/mtin.png"
        }
        horizontalFiller(24.px)
        imageView {
            style {
                height = 64.px
            }
            attributes["src"] = "/public/img/orooma.png"
        }
        horizontalFiller(24.px)
        imageView {
            style {
                height = 64.px
            }
            attributes["src"] = "/public/img/zain.png"
        }
        horizontalFiller(24.px)
        imageView {
            style {
                height = 64.px
            }
            attributes["src"] = "/public/img/unicef.png"
        }
        horizontalFiller(24.px)
        imageView {
            style {
                height = 64.px
            }
            attributes["src"] = "/public/img/pure-system.png"
        }
        horizontalFiller(24.px)
        imageView {
            style {
                height = 64.px
            }
            attributes["src"] = "/public/img/carapp.png"
        }
        horizontalFiller(24.px)
        imageView {
            style {
                height = 64.px
            }
            attributes["src"] = "/public/img/bok-grey.png"
        }
    }

    private fun View.whatWeDoView() = verticalLayout {
        style {
            backgroundImage = "url(/public/img/background-tech.png)"
            width = matchParent
            alignItems = Alignment.Center
            backgroundSize = "contain"
            backgroundRepeat = "no-repeat"
            alignSelf = Alignment.Center
        }
        textView {
            style {
                fontSize = 48.px
                fontWeight = "bold"
                color = AppColors.white
            }
            text = "WHAT WE OFFER"

        }

        verticalFiller(50.px)

        horizontalLayout {
            verticalLayout {
                offerView(
                    "/public/img/code-icon.png",
                    "Software development",
                    "Now it is our time to let you step aside and do the rest. We will be working hard on bringing your vision to life."
                )
                offerView(
                    "/public/img/ux-icon.png",
                    "USER EXPERIENCE DESIGN",
                    "Creating a good UI/UX is vital for your app. Many useful apps go unrecognized because of their bad user experience. Designing a good user experience requires knowledge and talent. "
                )
            }
            view {
                style {
                    height = matchParent
                    width = 1.px
                    backgroundColor = AppColors.white
                }
            }
            verticalLayout {
                verticalFiller(100.px)
                offerView(
                    "/public/img/consultancy.png",
                    "Technical consultancy",
                    "Need help with your application? Do not worry. We are here to help. With our long experience in the industry, we know the ins and outs of mobile app development. Our expert team is at your service to help you create your awesome app."
                )
                offerView(
                    "/public/img/pay-as-you-go.png",
                    "PAY AS YOU GO SOFTWARE",
                    "No software is ever “finished”. To cope with the market needs, you will always need your app to have new features and support the latest technologies."
                )
            }
        }
        verticalFiller(300.px)
    }

    private fun View.offerView(icon: String, title: String, description: String) = verticalLayout {
        style {
            width = 30.vw
        }
        verticalFiller(50.px)
        verticalLayout {
            style {
                padding = 32.px
            }
            imageView {
                style {
                    width = 56.px
                }
                attributes["src"] = icon
            }
            verticalFiller(12.px)
            textView {
                style {
                    fontWeight = "bold"
                    fontSize = 24.px
                    textTransform = "uppercase"
                    color = AppColors.white
                }
                text = title
            }
            verticalFiller(12.px)
            textView {
                style {
                    fontWeight = "300"
                    fontSize = 18.px
                    color = AppColors.white
                }
                text = description
            }
        }
        view {
            style {
                width = matchParent
                height = 1.px
                backgroundColor = AppColors.white
            }
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