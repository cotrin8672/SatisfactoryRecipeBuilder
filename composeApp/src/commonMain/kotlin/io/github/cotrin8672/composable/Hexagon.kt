package io.github.cotrin8672.composable

import androidx.compose.runtime.Stable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

class Hexagon : Shape {
    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
        val path = Path()

        val radius = size.minDimension / 2
        val centerX = size.width / 2
        val centerY = size.height / 2

        path.moveTo(radius * cos(PI / 6).toFloat() + centerX, radius * sin(PI / 6).toFloat() + centerY)

        for (i in 1..5) {
            path.lineTo(
                radius * cos((1 + 2 * i) * PI / 6).toFloat() + centerX,
                radius * sin((1 + 2 * i) * PI / 6).toFloat() + centerY
            )
        }

        path.close()
        return Outline.Generic(path)
    }
}

@Stable
val HexagonShape = Hexagon()
