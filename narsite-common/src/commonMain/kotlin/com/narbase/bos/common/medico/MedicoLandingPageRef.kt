package com.narbase.bos.common.medico

import com.narbase.kunafa.core.components.Button
import com.narbase.kunafa.core.components.View
import com.narbase.kunafa.core.hydration.reference

/*
 * NARBASE TECHNOLOGIES CONFIDENTIAL
 * ______________________________
 * [2017] -[2019] Narbase Technologies
 * All Rights Reserved.
 * Created by islam
 * On: 2021/09/11.
 */
class MedicoBalsamOnePageRef {
    var mainVideo by reference<View>()
    var headerView by reference<View>()
    var mainButton by reference<Button>()

    var medicoTabsRefView by reference<View>()
    var curvesRoot by reference<View>()

}
