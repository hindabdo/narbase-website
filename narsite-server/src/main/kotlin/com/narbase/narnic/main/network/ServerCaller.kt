package com.narbase.narnic.main.network

import com.narbase.narnic.main.isDev

/*
 * NARBASE TECHNOLOGIES CONFIDENTIAL
 * ______________________________
 * [2017] -[2019] Narbase Technologies
 * All Rights Reserved.
 * Created by islam
 * On: 2020/12/15.
 */
object ServerCaller {

    private val BASE_URL = if (isDev) "http://localhost:8010" else ""
    val IMAGES_FOLDER = if (isDev) "/public/img" else  "/trial/public/img"

}