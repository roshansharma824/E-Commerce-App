package com.example.tummocandroidassignment.ui.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tummocandroidassignment.ui.data.local.dao.ProductDao
import com.example.tummocandroidassignment.ui.domain.model.ProductItem

@Database(entities = [ProductItem::class], version = 2)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

}