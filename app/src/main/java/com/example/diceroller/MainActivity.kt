package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton1: Button = findViewById(R.id.button)
        val rollButton2 : Button= findViewById(R.id.button2)
        val resetbutton : Button= findViewById(R.id.button3)
        val times1 :TextView=findViewById(R.id.textView7)
        val times2 :TextView=findViewById(R.id.textView8)
        var count1=0
        var count2=0
        rollButton1.setOnClickListener {
            rollDice()
            count1+= 1
            times1.text =count1.toString()
        }
        rollButton2.setOnClickListener {
            rolldice2()
            count2+=1
            times2.text =count2.toString()
        }
        resetbutton.setOnClickListener {
            count1=0
            count2=0
            times1.text = (" ").toString()
            times2.text=(" ").toString()
            }
    }
    private fun rolldice2() {
        val dice=Dice(6)
        val diceroll2=dice.roll()
        val restxt2 : TextView = findViewById(R.id.textView3)
        val diceImage1: ImageView =findViewById(R.id.imageView3)
        restxt2.text=diceroll2.toString()
        val diceimg1 = when(diceroll2)
        {
            1->(R.drawable.dice_1)
            2->(R.drawable.dice_2)
            3->(R.drawable.dice_3)
            4->(R.drawable.dice_4)
            5->(R.drawable.dice_5)
            else ->(R.drawable.dice_6)
        }
        diceImage1.setImageResource(diceimg1)
    }
    private fun rollDice() {
        val dice = Dice(6)
        val diceroll1 = dice.roll()
        val restxt1: TextView = findViewById(R.id.textView)
        val diceImage: ImageView =findViewById(R.id.imageView)
        diceImage.contentDescription = diceroll1.toString()
        restxt1.text = diceroll1.toString()
        val diceimg = when(diceroll1)
        {
            1->(R.drawable.dice_1)
            2->(R.drawable.dice_2)
            3->(R.drawable.dice_3)
            4->(R.drawable.dice_4)
            5->(R.drawable.dice_5)
            else ->(R.drawable.dice_6)
        }
        diceImage.setImageResource(diceimg)
    }
}
class Dice(private val side: Int) {
    fun roll(): Int {
        return (1..side).random()
    }
}