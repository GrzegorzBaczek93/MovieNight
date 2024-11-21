package com.baczek.movienight.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.baczek.movienight.domain.model.Asset
import com.baczek.movienight.domain.model.generateMockedAssets
import com.baczek.movienight.ui.theme.MovieNightTheme

@Composable
fun MovieListItem(
    modifier: Modifier = Modifier,
    data: Asset,
    onClick: (Int) -> Unit,
) {
    ListItem(
        modifier = modifier.clickable { onClick(data.id) },
        colors = ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            headlineColor = MaterialTheme.colorScheme.onSecondaryContainer,
            supportingColor = MaterialTheme.colorScheme.onSecondaryContainer,
        ),
        headlineContent = {
            Text(text = data.title)
        },
        supportingContent = {
            Text(text = data.description)
        },
        leadingContent = {
            MovieImage(url = data.image)
        },
    )
}

@Preview
@Composable
private fun MovieListItemPreview() {
    MovieNightTheme {
        val mock = generateMockedAssets().first()
        MovieListItem(
            data = mock,
            onClick = {},
        )
    }
}
