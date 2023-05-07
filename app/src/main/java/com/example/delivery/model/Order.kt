package com.example.delivery.model

data class Order(
    val company: Company,
    val _package: Package,
    val from: String,
    val to: String,
    val price: Int


)