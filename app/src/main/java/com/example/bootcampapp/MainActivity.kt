package com.example.bootcampapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MainActivity : AppCompatActivity() {

    //var textView : TextView ? = null
    // null de bir değişken ve kotlin null tanımlaması yapmadan da
    // variable tanimlamamizi lateinit ifadesi ile saglar
    lateinit var textView : TextView
    lateinit var buttonDegistir : Button
    lateinit var diceButton: Button
    lateinit var diceImage : ImageView
    lateinit var sendButton: Button
    lateinit var sendText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // val name : Name (altinda ALT+ENTER kombinasyonuyla vereceğimiz id widget import ederiz)
        textView = findViewById(R.id.textView)
        buttonDegistir = findViewById(R.id.buttonDegistir)
        diceButton = findViewById(R.id.diceButton)
        diceImage = findViewById(R.id.diceImage)
        sendText = findViewById(R.id.sendText)
        sendButton = findViewById(R.id.sendButton)

        // butona tiklama
        // var olarak global olarak cagirdigimiz icin devamli degismekte random
        buttonDegistir.setOnClickListener {
            changeText()
        }

        diceButton.setOnClickListener {
            changeView()
        }

        sendButton.setOnClickListener {
            sendText()
        }
    }
/*
    override fun onStart() {
        super.onStart()
        println("OnStart called")
    }

    override fun onResume() {
        super.onResume()
        println("OnResume called")
    }

    override fun onPause() {
        super.onPause()
        println("OnPause called")
    }

    override fun onStop() {
        super.onStop()
        println("OnStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("OnDestroy called")
    }

 */

    private fun changeText(){

        val randomNumber = (10..99).random()
        textView.text = "Random "+randomNumber.toString()+" :D" // ile integer casting ediyoruz stringe
    }

    private fun changeView(){

        val randomNumber = (1..6).random()
        // image primitive type degil, bu yuzden kaynak tutucularini referans alarak tanimlariz
        val drawableResource = when(randomNumber){

            //kotlinde if else ifadeleri ok isaretleri ile when seklinde ifade edilebiliyor
            1 -> R.drawable.dice01
            2 -> R.drawable.dice02
            3 -> R.drawable.dice03
            4 -> R.drawable.dice04
            5 -> R.drawable.dice05
            else -> R.drawable.dice06
        }

        diceImage.setImageResource(drawableResource)

        textView.text = randomNumber.toString()

        // toast mesaji verme kotlinde
        // materialDesign, kullaniciya mesaj gonderme
        Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
    }

    private fun sendText(){
        // iki sayfa arasi gecisi 5 yontemle saglanir
        //Intent        //Bundle        //Serializable        //Parcelable        //Singleton
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("send",sendText.text.toString())
        startActivity(intent)

    }
}