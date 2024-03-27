package com.example.demo1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView


//customize outfit
class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val topsList = listOf(R.drawable.shirt1, R.drawable.shirt2, R.drawable.shirt3)
        val bottomsList = listOf(R.drawable.pants1, R.drawable.pants2, R.drawable.pants3)
        val shoeList = listOf(R.drawable.shoes1, R.drawable.shoes2, R.drawable.shoes3)

        val top : ImageView = findViewById(R.id.topsImage)
        val bottom : ImageView = findViewById(R.id.bottomsImage)
        val shoe : ImageView = findViewById(R.id.shoesImage)

        top.setImageResource(R.drawable.shirt1)
        bottom.setImageResource(R.drawable.pants1)
        shoe.setImageResource(R.drawable.shoes1)

        var topNum = 0
        var bottomNum = 0
        var shoeNum = 0

        top.setOnClickListener {
            top.setImageResource(topsList.get(index = topNum))
            topNum += 1
            if (topNum >= (topsList.size)) {
                topNum = 0
            }
        }
        bottom.setOnClickListener {
            bottom.setImageResource(bottomsList.get(index = bottomNum))
            bottomNum += 1
            if (bottomNum >= (bottomsList.size)) {
                bottomNum = 0
            }
        }
        shoe.setOnClickListener {
            shoe.setImageResource(shoeList.get(index = shoeNum))
            shoeNum += 1
            if (shoeNum >= (shoeList.size)) {
                shoeNum = 0
            }
        }

        var button : Button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


        /*val editText: EditText = findViewById(R.id.editText)
        val button : Button = findViewById(R.id.button)
        val textView : TextView = findViewById(R.id.textView)

        button.setOnClickListener {
            val currentText : String = editText.text.toString()
            Log.d("DebugEditText", currentText)
            textView.text = currentText
        }*/
    }
}