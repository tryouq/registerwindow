package com.example.registerwindow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.edit_email)
        val userPassword: EditText = findViewById(R.id.edit_password)
        val button: Button = findViewById(R.id.button_reg)
        val linktoAuth: Button = findViewById(R.id.button_auth)

        linktoAuth.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPassword.text.toString().trim()

            if(login == "" || email == "" || pass == ""){
                Toast.makeText(this, "you have wrong", Toast.LENGTH_SHORT).show()
            } else{
                val user = User(login, email, pass)

                val db =DbHelper(this, null)
                db.addUsers(user)
                Toast.makeText(this, "User is accept", Toast.LENGTH_SHORT).show()
                userLogin.text.clear()
                userEmail.text.clear()
                userPassword.text.clear()

            }
        }

    }
}