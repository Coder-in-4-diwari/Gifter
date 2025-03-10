package com.example.gifter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    private val products: List<Product>,
    private val onItemClick: (Product, Int) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProductImage: ImageView = itemView.findViewById(R.id.ivProductImage)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val btnAdd: Button = itemView.findViewById(R.id.btnAdd)
        val layoutQuantityControls: LinearLayout = itemView.findViewById(R.id.layoutQuantityControls)
        val btnDecrease: Button = itemView.findViewById(R.id.btnDecrease)
        val tvQuantity: TextView = itemView.findViewById(R.id.tvQuantity)
        val btnIncrease: Button = itemView.findViewById(R.id.btnIncrease)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.tvName.text = product.name
        holder.tvPrice.text = product.price
        holder.ivProductImage.setImageResource(product.imageResId)

        // Update UI based on quantity
        if (product.quantity == 0) {
            // Show "Add" button
            holder.btnAdd.visibility = View.VISIBLE
            holder.layoutQuantityControls.visibility = View.GONE

            // Handle "Add" button click
            holder.btnAdd.setOnClickListener {
                val newQuantity = 1
                onItemClick(product, newQuantity)
                notifyItemChanged(position) // Refresh the item
            }
        } else {
            // Show quantity controls
            holder.btnAdd.visibility = View.GONE
            holder.layoutQuantityControls.visibility = View.VISIBLE
            holder.tvQuantity.text = product.quantity.toString()

            // Handle decrease button click
            holder.btnDecrease.setOnClickListener {
                val newQuantity = product.quantity - 1
                if (newQuantity >= 0) {
                    onItemClick(product, newQuantity)
                    notifyItemChanged(position) // Refresh the item
                }
            }

            // Handle increase button click
            holder.btnIncrease.setOnClickListener {
                val newQuantity = product.quantity + 1
                onItemClick(product, newQuantity)
                notifyItemChanged(position) // Refresh the item
            }
        }
    }

    override fun getItemCount() = products.size
}