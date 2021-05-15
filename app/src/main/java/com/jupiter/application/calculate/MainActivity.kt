package com.jupiter.application.calculate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generate()

        random.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                generate()
            }
        })

        submit.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                intent = Intent(this@MainActivity,AnswerActivity::class.java).apply{
                    if (operator.text=="+") {
                        putExtra("answer", answer.text.toString().toDouble())
                        putExtra("correct", (x.text.toString().toDouble() + y.text.toString().toDouble()))
                    }
                    else if (operator.text=="-"){
                        putExtra("answer", answer.text.toString().toDouble())
                        putExtra("correct", (x.text.toString().toDouble() - y.text.toString().toDouble()))
                    }
                    else if (operator.text=="x"){
                        putExtra("answer", answer.text.toString().toDouble())
                        putExtra("correct", (x.text.toString().toDouble() * y.text.toString().toDouble()))
                    }
                    else if (operator.text=="/"){
                        val ansnum = (answer.text.toString().toDouble())
                        val correctnum = (x.text.toString().toDouble() / y.text.toString().toDouble())

                        putExtra("answer", ansnum)
                        putExtra("correct", correctnum)
                    }

                }
                startActivity(intent)
            }

        })

    }

    fun generate(){
        val ops = arrayOf('+','-','x','/')
        val i = (0..3).random()
        val ranx = (1..100).random()
        val rany = (1..100).random()
        x.text = ranx.toString()
        y.text = rany.toString()
        operator.text = ops[i].toString()

    }
}