package com.example.gifter

data class Product(
    val name: String,
    val price: String,
    val imageResId: Int,
    var quantity: Int = 0 // Add this field
)