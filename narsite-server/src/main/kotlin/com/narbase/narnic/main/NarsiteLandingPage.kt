package com.narbase.narnic.main

import com.narbase.bos.common.data.AppColors
import com.narbase.bos.common.one.NarsitePageRef
import com.narbase.kunafa.core.components.*
import com.narbase.kunafa.core.components.layout.LinearLayout
import com.narbase.kunafa.core.css.*
import com.narbase.kunafa.core.dimensions.*
import com.narbase.kunafa.core.dimensions.dependent.matchParent
import com.narbase.kunafa.core.dimensions.dependent.weightOf
import com.narbase.kunafa.core.dimensions.dependent.wrapContent
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
                    suitsYourNeedsSection()
                    ourWorkSection()
                    balsamOneSection()
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

    private fun View.suitsYourNeedsSection() = verticalLayout {
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
                fontSize = 32.px
                color = AppColors.white
            }
            text = "WE DEVELOP A SOFTWARE THAT SUITS YOUR NEEDS"

        }

        verticalFiller(50.px)

        horizontalLayout {
            style {
                width = 50.percent
                flexWrap = "wrap"
                alignItems = Alignment.Center
                justifyContent = JustifyContent.Center
            }
            softwareTypeViewWithIcon("/public/img/desktop.png", "Desktop Apps")
            softwareTypeViewWithIcon("/public/img/mobile.png", "Mobile Apps")
            softwareTypeViewWithIcon("/public/img/website.png", "Websites")
            softwareTypeViewWithIcon("/public/img/web.png", "Web Apps")
            softwareTypeViewWithIcon("/public/img/game.png", "Game Development")
        }
        verticalFiller(50.px)
        imageView {
            style {
                maxWidth = 70.percent
            }
            attributes["src"] = "/public/img/devices-suits.png"
        }
        verticalFiller(200.px)

    }

    private fun View.ourWorkSection() = verticalLayout {
        style {
            backgroundImage = "url(/public/img/global-back.png)"
            width = matchParent
            alignItems = Alignment.Center
            backgroundSize = "100% auto"
            backgroundRepeat = "no-repeat"
            alignSelf = Alignment.Center
        }
        verticalFiller(100.px)
        textView {
            style {
                fontSize = 32.px
                fontWeight = "bold"
                color = AppColors.white
            }
            text = "OUR WORK"
        }
        verticalFiller(50.px)

        imageView {
            style {
                maxWidth = 30.percent
            }
            attributes["src"] = "/public/img/our-work-laptop.png"
        }

        verticalFiller(50.px)
        textView {
            style {
                fontWeight = "300"
                color = Color.white
                maxWidth = 50.percent
                textAlign = TextAlign.Center
                fontSize = 18.px
            }
            text =
                "With more than 10 years experience in the mobile development industry, we promise that you will never need to search for apps developers ever again."
        }

        verticalFiller(100.px)

        projectsSection()
    }

    private fun View.projectsSection() = horizontalScrollLayout {
        style {
            width = matchParent
        }
        horizontalLayout {
            projectView(
                "Balsam Medico",
                "Cloud-based, Modern, Clinic Management System that allows you to provide better services for patients.",
                "/public/img/medico-white.png",
                "/public/img/medico-screenshot.png"
            )
            projectView(
                "CarApp",
                "CarApp is the largest ride hailing \n" +
                        "platform in West Africa. \n" +
                        "With a huge Captains base, CarApp  provides reliable, safe and comfortable rides 24/7.",
                "/public/img/carapp-white.png",
                "/public/img/carapp-screenshot.png"
            )
            projectView(
                "Balsam App",
                "OROOMA  is  an  online  recruitment  platform  to bridge the gap between employers and future employees by providing both of them with powerful tools to achieve their goals",
                "/public/img/orooma-white.png",
                "/public/img/medico-screenshot.png"
            )
            projectView(
                "Orooma",
                "OROOMA  is  an  online  recruitment  platform  to bridge the gap between employers and future employees by providing both of them with powerful tools to achieve their goals",
                "/public/img/orooma-white.png",
                "/public/img/medico-screenshot.png"
            )
            projectView(
                "Alburuj",
                "Cloud-based, Modern, Clinic Management System that allows you to provide better services for patients.",
                "/public/img/medico-white.png",
                "/public/img/medico-screenshot.png"
            )
            projectView(
                "Petrobash App",
                "CarApp is the largest ride hailing \n" +
                        "platform in West Africa. \n" +
                        "With a huge Captains base, CarApp  provides reliable, safe and comfortable rides 24/7.",
                "/public/img/carapp-white.png",
                "/public/img/carapp-screenshot.png"
            )
            projectView(
                "Orooma",
                "OROOMA  is  an  online  recruitment  platform  to bridge the gap between employers and future employees by providing both of them with powerful tools to achieve their goals",
                "/public/img/orooma-white.png",
                "/public/img/medico-screenshot.png"
            )
        }
        verticalFiller(500.px)
    }

    private fun View.projectView(title: String, description: String, icon: String, featuredScreenshot: String) =
        horizontalLayout {
            style {
                backgroundColor = Color(255, 255, 255, 0.06)
                border = "1px solid ${AppColors.textDarkerGrey}"
                borderRadius = 8.px
                width = 400.px
                margin = 16.px
                paddingBottom = 16.px
            }
            verticalLayout {
                style {
                    width = weightOf(2)
                }
                verticalFiller(16.px)
                imageView {
                    style {
                        width = 80.px
                        marginStart = 16.px
                        opacity = 0.7
                    }
                    attributes["src"] = icon
                }
                verticalFiller(16.px)
                textView {
                    style {
                        fontWeight = "bold"
                        fontSize = 24.px
                        color = Color.white
                        marginStart = 16.px
                    }
                    text = title
                }
                verticalFiller(16.px)

                view {
                    style {
                        width = 20.px
                        backgroundColor = Color.white
                        height = 2.px
                        marginBottom = (-1).px
                        marginStart = 16.px
                    }
                }
                view {
                    style {
                        height = 1.px
                        backgroundColor = AppColors.textDarkGrey
                        width = matchParent
                    }
                }
                verticalFiller(16.px)

                textView {
                    style {
                        marginBottom = 16.px
                        marginStart = 16.px
                        color = AppColors.white
                        fontSize = 14.px
                        fontWeight = "300"
                        width = matchParent
                        textOverflow = "ellipsis"
                        overflow = "hidden"
                        display = "-webkit-box"
                        this["-webkit-line-clamp"] = "3"
                        this["-webkit-box-orient"] = "vertical"
                    }
                    text = description
                }
            }
            linearLayout {
                style {
                    width = weightOf(1)
                    backgroundImage = "url(/public/img/circle-back.png)"
                    backgroundSize = "cover"
                    justifyContent = JustifyContent.Center
                    alignSelf = Alignment.Center
                }

                imageView {
                    style {
                        width = matchParent
                        paddingStart = 16.px
                    }
                    attributes["src"] = featuredScreenshot
                }
            }

        }

    private fun View.softwareTypeViewWithIcon(icon: String, title: String) = horizontalLayout {
        style {
            border = "1px solid ${AppColors.textDarkGrey}"
            borderRadius = 8.px
            margin = 16.px
            padding = "8px 16px".dimen()
            alignItems = Alignment.Center
        }
        imageView {
            style {
                width = 32.px
                height = 32.px
            }
            attributes["src"] = icon
        }
        horizontalFiller(8.px)
        textView {
            style {
                color = Color.white
                fontSize = 16.px
            }
            text = title
        }
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

    private fun View.balsamOneSection() = verticalLayout {
        style {
//            backgroundImage = "url(/public/img/balsam-one-background.png)"
            width = matchParent
            minHeight = 500.px
            alignSelf = Alignment.Center
            alignItems = Alignment.Center
            backgroundSize = "100% 100%"
            backgroundRepeat = "no-repeat"
            alignContent = Alignment.Center
        }

        horizontalLayout {
            style {
                width = wrapContent
                padding = 100.px
                backgroundImage = "url(/public/img/balsam-text-background.png)"
                backgroundSize = "contain"
                backgroundRepeat = "no-repeat"
            }
            verticalLayout {

                style {
                    maxWidth = 30.vw
                    alignSelf = Alignment.Center
                }
                imageView {
                    style {
                        width = 200.px
                    }
                    attributes["src"] = "/public/img/balsam-one.png"
                }

                verticalFiller(16.px)
                textView {
                    style {
                        color = Color.white
                        fontWeight = "bold"
                        fontSize = 24.px
                    }
                    text = "OUR DIGITAL HEALTH \n" +
                            "SOLUTION"
                }

                verticalFiller(16.px)
                textView {
                    style {
                        color = Color.white
                        fontWeight = "300"
                    }
                    text = "At Narbase, we envision that we will lead and innovate in the Digital Health sector in Sudan. Strategically, digital health will have an increasing importance to Sudan as it will help solve many problems for the Sudanese people. "
                }
                verticalFiller(32.px)

                textView {
                    style {
                        padding = "4px 12px".dimen()
                        borderRadius = 8.px
                        backgroundColor = AppColors.balsamColor
                        color = AppColors.narnicVeryDarkColor
                        fontWeight = "bold"
                    }
                    text = "Learn more"
                }
            }

            horizontalFiller(100.px)
            verticalLayout {
                style {
                    alignSelf = Alignment.Center
                    maxWidth = 30.vw
                }
                imageView {
                    style {
                        maxWidth = 40.vw
                        alignSelf = Alignment.Center
                    }
                    attributes["src"] = "/public/img/balsam-one-website.png"
                }
                horizontalLayout {
                    style {
                        width = matchParent
                    }
                    numbersTextView("3K+")
                    horizontalFiller(16.px)
                    numbersTextView("32+")
                    horizontalFiller(16.px)
                    numbersTextView("120+")
                    horizontalFiller(16.px)
                    numbersTextView("50+")
                }
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
    private fun LinearLayout.numbersTextView(content: String) = textView {
        style {
            color = AppColors.white
            width = weightOf(1)
            padding = "8px 16px".dimen()
            border = "0.5px solid ${AppColors.borderColor}"
            borderRadius = 8.px
            textAlign = TextAlign.Center
            fontSize = 24.px
            fontWeight = "bold"
        }
        text = content
    }
}