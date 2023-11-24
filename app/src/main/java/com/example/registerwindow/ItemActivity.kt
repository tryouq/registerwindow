package com.example.registerwindow

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.razorpay.Checkout
import org.json.JSONObject

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        Checkout.preload(applicationContext)
        val co = Checkout()

        // ...

        co.setKeyID("rzp_test_zWO9Oz62PWwiGR");

        val title: TextView = findViewById(R.id.item_list_title_one)
        val desc: TextView = findViewById(R.id.item_list_text)
        val price: TextView = findViewById(R.id.item_list_price)
        val btn: Button = findViewById(R.id.button_buy)

        title.text = intent.getStringExtra("itemTitle")
        desc.text = intent.getStringExtra("itemDesc")
        price.text = intent.getStringExtra("itemPrice")

        btn.setOnClickListener {
            startPayment()
        }

    }

    private fun startPayment() {

        val activity: Activity = this
        val co = Checkout()

        try {
            val options = JSONObject()
            options.put("name","Tryouq guider")
            options.put("description","Demoing Charges")
            //You can omit the image option to fetch the image from the dashboard
            options.put("image","https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg")
            options.put("theme.color", "#3399cc");
            options.put("currency","USD");
            options.put("order_id", "order_N4PO6IOn0NZJAw");
            options.put("amount",10000)

        //dsadsa

            co.open(activity,options)
        }catch (e: Exception){
            Toast.makeText(activity,"Error in payment: "+ e.message,Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }
}