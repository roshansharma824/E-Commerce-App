package com.example.tummocandroidassignment.ui.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tummocandroidassignment.ui.utils.Constants.PRODUCT_DATABASE_TABLE

@Entity(tableName = PRODUCT_DATABASE_TABLE)
data class ProductItem(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,

    val icon: String,
    val unit: String,
    val price: Double,
    val nutritions: String,
    val review: Double,
    var isCart: Boolean = false,
    var isFavorite:Boolean = false,
    var quantity:Int = 1,
    val categories:String ,
)