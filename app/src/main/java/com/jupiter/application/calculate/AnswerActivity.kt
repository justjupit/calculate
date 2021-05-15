package com.jupiter.application.calculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_answer.*
import java.math.BigDecimal
import java.text.DecimalFormat

class AnswerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        val intent = getIntent()
        val you: Double = intent.getDoubleExtra("answer",0.0)
        val correct:Double = intent.getDoubleExtra("correct",0.0)
        val ok = String.format("%.1f",correct)

        yourans.text = you.toString()
        correctans.text = ok
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