package com.android.testtranstisitions.ui.modules.changetext

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.android.dars.base.BaseActivity
import com.android.testtranstisitions.R

import kotlinx.android.synthetic.main.activity_change_text.*
import com.transitionseverywhere.ChangeText
import com.transitionseverywhere.TransitionManager


class ChangeTextActivity : BaseActivity() {

    var isSecondText = false

    override fun getActivityLayoutResId(): Int = R.layout.activity_change_text

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)

        button.setOnClickListener {
            isSecondText = !isSecondText
            TransitionManager.beginDelayedTransition(transitionsContainer,
                    ChangeText().setChangeBehavior(ChangeText.CHANGE_BEHAVIOR_OUT_IN))
            textview.text = if (isSecondText) resources.getString(R.string.second_text)
                                                        else resources.getString(R.string.first_text)
        }
    }

}
