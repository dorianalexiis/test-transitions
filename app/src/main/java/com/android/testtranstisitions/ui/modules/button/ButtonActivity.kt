package com.android.testtranstisitions.ui.modules.button

import android.os.Bundle
import com.android.dars.base.BaseActivity
import kotlinx.android.synthetic.main.activity_button.*
import android.view.View
import com.android.testtranstisitions.R
import com.transitionseverywhere.TransitionManager


class ButtonActivity : BaseActivity(){
    var visibleButton = false

    override fun getActivityLayoutResId(): Int = R.layout.activity_button

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)

        button.setOnClickListener {
            TransitionManager.beginDelayedTransition(transitions_container)
            visibleButton = !visibleButton
            text.visibility = if (visibleButton) View.VISIBLE else View.GONE
        }
    }
}