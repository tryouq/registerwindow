package com.example.registerwindow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Context


class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)



        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPassword: EditText = findViewById(R.id.edit_password_auth)
        val linkToReg: Button = findViewById(R.id.button_register)
        val button_auth: Button = findViewById(R.id.button_auth)





        linkToReg.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        button_auth.setOnClickListener {
            val login = userLogin.text.toString().trim()





            val pass = userPassword.text.toString().trim()

            if(login == "" || pass == ""){
                Toast.makeText(this, "you have wrong", Toast.LENGTH_SHORT).show()
            } else{


                val db =DbHelper(this, null)
                val isAuth = db.getUser(login, pass)



                if(isAuth){

                    Toast.makeText(this, "User $login is enter", Toast.LENGTH_SHORT).show()

                    val vv = Intent(this, BasketActivity::class.java)
                        intent.putExtra("UsernameLog", login)
                        startActivity(vv)








                    userLogin.text.clear()
                    userPassword.text.clear()
                    val ages = Intent(this, ItemsActivity::class.java)
                    startActivity(ages)

                } else{
                    Toast.makeText(this, "Not correct login or password", Toast.LENGTH_SHORT).show()

                }
                }


        }

    }



}