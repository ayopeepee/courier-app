package com.example.delivery.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.delivery.database.order.Order

@Database(entities = [Order::class], version = 1, exportSchema = false)
abstract class OrdersRoomDatabase : RoomDatabase() {

    abstract fun orderDao(): OrderDao

    companion object {
        @Volatile
        private var INSTANCE: OrdersRoomDatabase? = null

        fun getDatabase(context: Context): OrdersRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    OrdersRoomDatabase::class.java,
                    "order_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}