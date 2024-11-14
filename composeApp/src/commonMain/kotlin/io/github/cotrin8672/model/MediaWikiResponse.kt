package io.github.cotrin8672.model

import kotlinx.serialization.Serializable

@Serializable
data class MediaWikiResponse(
    val query: Query,
)

@Serializable
data class Query(
    val pages: Map<String, Page>,
)

@Serializable
data class Page(
    val pageid: Int,
    val ns: Int,
    val title: String,
    val imagerepository: String,
    val imageinfo: List<ImageInfo> = emptyList(),
)

@Serializable
data class ImageInfo(
    val url: String,
    val descriptionurl: String,
    val descriptionshorturl: String,
)

