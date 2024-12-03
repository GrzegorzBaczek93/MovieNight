package com.baczek.movienight

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.baczek.movienight.ui.theme.MovieNightTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.generated.NavGraphs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieNightTheme {
                Scaffold { paddingValues ->
                    Box(
                        modifier = Modifier
                            .padding(paddingValues)
                            .consumeWindowInsets(paddingValues),
                    ) {
                        DestinationsNavHost(navGraph = NavGraphs.root)
                    }
                }
            }
        }
    }
}