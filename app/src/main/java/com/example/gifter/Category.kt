package com.example.gifter

import android.app.Activity

data class Category(
    val name: String,
    val imageResId: Int,
    val activity: Class<out Activity>,
    val categoryName: String
)
