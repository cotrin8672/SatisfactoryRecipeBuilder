package io.github.cotrin8672.domain

data class ItemStack(
    val item: Item,
    val quantity: Double,
) {
    constructor(item: Item, quantity: Int) : this(item, quantity.toDouble())

    companion object {
        val EMPTY = ItemStack(Item("empty"), 0)
    }

    operator fun times(value: Double) = this.copy(quantity = this.quantity * value)
}
