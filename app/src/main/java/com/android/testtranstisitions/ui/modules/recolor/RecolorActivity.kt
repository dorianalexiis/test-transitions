package com.android.testtranstisitions.ui.modules.recolor

import android.animation.TimeInterpolator
import android.os.Bundle
import com.android.dars.base.BaseActivity

import kotlinx.android.synthetic.main.activity_recolor.*
import android.support.v4.view.animation.FastOutLinearInInterpolator
import android.support.v4.view.animation.LinearOutSlowInInterpolator
import android.view.View
import com.transitionseverywhere.Fade
import com.transitionseverywhere.TransitionManager
import com.transitionseverywhere.TransitionSet
import com.transitionseverywhere.extra.Scale
import android.graphics.drawable.ColorDrawable
import com.android.testtranstisitions.R
import com.transitionseverywhere.Recolor





class RecolorActivity : BaseActivity() {

    var isColorsInverted = false

    override fun getActivityLayoutResId(): Int = R.layout.activity_recolor

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)

        button.setOnClickListener{
            isColorsInverted = !isColorsInverted
            TransitionManager.beginDelayedTransition(transitionsContainer, Recolor())

            button.setTextColor(resources.getColor(if (!isColorsInverted) R.color.second_accent else R.color.accent))
            button.setBackgroundDrawable(
                    ColorDrawable(resources.getColor(if (!isColorsInverted)
                        R.color.accent
                    else
                        R.color.second_accent)))
        }
    }
}
