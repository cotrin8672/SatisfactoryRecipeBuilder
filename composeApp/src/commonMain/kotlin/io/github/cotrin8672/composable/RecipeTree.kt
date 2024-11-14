package io.github.cotrin8672.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlin.math.atan2

@Composable
fun GraphEdge(
    start: Offset,
    end: Offset,
) {
    val length = (end - start).getDistance()
    val angle = (end - start).angle()

    Box(
        modifier = Modifier
            .graphicsLayer {
                translationX = start.x
                translationY = start.y
                rotationZ = angle
            }
            .width(length.dp)
            .height(2.dp)
            .background(color = MaterialTheme.colors.onBackground)
    )
}

fun Offset.angle() = Math.toDegrees(atan2(y.toDouble(), x.toDouble())).toFloat()
