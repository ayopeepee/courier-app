package com.example.delivery.model

data class Courier(
    private val name: String,
    private val bankAccount: String,
    private val opportunities: MutableList<String>,
    private val orders: Order
)