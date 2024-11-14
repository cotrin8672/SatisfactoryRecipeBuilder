package io.github.cotrin8672.domain.satisfactory

sealed class Recipe(
    val name: String,
    val input: List<ItemStack>,
    val output: ItemStack,
    val byProduct: ItemStack = ItemStack.EMPTY,
    val machine: Machine,
) {
    fun getRequireMachineNumForObjective(itemStack: ItemStack): Float {
        return itemStack.quantity / output.quantity
    }

    fun getRequiredItemCount(item: Item): Float {
        val requiredItemStack = input.find { it.item == item }
        return requiredItemStack?.quantity ?: 0f
    }
}

class BasicRecipe(
    name: String,
    input: List<ItemStack>,
    output: ItemStack,
    byProduct: ItemStack = ItemStack.EMPTY,
    machine: Machine,
) : Recipe(name, input, output, byProduct, machine)

class AlternativeRecipe(
    name: String,
    input: List<ItemStack>,
    output: ItemStack,
    byProduct: ItemStack = ItemStack.EMPTY,
    machine: Machine,
) : Recipe(name, input, output, byProduct, machine)

data object ByProductOutputs : Recipe(
    name = "",
    input = listOf(),
    output = ItemStack.EMPTY,
    machine = Machine.Constructor
)
