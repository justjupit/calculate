package com.jupiter.application.calculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_answer.*

class AnswerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        val intent = getIntent()
        val you:Int = intent.getIntExtra("answer",0)
        val correct:Int = intent.getIntExtra("correct",0)

        yourans.text = you.toString()
        correctans.text = correct.toString()
        if(correctans.text != yourans.text){
            truefalse.text ="Wrong"
        }
        else truefalse.text = "Correct"

        back.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                finish()
            }
        })
    }
}