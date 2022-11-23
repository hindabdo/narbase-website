package com.narbase.narnic.main.common

import com.narbase.kunafa.core.components.Page
import com.narbase.kunafa.core.components.custom.htmlSnippet
import com.narbase.kunafa.core.css.fontFamily
import com.narbase.kunafa.core.css.stringRuleSet
import com.narbase.narnic.main.isDev

/*
 * NARBASE TECHNOLOGIES CONFIDENTIAL
 * ______________________________
 * [2017] -[2019] Narbase Technologies
 * All Rights Reserved.
 * Created by islam
 * On: 2022/01/31.
 */

fun Page.commonPageHead() {
    stringRuleSet("*") {
        fontFamily = "'Open Sans', sans-serif"
    }
    htmlSnippet(plausibleSnippet)
    htmlSnippet(faviconSnippet)
    htmlSnippet(fontImportSnippet)
    frontEndScript()
    liveReloadScript()
    htmlSnippet(metaPixelSnippet)
    htmlSnippet(customMetaPixelFunctionsSnippet)
    htmlSnippet("""<meta charset="utf-8">""")

}

fun Page.smoothPageScroll() {
    stringRuleSet("html") {
        this["scroll-behavior"] = "smooth"
    }

}

private val plausibleSnippet = """
    <script defer data-domain="balsam.narbase.com" src="https://analytics.balsammedico.com/js/plausible.js"></script>
""".trimIndent()

private val faviconSnippet = """
    <link rel="apple-touch-icon" sizes="180x180" href="/public/img/fav/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/public/img/fav/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/public/img/fav/favicon-16x16.png">
    <link rel="manifest" href="/public/img/fav/site.webmanifest">
    <link rel="mask-icon" href="/public/img/fav/safari-pinned-tab.svg" color="#5bbad5">
    <link rel="shortcut icon" href="/public/img/fav/favicon.ico">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="msapplication-config" content="/public/img/fav/browserconfig.xml">
    <meta name="theme-color" content="#ffffff">
""".trimIndent()

private val fontImportSnippet = """
        <link rel="preconnect" href="https://fonts.googleapis.com"> 
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> 
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;600;700&display=swap" rel="stylesheet">
""".trimIndent()

private val metaPixelSnippet = """
    <!-- Meta Pixel Code -->
    <script>
    !function(f,b,e,v,n,t,s)
    {if(f.fbq)return;n=f.fbq=function(){n.callMethod?
    n.callMethod.apply(n,arguments):n.queue.push(arguments)};
    if(!f._fbq)f._fbq=n;n.push=n;n.loaded=!0;n.version='2.0';
    n.queue=[];t=b.createElement(e);t.async=!0;
    t.src=v;s=b.getElementsByTagName(e)[0];
    s.parentNode.insertBefore(t,s)}(window, document,'script',
    'https://connect.facebook.net/en_US/fbevents.js');
    fbq('init', '605212413164180');
    fbq('track', 'PageView');
    </script>
    <noscript><img height="1" width="1" style="display:none"
    src="https://www.facebook.com/tr?id=605212413164180&ev=PageView&noscript=1"
    /></noscript>
    <!-- End Meta Pixel Code -->
""".trimIndent()

private val customMetaPixelFunctionsSnippet = """
<script>
  function fbqEvent(event) { fbq('track', event); }
</script>

""".trimIndent()

fun Page.frontEndScript() {
    script {
//        attributes["crossorigin"] = true
        attributes["defer"] = true
        attributes["src"] = if (isDev) "http://localhost:8080/bos-web.js" else "/public/js/client/bos-web.js"
    }
}

private fun Page.liveReloadScript() {
    if (isDev.not()) return
    script {
        attributes["defer"] = true
        attributes["src"] = "/public/js/live.js"
    }
}
