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
    var mainVideo by reference<View>()
    var headerView by reference<View>()
    var mainButton by reference<Button>()
    var getStartedButton by reference<Button>()
    var medicoTabsRefView by reference<View>()
    var linkTabsRefView by reference<View>()
    var mobileTabsRefView by reference<View>()
    var sitesTabsRefView by reference<View>()

    var mainFeaturesTab1 by reference<View>()
    var mainFeaturesTab2 by reference<View>()
    var mainFeaturesTab3 by reference<View>()
    var mainFeaturesTab4 by reference<View>()

    var mainFeaturesTextView by reference<TextView>()
    var mainFeaturesContent by reference<View>()
    var mainFeaturesImage by reference<ImageView>()
}
