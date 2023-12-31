package com.example.kotlincompose.starbucks.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlincompose.starbucks.screens.HomeScreen
import com.example.kotlincompose.starbucks.screens.ProductDetailScreen
import com.example.kotlincompose.starbucks.screens.SplashScreen

@Composable
fun StarBucksNavigation(){

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = splashScreen ){
        composable(splashScreen){
            SplashScreen(navHostController)
        }

        composable(home){
            HomeScreen(navHostController)
        }
        composable(product_detail){
            ProductDetailScreen(navHostController)
        }
    }


}
const val splashScreen = "SplashScreen";
const val home = "Home";
const val product_detail = "ProductDetails";
