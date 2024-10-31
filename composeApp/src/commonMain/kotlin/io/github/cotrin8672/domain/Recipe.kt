package io.github.cotrin8672.domain

sealed class Recipe(
    val input: List<ItemStack>,
    val output: ItemStack,
    val byProduct: ItemStack = ItemStack.EMPTY,
    val machine: Machine,
)

sealed class BasicRecipe(
    input: List<ItemStack>,
    output: ItemStack,
    byProduct: ItemStack = ItemStack.EMPTY,
    machine: Machine,
) : Recipe(input, output, byProduct, machine)

sealed class AlternativeRecipe(
    input: List<ItemStack>,
    output: ItemStack,
    byProduct: ItemStack = ItemStack.EMPTY,
    machine: Machine,
) : Recipe(input, output, byProduct, machine)
