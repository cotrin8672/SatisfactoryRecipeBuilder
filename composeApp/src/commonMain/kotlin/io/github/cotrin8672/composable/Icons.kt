package io.github.cotrin8672.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Badge
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import coil3.PlatformContext
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.size.Size
import io.github.cotrin8672.domain.satisfactory.Item
import io.github.cotrin8672.domain.satisfactory.ItemStack
import io.github.cotrin8672.domain.satisfactory.Machine
import io.github.cotrin8672.domain.satisfactory.Recipe
import io.github.cotrin8672.model.MediaWikiResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import org.koin.compose.koinInject
import kotlin.math.sqrt

@Composable
fun BadgedMachineIcon(
    recipe: Recipe,
    modifier: Modifier = Modifier,
) {
    BadgedIcon(
        id = recipe.machine.id,
        name = recipe.machine.name,
        text = "${recipe.output.quantity}",
        textSize = 20.sp,
        shape = HexagonShape,
        modifier = modifier
    )
}

@Composable
fun BadgedItemIcon(
    itemStack: ItemStack,
    modifier: Modifier = Modifier,
) {
    BadgedIcon(
        id = itemStack.item.id,
        name = itemStack.item.name,
        text = "${itemStack.quantity}",
        textSize = 16.sp,
        modifier = modifier,
    )
}

@Composable
fun BadgedIcon(
    id: String,
    name: String,
    text: String,
    textSize: TextUnit,
    shape: Shape = CircleShape,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.TopEnd
    ) {
        BorderedItemIcon(
            id = id,
            name = name,
            shape = shape,
        )
        Badge(
            backgroundColor = MaterialTheme.colors.primary,
            modifier = Modifier.clip(CircleShape)
        ) {
//            Text(
//                text = text,
//                fontSize = textSize,
//                modifier = Modifier
//            )
        }
    }
}

@Composable
fun MachineIcon(
    machine: Machine,
    modifier: Modifier = Modifier,
) {
    BorderedItemIcon(
        id = machine.id,
        name = machine.name,
        shape = HexagonShape,
        modifier = modifier
    )
}

@Composable
fun ItemIcon(
    item: Item,
    modifier: Modifier = Modifier,
) {
    BorderedItemIcon(
        id = item.id,
        name = item.name,
        modifier = modifier
    )
}

@Composable
fun ContentIcon(
    id: String,
    name: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        val client = koinInject<HttpClient>()
        var imageUrl by remember { mutableStateOf<String?>(null) }

        LaunchedEffect(id) {
            val response = client.get("https://satisfactory.wiki.gg/api.php") {
                parameter("action", "query")
                parameter("titles", "File:$id.png")
                parameter("prop", "imageinfo")
                parameter("iiprop", "url")
                parameter("format", "json")
            }.body<MediaWikiResponse>()
            imageUrl = response.query.pages.values.toList().getOrNull(0)?.imageinfo?.getOrNull(0)?.url
        }

        if (imageUrl != null) {
            AsyncImage(
                model = ImageRequest.Builder(context = PlatformContext.INSTANCE)
                    .data(imageUrl)
                    .size(Size.ORIGINAL)
                    .build(),
                contentDescription = name,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
        } else {
            CircularProgressIndicator(modifier = Modifier.fillMaxSize(0.5f))
        }
    }
}

@Composable
fun BorderedItemIcon(
    id: String,
    name: String,
    shape: Shape = CircleShape,
    modifier: Modifier = Modifier,
) {
    var boxSize by remember { mutableStateOf(0) }

    Box(
        modifier = modifier
            .aspectRatio(1f)
            .fillMaxSize()
            .clip(shape)
            .background(color = MaterialTheme.colors.primary)
            .onGloballyPositioned {
                boxSize = it.size.width
            },
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .clip(shape)
                .fillMaxSize(0.9f)
                .background(color = MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            ContentIcon(
                id = id,
                name = name,
                modifier = Modifier.fillMaxSize(0.25f * sqrt(6f))
            )
        }
    }
}
