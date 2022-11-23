package com.narbase.narnic.main.common

import com.narbase.kunafa.core.components.Anchor

/*
 * NARBASE TECHNOLOGIES CONFIDENTIAL
 * ______________________________
 * [2017] -[2019] Narbase Technologies
 * All Rights Reserved.
 * Created by islam
 * On: 2022/09/14.
 */

fun fbqTrackScript(event: String, options: String? = null) = fbqScript("track", event, options)

fun fbqScript(action: String, event: String, options: String? = null) = """<script>
    fbq('$action', '$event' ${if (options != null) ", $options" else ""});
  </script>"""


fun Anchor.fbqTrack(event: String) {
    attributes["onclick"] = "return fbqEvent('$event');"
}