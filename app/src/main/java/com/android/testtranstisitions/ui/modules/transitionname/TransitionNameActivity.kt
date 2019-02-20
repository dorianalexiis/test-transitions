package com.android.testtranstisitions.ui.modules.transitionname

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import com.android.dars.base.BaseActivity
import com.android.testtranstisitions.R

import kotlinx.android.synthetic.main.activity_transition_name.*
import android.widget.TextView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.transitionseverywhere.ChangeBounds
import com.transitionseverywhere.TransitionManager
import java.util.*

class TransitionNameActivity : BaseActivity() {

    var titles = mutableListOf("Item 1", "Item 2", "Item 3","Item 4","Item 5")


    override fun getActivityLayoutResId(): Int = R.layout.activity_transition_name

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)
        createViews(LayoutInflater.from(baseContext), layout, titles)
         button.setOnClickListener{
             TransitionManager.beginDelayedTransition(layout, ChangeBounds())
             Collections.shuffle(titles)
             createViews(LayoutInflater.from(baseContext), layout, titles)
         }
    }

    private fun createViews(inflater: LayoutInflater, layout: ViewGroup, titles: List<String>) {
        layout.removeAllViews()
        for (title in titles) {
            val textView = inflater.inflate(R.layout.text_view, layout, false) as TextView
            textView.text = title
            TransitionManager.setTransitionName(textView, title)
            layout.addView(textView)
        }
    }
}
