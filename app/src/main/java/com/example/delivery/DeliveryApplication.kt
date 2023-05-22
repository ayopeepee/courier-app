package com.example.delivery

import android.app.Application
import com.example.delivery.database.OrdersRoomDatabase

class DeliveryApplication : Application() {
    val database: OrdersRoomDatabase by lazy { OrdersRoomDatabase.getDatabase(this) }
}