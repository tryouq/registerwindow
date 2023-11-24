package com.example.registerwindow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemList: RecyclerView = findViewById(R.id.ItemList)
        val items = arrayListOf<Item>()

        items.add(Item(1, "sofa", "Sofa", "for relax and chill", "The sofa is designed for your relaxation, we will provide the best quality from the best materials, at an affordable price." ,200))
        items.add(Item(2, "light", "Light", "for light in your room", "You need the light to illuminate and improve your comfort, for our customers the best light.",35))
        items.add(Item(3, "kitchen", "Kitchen", "for cooking", "The kitchen is made of the best Russian materials, created for the comfort of a housewife, a stove, a dishwasher, a faucet, a refrigerator, everything is in full cosplect.",3500))
        items.add(Item(4, "shower", "Shower", "for clean your body", "For the best health of your body, convenient adjustment of water temperature, many different modes.",125))

        itemList.layoutManager = LinearLayoutManager(this)
        itemList.adapter = ItemsAdapter(items, this)
    }
}