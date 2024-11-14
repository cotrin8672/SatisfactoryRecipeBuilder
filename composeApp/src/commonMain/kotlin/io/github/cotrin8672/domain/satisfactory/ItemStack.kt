package io.github.cotrin8672.domain.satisfactory

data class ItemStack(
    val item: Item,
    var quantity: Float,
) {
    constructor(item: Item, quantity: Int) : this(item, quantity.toFloat())
    constructor(item: Item, quantity: Double) : this(item, quantity.toFloat())

    companion object {
        val EMPTY = ItemStack(Item("empty", ""), 0)
    }

    operator fun plus(value: ItemStack): ItemStack {
        if (this.item != value.item) error("can't merge itemStack contains different item")
        return this.copy(quantity = this.quantity + value.quantity)
    }

    operator fun times(value: Float) = this.copy(quantity = this.quantity * value)
}
