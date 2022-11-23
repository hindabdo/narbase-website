package com.narbase.narnic.trial

import com.narbase.kunafa.core.components.Component
import com.narbase.kunafa.core.components.View
import com.narbase.kunafa.core.components.detached
import com.narbase.kunafa.core.components.layout.LinearLayout
import com.narbase.kunafa.core.components.verticalLayout
import com.narbase.kunafa.core.css.*
import com.narbase.kunafa.core.dimensions.dependent.wrapContent
import com.narbase.kunafa.core.dimensions.px
import com.narbase.kunafa.core.drawable.Color
import com.narbase.kunafa.core.lifecycle.Observable

/**
 * NARBASE TECHNOLOGIES CONFIDENTIAL
 * ______________________________
 * [2017] -[2018] Narbase Technologies
 * All Rights Reserved.
 * Created by ${user}
 * On: ${Date}.
 */
class PopUpDialog(val onDismissed: (() -> Unit)? = null) {
    private val background by lazy {

        detached.verticalLayout {
            style {
                zIndex = 200
            }
            isVisible = false
        }
    }

    fun View.setup() {
        mount(background)
        hideDialog.observe {
            dismissDialog()
        }
    }

    fun showDialog(
            isDismissible: Boolean = true,
            itemsAlignment: Alignment = Alignment.Center,
            popUpZIndex: Int = 99,
            block: LinearLayout.() -> Unit) {
        isDialogOpen = true
        background.isVisible = true
        background.clearAllChildren()
        background.mount(object : Component() {
            override fun View?.getView() =
                    verticalLayout {
                        id = "PopUp background"
                        style {
                            position = "absolute"
                            top = 0.px
                            bottom = 0.px
                            right = 0.px
                            left = 0.px
                            backgroundColor = Color(0, 0, 0, 0.7)
                            alignItems = itemsAlignment
                            justifyContent = JustifyContent.Center
                            zIndex = popUpZIndex
                        }
                        onClick = {
                            if (isDismissible) {
                                dismissDialog()
                            }
                        }

                        verticalLayout {
                            id = "PopUp Dialog inner views"
                            style {
                                width = wrapContent
                                height = wrapContent
                            }
                            onClick = { it.stopPropagation() }
                            block()
                        }
                    }
        })
        if (isDismissible) {
            dismissDialog()
        }
    }

    fun dismissDialog() {
        background.isVisible = false
        background.mount(object : Component() {
            override fun View?.getView() =
                    verticalLayout { }
        })
        onDismissed?.invoke()
        isDialogOpen = false
    }

    companion object {
        var isDialogOpen: Boolean = false
        val hideDialog = Observable<Unit>()
    }
}


fun View.popUpDialog(
        onDismissed: (() -> Unit)? = null
): PopUpDialog =
        PopUpDialog(onDismissed).apply {
            setup()
        }
