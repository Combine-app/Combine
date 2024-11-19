package com.combine.base.ui.images

import androidx.compose.foundation.Image
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.ImageLoader
import coil3.compose.LocalPlatformContext
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.svg.SvgDecoder
import org.jetbrains.compose.resources.DrawableResource

@Composable
fun SvgImage(
    resource: DrawableResource,
    modifier: Modifier,
) {
    val context = LocalPlatformContext.current
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context)
            .data(resource)
            .build(),
        imageLoader = ImageLoader.Builder(context)
            .components {
                add(SvgDecoder.Factory())
            }
            .build()
    )

    Icon(
        painter = painter,
        contentDescription = null,
        modifier = modifier,
    )
}