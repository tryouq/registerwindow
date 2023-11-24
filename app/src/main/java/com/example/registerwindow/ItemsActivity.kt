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

        items.add(Item(1, "sofa", "Диван", "for relax and chill", 200))
        items.add(Item(2, "light", "Свет", "for light in your room", 35))
        items.add(Item(3, "kitchen", "Кухня", "for cooking", 3500))
        items.add(Item(4, "shower", "Душ", "for clean your body", 125))

        itemList.layoutManager = LinearLayoutManager(this)
        itemList.adapter = ItemsAdapter(items, this)
    }
}