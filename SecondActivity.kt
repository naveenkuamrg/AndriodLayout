package com.example.layout

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val linearLayout = ConstraintLayout(this).apply linearLayout@ {
            val constraintLayout = ConstraintLayout(this@SecondActivity).apply constraintLayout@ {
                id = View.generateViewId()
                val btn1 = Button(this@SecondActivity).apply {
                    text = "Button1"
                    id = View.generateViewId()
                }
                val btn2 = Button(this@SecondActivity).apply {
                    text = "Button2"
                    id = View.generateViewId()
                    setOnClickListener {
                        intent = Intent(this@SecondActivity, ThirdLayout::class.java)
                        startActivity(intent)
                    }
                }
                val btn3 = Button(this@SecondActivity).apply {
                    text = "Button3"
                    id = View.generateViewId()
                }
                val btn4 = Button(this@SecondActivity).apply {
                    text = "Button4"
                    id = View.generateViewId()
                }
                setBackgroundColor(Color.BLUE)
                addView(btn1)
                addView(btn2)
//                addView(btn3)
//                addView(btn4)
                ConstraintSet().apply {
                    constrainWidth(btn1.id,ConstraintSet.MATCH_CONSTRAINT)
                    constrainHeight(btn1.id,ConstraintSet.WRAP_CONTENT)
//                    connect(btn1.id,ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT)
//                    connect(btn1.id, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT,300)
//                    connect(btn1.id, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT)
//                    connect(btn1.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
//                    connect(btn1.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
//                    connect(btn1.id,ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,)
//                    connect(btn1.id, ConstraintSet.LEFT, btn2.id, ConstraintSet.RIGHT)

                    constrainWidth(btn2.id,ConstraintSet.MATCH_CONSTRAINT)
                    constrainHeight(btn2.id,ConstraintSet.WRAP_CONTENT)
//                    connect(btn2.id,ConstraintSet.TOP,btn1.id,ConstraintSet.TOP)
//                    connect(btn2.id,ConstraintSet.LEFT,btn1.id,ConstraintSet.RIGHT)
//                    connect(btn2.id,ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT)


//
//                    constrainWidth(btn3.id,ConstraintSet.WRAP_CONTENT)
//                    constrainHeight(btn3.id,ConstraintSet.WRAP_CONTENT)
//                    connect(btn3.id,ConstraintSet.TOP,btn2.id,ConstraintSet.BOTTOM)
//                    connect(btn3.id,ConstraintSet.LEFT,btn1.id,ConstraintSet.LEFT)
//                    createHorizontalChain(
//                        leftId: Int,
//                        leftSide: Int,
//                        rightId: Int,
//                        rightSide: Int,
//                        chainIds: IntArray!,
//                        weights: FloatArray!,
//                        style: Int
//                    )
                    createHorizontalChain(ConstraintSet.PARENT_ID,ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT, intArrayOf(btn1.id,btn2.id),floatArrayOf(2f, 1f),ConstraintSet.CHAIN_SPREAD)
//                    centerVertically(btn2.id,ConstraintSet.PARENT_ID,ConstraintSet.TOP,0,btn1.id,ConstraintSet.TOP,0,0.5f)
//                    centerHorizontally(btn2.id,ConstraintSet.PARENT_ID)

//
//                    constrainWidth(btn4.id,ConstraintSet.WRAP_CONTENT)
//                    constrainHeight(btn4.id,ConstraintSet.WRAP_CONTENT)
//                    connect(btn4.id,ConstraintSet.TOP,btn2.id,ConstraintSet.BOTTOM)
//                    connect(btn4.id,ConstraintSet.LEFT,btn3.id,ConstraintSet.RIGHT)





                    applyTo(this@constraintLayout)
                }

            }
            setBackgroundColor(Color.RED)
            val backButton = Button(this@SecondActivity).apply {
                text = "<-"
                setOnClickListener {
                    onBackPressed()
                }
                id = View.generateViewId()
            }
//            orientation = LinearLayout.VERTICAL
            addView(constraintLayout)
            addView(backButton)


            ConstraintSet().apply {

//                constrainWidth(constraintLayout.id,1000)
                constrainWidth(backButton.id,ConstraintSet.MATCH_CONSTRAINT)
                constrainHeight(backButton.id,ConstraintSet.WRAP_CONTENT)
//                connect(constraintLayout.id,ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP)
//                connect(constraintLayout.id,ConstraintSet.BOTTOM,ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM)
                connect(constraintLayout.id,ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT)
                connect(constraintLayout.id,ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT)
                connect(backButton.id,ConstraintSet.RIGHT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT)
                connect(backButton.id,ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT)
//                connect()

//                createHorizontalChain(ConstraintSet.PARENT_ID,ConstraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.RIGHT, intArrayOf(btn1.id,btn2.id),floatArrayOf(1f, 1f),ConstraintSet.CHAIN_SPREAD)
                createVerticalChain(ConstraintSet.PARENT_ID,ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.BOTTOM, intArrayOf(constraintLayout.id,backButton.id),
                    floatArrayOf(2f,1f),
                    ConstraintSet.CHAIN_PACKED
                )
                applyTo(this@linearLayout)
            }
            id = View.generateViewId()
        }

        ConstraintSet().apply {
            constrainHeight(linearLayout.id,ConstraintSet.MATCH_CONSTRAINT)
            constrainWidth(linearLayout.id,ConstraintSet.MATCH_CONSTRAINT)

//            applyTo(linearLayout)
        }

        setContentView(linearLayout)
    }
}