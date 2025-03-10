package com.example.gifter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val categoryName = intent.getStringExtra("CATEGORY_NAME")
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ProductAdapter(getProducts(categoryName))
        recyclerView.adapter = adapter
    }

    private fun getProducts(category: String?): List<Product> {
        return when (category) {
            "Flowers" -> listOf(
                Product("Rose", "$10", R.drawable.rose),
                Product("Tulip", "$12", R.drawable.tulip),
                Product("Sunflower", "$15", R.drawable.sunflower)
            )
            "Bouquets" -> listOf(
                Product("Rose Bouquet", "$25", R.drawable.rose_bouquet),
                Product("Lily Bouquet", "$25", R.drawable.lily_bouquet),
                Product("Mixed Flowers Bouquet", "$35", R.drawable.mixed_bouquet)
            )
            "Gifts" -> listOf(
                Product("Teddy Bear", "$15", R.drawable.teddy_bear),
                Product("Chocolates", "$15", R.drawable.chocolate_box),
                Product("Greeting Card", "$15", R.drawable.greeting_card)
            )
            else -> emptyList()
        }
    }
}
