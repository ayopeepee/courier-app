package com.example.delivery.database.order

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class Order(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @NonNull @ColumnInfo(name = "company_name") val companyName: String,
    @NonNull @ColumnInfo(name = "package_type") val packageType: String,
    @NonNull @ColumnInfo(name = "sender_address") val senderAddress: String,
    @NonNull @ColumnInfo(name = "receiver_address") val receiverAddress: String,
    @NonNull @ColumnInfo(name = "order_price") val orderPrice: Int,
    @NonNull @ColumnInfo(name = "order_placed") val orderPlaced: Boolean
)