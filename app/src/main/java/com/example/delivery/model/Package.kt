package com.example.delivery.model

object Size {
    const val SMALL = 10000
    const val BIG = 100000
    const val DOCUMENT_SIZE = 100
}


abstract class Package {
    protected abstract val size: Int
    protected abstract val fragility: Boolean
}