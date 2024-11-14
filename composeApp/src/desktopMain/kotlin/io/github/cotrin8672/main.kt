package io.github.cotrin8672

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.github.cotrin8672.composable.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "SatisfactoryRecipeBuilder",
    ) {
        App()
    }
}
