package com.narbase.narnic.trial

import com.narbase.bos.common.one.NarsitePageRef
import com.narbase.kunafa.core.hydration.hydrate
import com.narbase.narnic.trial.one.NarsiteLandingPageHydrate
import kotlinx.browser.document


fun main() {

    document.head?.innerHTML += """
        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="preconnect" href="https://fonts.googleapis.com"> 
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> 
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600;700&display=swap" rel="stylesheet">
    """.trimIndent()

//    println(("671").toInt())
    hydrate(NarsitePageRef()) {

        mainButton?.onClick = {

            mainButton?.text = "I am hydrated"

            Unit
        }

        getStartedButton?.onClick = {

        }
    }

    hydrate(NarsitePageRef(), NarsiteLandingPageHydrate::hydrate)
}
