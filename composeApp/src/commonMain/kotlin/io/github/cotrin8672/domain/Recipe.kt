package io.github.cotrin8672.domain

sealed class Recipe(
    val name: String,
    val input: List<ItemStack>,
    val output: ItemStack,
    val byProduct: ItemStack = ItemStack.EMPTY,
    val machine: Machine,
)

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
