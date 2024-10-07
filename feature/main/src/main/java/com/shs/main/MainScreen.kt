package com.shs.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.shs.main.navigation.MainNavHost

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    MainNavHost(navigator = navController)
}