package com.android.testtranstisitions.ui.modules.grid

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import com.android.dars.base.BaseActivity
import com.android.testtranstisitions.ui.adapters.GridAdapter

import kotlinx.android.synthetic.main.activity_grid.*
import android.view.View
import android.graphics.Rect
import android.support.v7.widget.GridLayoutManager
import com.android.testtranstisitions.R
import com.transitionseverywhere.Explode
import com.transitionseverywhere.Transition
import com.transitionseverywhere.TransitionManager
import kotlinx.android.synthetic.main.activity_button.*


class GridActivity : BaseActivity() {
    var isBlankScreen:Boolean = false

    override fun getActivityLayoutResId(): Int = R.layout.activity_grid

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)

        setAdapter()
    }

    private fun setAdapter() {
        var adapter = GridAdapter(mutableListOf(1, 2, 3, 4, 5, 6,7,8,9,10,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
                ,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1),
                object : GridAdapter.OnClick {
                    override fun onClick(clickedView: View) {
                        val viewRect = Rect()
                        clickedView.getGlobalVisibleRect(viewRect)

                        // create Explode transition with epicenter
                        val explode = Explode()
                                .setEpicenterCallback(object : Transition.EpicenterCallback() {
                                    override fun onGetEpicenter(transition: Transition): Rect {
                                        return viewRect
                                    }
                                })
                        explode.setDuration(1000)
                        TransitionManager.beginDelayedTransition(rcGrid, explode)

                        // remove all views from Recycler View
                        rcGrid.adapter = null
                        isBlankScreen = true
                    }
                } )
        val linearLayout = GridLayoutManager(baseContext,3)
        rcGrid.layoutManager = linearLayout
        rcGrid.adapter = adapter
    }

    override fun onBackPressed() {
        if(isBlankScreen){
            isBlankScreen = false
            setAdapter()
        }else{
            super.onBackPressed()
        }
    }
}
