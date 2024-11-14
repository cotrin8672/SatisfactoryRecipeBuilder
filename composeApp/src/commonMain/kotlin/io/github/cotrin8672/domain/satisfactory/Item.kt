package io.github.cotrin8672.domain.satisfactory

data class Item(
    val name: String,
    val id: String,
    val isNaturalResource: Boolean = false,
)
