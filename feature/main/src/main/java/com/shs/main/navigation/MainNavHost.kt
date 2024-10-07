package com.shs.main.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.shs.detail.navigation.detailNavGraph
import com.shs.detail.navigation.navigationDetail
import com.shs.news.navigation.newsNavGraph
import com.shs.ui.navigation.Route

@Composable
internal fun MainNavHost(
    modifier: Modifier = Modifier,
    navigator : NavHostController
){
    Box(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight())
    {
        NavHost(
            navController = navigator,
            startDestination = Route.Nes
        ){
            newsNavGraph(
                onNewsClick = {
                    navigator.navigationDetail(pk = it)
                }
            )
            detailNavGraph()
        }
    }
}