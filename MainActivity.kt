package com.example.layout

import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import android.graphics.Color
import android.util.Log
import android.view.View.generateViewId
import android.widget.Button
import android.widget.TextView
import androidx.compose.material3.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.marginStart
import androidx.core.view.marginTop
import com.example.layout.ui.theme.LayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val textView = TextView(this).apply {
            id = generateViewId()
            text = "The sizes you specify using resource qualifiers like smallest width are not the actual screen sizes. Rather, the sizes specify the width or height in dp units that are available to your app's window. The Android system might use some of the screen for system UI (such as the system bar at the bottom of the screen or the status bar at the top), so some of the screen might not be available for your layout. If your app is used in multi‑window mode, the app only has access to the size of the window that contains the app. When the window is resized, it triggers a configuration change with the new window size, which enables the system to select an appropriate layout file. So, the resource qualifier sizes you declare should specify only the space needed by your app. The system accounts for any space used by system UI when providing space for your layout."

        }
        val button = Button(this).apply {
            id = generateViewId()
            text = "Click me"
        }

        var button1 = Button(this).apply {
            id = generateViewId()
            text = "next page"
            setOnClickListener {
                val intent = Intent(this@MainActivity,SecondActivity :: class.java)
                startActivity(intent)
            }
        }
        val layout = ConstraintLayout(this).apply constrainLayout@ {
//            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.BLUE)
            addView(textView)
            addView(button)
            addView(button1)
            ConstraintSet().apply {
                constrainWidth(textView.id, ConstraintSet.WRAP_CONTENT)
                constrainHeight(textView.id, ConstraintSet.WRAP_CONTENT)
                connect(textView.id, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT)
                connect(textView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)

                connect(textView.id, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT)

                // Position the button below the TextView
                constrainWidth(button.id, ConstraintSet.WRAP_CONTENT)
                constrainHeight(button.id, ConstraintSet.WRAP_CONTENT)
                connect(button.id, ConstraintSet.TOP, textView.id, ConstraintSet.BOTTOM)
                connect(button.id, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT)
                connect(button.id, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT)

//                constrainWidth(button1.id, ConstraintSet.MATCH_CONSTRAINT)
                constrainHeight(button1.id, ConstraintSet.WRAP_CONTENT)
                connect(button1.id,ConstraintSet.TOP,textView.id,ConstraintSet.BOTTOM)
                connect(button1.id,ConstraintSet.LEFT,button.id,ConstraintSet.RIGHT)
                connect(button1.id,ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT)

                applyTo(this@constrainLayout )
            }

        }


       Log.i("TAG","LEFT ${textView.left} RIGHT ${textView.right} TOP ${textView.top} BOTTOM ${textView.bottom}  ")
        Log.i("TAG","${textView.getMeasuredHeight()}")
        setContentView(layout)





    }

}
