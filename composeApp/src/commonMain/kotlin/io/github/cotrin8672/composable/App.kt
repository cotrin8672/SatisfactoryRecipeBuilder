package io.github.cotrin8672.composable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import io.github.cotrin8672.domain.node.Graph
import io.github.cotrin8672.domain.node.Node
import io.github.cotrin8672.domain.node.buildGraph
import io.github.cotrin8672.domain.satisfactory.ItemStack
import io.github.cotrin8672.ktorModule
import io.github.cotrin8672.registry.Items
import io.github.cotrin8672.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import kotlin.math.exp
import kotlin.math.sign

@Composable
@Preview
fun App() {
    val graph = buildGraph(ItemStack(item = Items.highSpeedConnector, quantity = 10))
    KoinApplication(
        application = {
            modules(ktorModule)
        }
    ) {
        AppTheme(darkTheme = true) {
            Scaffold {
                Box(modifier = Modifier.fillMaxSize(0.8f), contentAlignment = Alignment.Center) {
                    GraphViewport(graph)
                }
            }
        }
    }
    println(graph)
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun GraphViewport(graph: Graph) {
    var scale by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    var contentSize by remember { mutableStateOf(IntSize.Zero) }
    val nodeOffset by remember { mutableStateOf(mutableMapOf<Node, Offset>()) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(width = 8.dp, color = Color.Red)
            .clipToBounds()
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, _, _ ->
                    offset += pan
                }
            }
            .onPointerEvent(PointerEventType.Scroll) {
                val change = it.changes.first()
                val delta = change.scrollDelta.y.toInt().sign

                scale = (scale * exp(-delta * 0.1f)).coerceIn(0.25f, 3.75f)
            },
//            .graphicsLayer {
//                translationX = offset.x
//                translationY = offset.y
//            },
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(contentSize.width.dp, contentSize.height.dp)
        ) {
            graph.edges.forEach {
                val startOffset = nodeOffset[it.from] ?: return@forEach
                val endOffset = nodeOffset[it.to] ?: return@forEach
                drawLine(
                    color = Color.Blue,
                    start = startOffset,
                    end = endOffset,
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .scale(scale)
                .offset(offset.x.dp, offset.y.dp)
                .background(color = Color.Red.copy(alpha = 0.3f))
                .onGloballyPositioned {
                    contentSize = it.size
                }
        ) {
            val nodeList = graph.nodes.filterIsInstance<Node>().groupBy {
                it.depth
            }.values.toList().map { it.sortedBy { node -> node.depth } }
            nodeList.reversed().forEach { sameDepthNodes ->
                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    sameDepthNodes.forEach { node ->
                        BadgedMachineIcon(
                            recipe = node.recipe,
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .onGloballyPositioned {
                                    val upperLeftPos = it.positionInWindow()
                                    val centerPos = Offset(
                                        x = upperLeftPos.x + it.size.width / 2,
                                        y = upperLeftPos.y + it.size.height / 2
                                    )
                                    nodeOffset[node] = centerPos
                                }
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NodeTreeCanvas(graph: Graph) {
    var scale by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(width = 8.dp, color = Color.Red)
            .clipToBounds()
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, _, _ ->
                    offset += pan
                }
            }
            .onPointerEvent(PointerEventType.Scroll) {
                val change = it.changes.first()
                val delta = change.scrollDelta.y.toInt().sign

                scale = (scale * exp(-delta * 0.1f)).coerceIn(1f, 3.75f)
            }
            .graphicsLayer {
                translationX = offset.x
                translationY = offset.y
            },
        contentAlignment = Alignment.Center
    ) {
        var contentSize by remember { mutableStateOf(IntSize.Zero) }
        val nodeOffset by remember { mutableStateOf(mutableMapOf<Node, Offset>()) }

        Canvas(
            modifier = Modifier
                .size(contentSize.width.dp, contentSize.height.dp)
                .scale(scale)
                .background(color = Color.Red.copy(alpha = 0.3f))
        ) {
            graph.edges.forEach {
                val startOffset = nodeOffset[it.from] ?: Offset(0f, 0f)
                val endOffset = nodeOffset[it.to] ?: Offset(0f, 0f)
                drawLine(
                    color = Color.Blue,
                    start = startOffset,
                    end = endOffset,
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .scale(scale)
                .onGloballyPositioned {
                    contentSize = it.size
                }
        ) {
            val nodeList = graph.nodes.filterIsInstance<Node>().groupBy {
                it.depth
            }.values.toList().map { it.sortedBy { node -> node.depth } }

            for (sameDepthNodes in nodeList) {
                Row(
                    modifier = Modifier.fillMaxHeight(1 / nodeList.size.toFloat()),
                ) {
                    sameDepthNodes.forEach { node ->
                        BadgedMachineIcon(
                            recipe = node.recipe,
                            modifier = Modifier
                                .padding(30.dp)
                                .fillMaxHeight(1 / sameDepthNodes.size.toFloat())
                                .onGloballyPositioned {
                                    nodeOffset[node] = it.positionInParent()
                                }
                        )
                    }
                }
            }
        }
    }
}

