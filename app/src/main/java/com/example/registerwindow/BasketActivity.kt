package com.example.registerwindow

import android.annotation.SuppressLint
import android.os.Bundle
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences
import android.util.Log


class BasketActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket)



        val name: TextView = findViewById(R.id.User_profile)
        val button_buy: Button = findViewById(R.id.button_buy_basket)
        var full_price: TextView = findViewById(R.id.Full_price)

        name.text = intent.getStringExtra("UsernameLog")











}
}