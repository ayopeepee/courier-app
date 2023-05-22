package com.example.delivery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.delivery.database.OrderDao
import com.example.delivery.database.order.Order
import kotlinx.coroutines.launch

class DeliveryViewModel(private val orderDao: OrderDao) : ViewModel() {

    private fun insertOrder(order: Order) {
        viewModelScope.launch {
            orderDao.insert(order)
        }
    }

    fun isEntryValid(
        orderCompany: String,
        orderPackage: String,
        orderSender: String,
        orderReceiver: String,
        orderPrice: String,
        orderPlace: String
    ): Boolean {
        if (orderCompany.isBlank() || orderPackage.isBlank() || orderSender.isBlank()
            || orderReceiver.isBlank() || orderPrice.isBlank() || orderPlace.isBlank())
            return false
        return true
    }

    private fun getNewOrderEntry(
        orderCompany: String,
        orderPackage: String,
        orderSender: String,
        orderReceiver: String,
        orderPrice: String,
        orderPlace: String
    ): Order {
        return Order(
            companyName = orderCompany,
            packageType = orderPackage,
            senderAddress = orderSender,
            receiverAddress = orderReceiver,
            orderPrice = orderPrice.toInt(),
            orderPlaced = orderPlace.toBoolean()
        )
    }

    fun addNewOrder(
        orderCompany: String,
        orderPackage: String,
        orderSender: String,
        orderReceiver: String,
        orderPrice: String,
        orderPlace: String
    ) {
        val newOrder = getNewOrderEntry(
            orderCompany,
            orderPackage,
            orderSender,
            orderReceiver,
            orderPrice,
            orderPlace
        )
        insertOrder(newOrder)
    }
}

class DeliveryViewModelFactory(private val orderDao: OrderDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DeliveryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DeliveryViewModel(orderDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}