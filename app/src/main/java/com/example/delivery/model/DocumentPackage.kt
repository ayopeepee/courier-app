package com.example.delivery.model

data class DocumentPackage(
    override val size: Int = Size.DOCUMENT_SIZE,
    override val fragility: Boolean,
    private val sender: String,
    private val recipient: String
) : Package()