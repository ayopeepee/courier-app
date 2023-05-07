package com.example.delivery.model

data class BigPackage(
    override val size: Int = Size.BIG,
    override val fragility: Boolean,
    private val isCarNeeded: Boolean,
    private val weight: Int
) : Package() {
    override fun toString(): String {
        return "Big"
    }
}