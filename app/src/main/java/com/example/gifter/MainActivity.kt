package com.example.gifter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val fabCart: FloatingActionButton = findViewById(R.id.fabCart)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CategoryAdapter(getCategories())
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

        fabCart.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
    }

    private fun getCategories(): List<Category> {
        return listOf(
            Category("Flowers", R.drawable.flowers, ProductListActivity::class.java, "Flowers"),
            Category("Bouquets", R.drawable.bouquet, ProductListActivity::class.java, "Bouquets"),
            Category("Gifts", R.drawable.gifts, ProductListActivity::class.java, "Gifts")
        )
    }

}