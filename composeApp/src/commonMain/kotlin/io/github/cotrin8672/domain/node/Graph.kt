package io.github.cotrin8672.domain.node

import io.github.cotrin8672.domain.satisfactory.AlternativeRecipe
import io.github.cotrin8672.domain.satisfactory.ItemStack
import io.github.cotrin8672.domain.satisfactory.Recipe
import io.github.cotrin8672.registry.Recipes

sealed class GraphNode(
    open val depth: Int,
)

data class Node(
    val recipe: Recipe,
    override val depth: Int,
) : GraphNode(depth) {

}

data object ByProductNode : GraphNode(0)

data object ObjectiveNode : GraphNode(0)

data class Edge(
    val from: Node,
    val to: GraphNode,
    val itemStack: ItemStack,
)

data class Graph(
    val nodes: MutableSet<GraphNode> = mutableSetOf(ByProductNode),
    val edges: MutableSet<Edge> = mutableSetOf(),
) {
    operator fun plus(node: Node): Graph {
        if (nodes.none { it is Node && it.recipe == node.recipe }) {
            nodes.add(node)
        }
        return this
    }

    operator fun plus(edge: Edge): Graph {
        val existingEdge =
            edges.find { it.from == edge.from && it.to == edge.to && it.itemStack.item == edge.itemStack.item }
        if (existingEdge != null) {
            existingEdge.itemStack.quantity += edge.itemStack.quantity
        } else edges.add(edge)
        return this
    }

    operator fun plusAssign(node: Node) {
        this + node
    }

    operator fun plusAssign(edge: Edge) {
        this + edge
    }
}

data class ConstructionContext(
    val alternativeRecipes: Set<AlternativeRecipe> = mutableSetOf(),
)

// 1.
fun buildGraph(vararg objective: ItemStack): Graph {
    val graph = Graph()

    fun construct(parentNode: GraphNode, vararg ingredients: ItemStack) {
        for (ingredient in ingredients) {
            val recipe = Recipes.getBasic(ingredient.item) ?: continue
            val node = Node(recipe, parentNode.depth + 1)
            val edge = Edge(
                from = node,
                to = parentNode,
                itemStack = ingredient.copy(quantity = recipe.getRequiredItemCount(ingredient.item))
            )

            graph += node
            graph += edge
            construct(node, *recipe.input.toTypedArray())
        }
    }

    construct(ObjectiveNode, *objective)
    return graph
}
