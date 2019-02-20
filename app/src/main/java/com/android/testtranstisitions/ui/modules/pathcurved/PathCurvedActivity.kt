package com.android.testtranstisitions.ui.modules.pathcurved

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.android.dars.base.BaseActivity

import kotlinx.android.synthetic.main.activity_path_curved.*
import android.R.attr.button
import android.view.Gravity
import android.R.attr.gravity
import android.widget.FrameLayout
import com.android.testtranstisitions.R
import com.transitionseverywhere.ArcMotion
import com.transitionseverywhere.ChangeBounds
import com.transitionseverywhere.TransitionManager


class PathCurvedActivity : BaseActivity() {

    var isReturnAnimation = false

    override fun getActivityLayoutResId(): Int = R.layout.activity_path_curved

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)

        button.setOnClickListener{
            isReturnAnimation = !isReturnAnimation
            TransitionManager.beginDelayedTransition(transitionsContainer,
                    ChangeBounds().setPathMotion(ArcMotion()).setDuration(500))

            val params = button.layoutParams as FrameLayout.LayoutParams
            params.gravity = if (isReturnAnimation)
                Gravity.LEFT or Gravity.TOP
            else
                Gravity.BOTTOM or Gravity.RIGHT
            button.layoutParams = params
        }
    }

}
