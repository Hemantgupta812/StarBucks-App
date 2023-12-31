package com.example.kotlincompose.starbucks.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.kotlincompose.starbucks.components.LogoComponent
import com.example.kotlincompose.starbucks.navigation.home
import com.example.kotlincompose.ui.theme.Background
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    navHostController: NavHostController
){
    
    LaunchedEffect(key1 = Unit){
        delay(2000)
        navHostController.navigate(home)
    }

    
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background), contentAlignment = Alignment.Center){
        LogoComponent()
    }


}