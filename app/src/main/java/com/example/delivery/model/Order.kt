package com.example.delivery.model

data class Order(
    private val company: Company,
    private val _package: Package,
    private val from: String,
    private val to: String,
    private val price: Int
)