package com.example.layout

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.R

class ThirdLayout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val btn1 = Button(this).apply {
            text = "Button1"
            id = View.generateViewId()
        }
        val txt = TextView(this).apply {
            text = "this is Relative Layout"
            layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                addRule(RelativeLayout.BELOW,btn1.id)
                setMargins(16,16,16,16)

            }
        }

        val btn2 = Button(this).apply {
            text = "Button2"
            id = View.generateViewId()
        }
        val relativeLayout = RelativeLayout(this).apply {
            addView(btn1)
            addView(btn2)
            addView(txt)


        }

        btn1.layoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            addRule(RelativeLayout.ALIGN_PARENT_TOP)
            addRule(RelativeLayout.ALIGN_PARENT_START)
        }

        // Position btn2 to the right of btn1, matching their tops
        btn2.layoutParams = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            addRule(RelativeLayout.ALIGN_TOP, btn1.id)
            addRule(RelativeLayout.RIGHT_OF, btn1.id)
        }

        setContentView(relativeLayout)

    }

}