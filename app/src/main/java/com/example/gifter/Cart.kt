package com.example.gifter

object Cart {
    private val items = mutableListOf<Product>()

    fun addToCart(product: Product) {
        val existingProduct = items.find { it.name == product.name }
        if (existingProduct != null) {
            // If the product already exists, increase its quantity
            existingProduct.quantity++
        } else {
            // If the product is new, add it to the cart with quantity 1
            items.add(product.copy(quantity = 1))
        }
    }

    fun removeFromCart(product: Product) {
        items.removeAll { it.name == product.name }
    }

    fun getCartItems(): List<Product> {
        return items.toList()
    }

    fun clearCart() {
        items.clear()
    }
}