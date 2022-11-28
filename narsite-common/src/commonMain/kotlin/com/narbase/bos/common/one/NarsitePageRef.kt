package com.narbase.bos.common.one

import com.narbase.kunafa.core.components.*
import com.narbase.kunafa.core.hydration.reference

/*
 * NARBASE TECHNOLOGIES CONFIDENTIAL
 * ______________________________
 * [2017] -[2019] Narbase Technologies
 * All Rights Reserved.
 * Created by islam
 * On: 2021/09/11.
 */
class NarsitePageRef {
    var headerView by reference<View>()
    var mainButton by reference<Button>()
    var getStartedButton by reference<Button>()
}
