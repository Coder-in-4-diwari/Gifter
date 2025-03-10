package com.example.gifter

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnFlowers: Button = findViewById(R.id.btnFlowers)
        val btnBouquets: Button = findViewById(R.id.btnBouquets)
        val btnGifts: Button = findViewById(R.id.btnGifts)
        val fabCart: FloatingActionButton = findViewById(R.id.fabCart)

        btnFlowers.setOnClickListener {
            val intent = Intent(this, ProductListActivity::class.java)
            intent.putExtra("category", "Flowers")
            startActivity(intent)
        }

        btnBouquets.setOnClickListener {
            val intent = Intent(this, ProductListActivity::class.java)
            intent.putExtra("category", "Bouquets")
            startActivity(intent)
        }

        btnGifts.setOnClickListener {
            val intent = Intent(this, ProductListActivity::class.java)
            intent.putExtra("category", "Gifts")
            startActivity(intent)
        }

        fabCart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }
    }
}