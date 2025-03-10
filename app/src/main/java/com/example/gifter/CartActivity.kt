package com.example.gifter

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        // Initialize views
        val recyclerViewCart: RecyclerView = findViewById(R.id.recyclerViewCart)
        val tvTotalPrice: TextView = findViewById(R.id.tvTotalPrice)
        val btnClearCart: TextView = findViewById(R.id.btnClearCart)

        // Set up RecyclerView
        recyclerViewCart.layoutManager = LinearLayoutManager(this)

        // Load cart items
        val cartItems = Cart.getCartItems()
        val adapter = CartAdapter(cartItems)
        recyclerViewCart.adapter = adapter

        // Calculate and display the total price
        updateTotalPrice()

        // Handle clear cart button click
        btnClearCart.setOnClickListener {
            Cart.clearCart()
            adapter.notifyDataSetChanged() // Refresh the RecyclerView
            updateTotalPrice()
        }
    }

    private fun updateTotalPrice() {
        var total = 0
        val breakdown = StringBuilder()

        for (item in Cart.getCartItems()) {
            val price = item.price.removePrefix("$").toInt()
            total += price * item.quantity
            breakdown.append("${item.name} (${item.quantity}): $${price * item.quantity}\n")
        }

        findViewById<TextView>(R.id.tvTotalPrice).text = "Total: $$total\n\nBreakdown:\n$breakdown"
    }
}