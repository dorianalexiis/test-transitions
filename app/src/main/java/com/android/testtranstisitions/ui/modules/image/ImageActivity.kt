package com.android.testtranstisitions.ui.modules.image

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.android.dars.base.BaseActivity

import kotlinx.android.synthetic.main.activity_image.*
import android.widget.ImageView.ScaleType
import android.view.ViewGroup
import android.widget.ImageView
import com.android.testtranstisitions.R
import com.transitionseverywhere.ChangeBounds
import com.transitionseverywhere.ChangeImageTransform
import com.transitionseverywhere.TransitionManager
import com.transitionseverywhere.TransitionSet


class ImageActivity : BaseActivity() {
    var expanded = false

    override fun getActivityLayoutResId(): Int = R.layout.activity_image


    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)

        imageView.setOnClickListener {
            expanded = !expanded
            clickImage()
        }
    }

    private fun clickImage() {
        TransitionManager.beginDelayedTransition(transitionsContainer, TransitionSet()
                .addTransition(ChangeBounds())
                .addTransition(ChangeImageTransform()))

        val params = imageView.layoutParams
        params.height = if (expanded)
            ViewGroup.LayoutParams.MATCH_PARENT
        else
            ViewGroup.LayoutParams.WRAP_CONTENT
        imageView.layoutParams = params

        imageView.scaleType = if (expanded)
            ImageView.ScaleType.CENTER_CROP
        else
            ImageView.ScaleType.FIT_CENTER
    }
}
