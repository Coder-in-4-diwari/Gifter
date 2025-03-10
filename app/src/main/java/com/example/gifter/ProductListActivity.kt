package com.example.gifter

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        // Get the selected category from the intent
        val category = intent.getStringExtra("category")
        val tvCategory: TextView = findViewById(R.id.tvCategory)
        tvCategory.text = category

        // Set up RecyclerView with a grid layout (2 items per row)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        // Dummy data for products
        val products = when (category) {
            "Flowers" -> listOf(
                Product("Rose", "$10", R.drawable.rose),
                Product("Tulip", "$8", R.drawable.tulip),
                Product("Sunflower", "$12", R.drawable.sunflower)
            )
            "Bouquets" -> listOf(
                Product("Rose Bouquet", "$25", R.drawable.rose_bouquet),
                Product("Mixed Bouquet", "$30", R.drawable.mixed_bouquet),
                Product("Lily Bouquet", "$28", R.drawable.lily_bouquet)
            )
            "Gifts" -> listOf(
                Product("Chocolate Box", "$15", R.drawable.chocolate_box),
                Product("Teddy Bear", "$20", R.drawable.teddy_bear),
                Product("Greeting Card", "$5", R.drawable.greeting_card)
            )
            else -> emptyList()
        }

        // Set up the adapter
        val adapter = ProductAdapter(products) { product, quantity ->
            product.quantity = quantity
            if (quantity > 0) {
                Cart.addToCart(product)
            } else {
                Cart.removeFromCart(product)
                showAddDialog() // Show "Add" dialog when quantity is zero
            }
        }
        recyclerView.adapter = adapter
    }

    private fun showAddDialog() {
        AlertDialog.Builder(this)
            .setTitle("Add Item")
            .setMessage("Do you want to add this item to the cart?")
            .setPositiveButton("Yes") { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}