package com.shs.news.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.shs.news.NewsRoute
import com.shs.ui.navigation.Route


fun NavGraphBuilder.newsNavGraph(
    onNewsClick : (String) -> Unit,
) {
    composable<Route.Nes> {
        NewsRoute(
            onNewsClick = onNewsClick,
        )
    }
}