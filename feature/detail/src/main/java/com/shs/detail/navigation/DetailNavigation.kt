package com.shs.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.shs.detail.DetailRoute
import com.shs.ui.navigation.Route

fun NavController.navigationDetail(pk : String){
    navigate(Route.Detail(pk = pk))
}

fun NavGraphBuilder.detailNavGraph(){
    composable<Route.Detail> { navBackStackEntry ->
        val pk = navBackStackEntry.toRoute<Route.Detail>().pk
        DetailRoute(pk = pk)
    }
}