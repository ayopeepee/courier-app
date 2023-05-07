package com.example.delivery.model

object Size {
    const val SMALL = 10000
    const val BIG = 100000
    const val DOCUMENT_SIZE = 100
}


abstract class Package {
    abstract val size: Int
    abstract val fragility: Boolean
}