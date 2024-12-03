package com.baczek.movienight.ui.component.asset

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import com.baczek.movienight.R

@Composable
fun AssetImage(
    modifier: Modifier = Modifier,
    url: String,
) {
    val painter = rememberAsyncImagePainter(model = url)
    val state = painter.state.collectAsStateWithLifecycle().value

    Box(
        modifier = modifier,
    ) {
        when (state) {
            is AsyncImagePainter.State.Empty,
            is AsyncImagePainter.State.Loading,
            -> {
                CircularProgressIndicator()
            }

            is AsyncImagePainter.State.Success -> {
                Image(
                    painter = painter,
                    contentDescription = null, // TODO: needs some proper content description for future
                )
            }

            is AsyncImagePainter.State.Error -> {
                Image(
                    painter = painterResource(R.drawable.ic_error),
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.error),
                    contentDescription = null, // TODO: needs some proper content description for future
                )
            }
        }
    }
}
