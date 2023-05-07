package com.example.delivery.model



data class SmallPackage(
    override val size: Int = Size.SMALL,
    override val fragility: Boolean
): Package() {
    override fun toString(): String {
        return "Small"
    }
}