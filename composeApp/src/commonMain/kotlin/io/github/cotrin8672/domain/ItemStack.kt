package io.github.cotrin8672.domain

data class ItemStack(
    val item: Item,
    val quantity: Double,
) {
    companion object {
        val EMPTY = ItemStack(Item("empty"), 0.0)
    }

    operator fun times(value: Double) = this.copy(quantity = this.quantity * value)
}
