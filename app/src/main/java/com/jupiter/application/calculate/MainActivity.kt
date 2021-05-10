package com.jupiter.application.calculate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

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
                    putExtra("answer",answer.text.toString().toInt())
                    putExtra("correct",(x.text.toString().toInt() + y.text.toString().toInt()))
                }
                startActivity(intent)
            }

        })

    }

    fun generate(){
        val ranx = (1..100).random()
        val rany = (1..100).random()
        x.text = ranx.toString()
        y.text = rany.toString()
    }
}